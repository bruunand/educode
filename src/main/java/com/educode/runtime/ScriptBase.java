package com.educode.runtime;

import com.educode.minecraft.Command;
import com.educode.minecraft.entity.EntityRobot;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class ScriptBase implements IRobot
{
    private World _world;
    private EntityRobot _scriptedEntity;
    private EntityPlayer _player;
    private Random _rand = new Random();

    protected final ScriptBase robot = this;

    public void init(World world, EntityPlayer player)
    {
        this._world = world;
        this._player = player;

        _scriptedEntity = new EntityRobot(_world, player);
        BlockPos spawnPosition = this._player.getPosition();
        do
        {
        	this._scriptedEntity.setPosition(spawnPosition.getX() + world.rand.nextInt(5), spawnPosition.getY(), spawnPosition.getZ() + world.rand.nextInt(5));
        	
            switch (_world.rand.nextInt() % 4)
            {
                case 0:
                    spawnPosition = spawnPosition.west();
                    break;
                case 1:
                    spawnPosition = spawnPosition.east();
                    break;
                case 2:
                    spawnPosition = spawnPosition.north();
                    break;
                case 3:
                    spawnPosition = spawnPosition.south();
                    break;
            }
        } while (!this._scriptedEntity.getCanSpawnHere());
        this._world.spawnEntity(_scriptedEntity);
    }

    public ExtendedCollection<Float> range(float min, float max)
    {
        ExtendedCollection<Float> ret = new ExtendedCollection<Float>();

        for (float c = min; c <= max; c++)
            ret.addItem(c);

        return ret;
    }

    public float abs(float value)
    {
        return Math.abs(value);
    }

    public float random(float min, float max)
    {
        return (max - min) * _rand.nextFloat() + min;
    }

    @Override
    public boolean isRobot()
    {
        return true;
    }

    public void wait(float time)
    {
        try
        {
            Thread.sleep((long) time);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public synchronized Command queueAndWait()
    {
        try
        {
            Command newCommand = new Command();
            this._scriptedEntity.CommandQueue.add(newCommand);
            newCommand.waitForCanExecute();
            return newCommand;
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void setWorldTime(float time)
    {
        Command command = queueAndWait();

        _world.setWorldTime((long) time % 24000);

        command.setHasBeenExecuted(true);
    }

    public void say(String notifyString)
    {
        Command command = queueAndWait();

        _player.sendMessage(new TextComponentString(_scriptedEntity.getFormatting()+ "[" + _scriptedEntity.getName() + "]" + " " + TextFormatting.RESET + " " + notifyString));

        command.setHasBeenExecuted(true);
    }

    public void selfDestruct()
    {
        explode(0.0F);
        removeEntity();
    }

    public void explode(float strength)
    {
        Command command = queueAndWait();

        _world.createExplosion(this._scriptedEntity, getX(), getY(), getZ(), strength, this._world.getGameRules().getBoolean("mobGriefing"));

        command.setHasBeenExecuted(true);
    }

    private void removeEntity()
    {
        Command command = queueAndWait();

        _world.removeEntity(_scriptedEntity);

        command.setHasBeenExecuted(true);
    }

    public void dropItems()
    {
        Command command = queueAndWait();

        _scriptedEntity.dropItems();

        command.setHasBeenExecuted(true);
    }

    public float getX()
    {
        return (float) _scriptedEntity.posX;
    }

    public float getY()
    {
        return (float) _scriptedEntity.posY;
    }

    public float getZ()
    {
        return (float) _scriptedEntity.posZ;
    }

    @Override
    public Coordinates getCoordinates()
    {
        return new Coordinates(_scriptedEntity.getPosition());
    }

    @Override
    public void attack(MinecraftEntity entity)
    {
        if (this._scriptedEntity.isDead)
            return;

        //turn and face entity
        this._scriptedEntity.faceEntity(entity.getWrappedEntity(), 360.0f, 360.0f);

        //attack target
        if (this.getDistanceTo(entity) < 3.0)
        {
            // calculate damage
            float damage = 1.0F + _scriptedEntity.getHeldItem(EnumHand.MAIN_HAND).getItemDamage();

            //swing animation
            this._scriptedEntity.swingArm(EnumHand.MAIN_HAND);

            //give damage;
            entity.getWrappedEntity().attackEntityFrom(DamageSource.causeMobDamage(_scriptedEntity), damage);
        }

        wait(350F);
    }

    @Override
    public float getDistanceTo(MinecraftEntity entity)
    {
    	return _scriptedEntity.getDistanceToEntity(entity.getWrappedEntity());
    }

    private synchronized void walkToEntity(MinecraftEntity entity)
    {
        navigateToBlock(entity.getWrappedEntity().getPosition());
    }

    @Override
    public synchronized void walkTo(Coordinates coords)
    {
        navigateToBlock(coords.toBlockPos());
    }
    
    private synchronized void navigateToBlock(BlockPos pos)
    {
        Command command = queueAndWait();
        _scriptedEntity.getNavigator().clearPathEntity();
        _scriptedEntity.getNavigator().setPath(_scriptedEntity.getNavigator().getPathToPos(pos), 0.5D);
        command.setHasBeenExecuted(true);

        wait(500F);
    }

    @Override
    public synchronized ExtendedCollection<MinecraftEntity> getNearbyEntities()
    {
        Command command = queueAndWait();

        ExtendedCollection<MinecraftEntity> returnList = new ExtendedCollection<>();
        for (Entity entity : this._world.getEntitiesWithinAABB(EntityLiving.class, this._scriptedEntity.getEntityBoundingBox().expand(30, 5, 30)))
        {
            if (entity.equals(this._scriptedEntity) || entity.equals(this._player))
                continue;

            returnList.addItem(new MinecraftEntity(entity));
        }

        command.setHasBeenExecuted(true);

        return returnList;
    }

    @Override
    public MinecraftEntity getOwner()
    {
        return new MinecraftEntity(this._player);
    }

    @Override
    public void move(String direction)
    {
        BlockPos targetPosition = _scriptedEntity.getPosition();
        switch (direction.toLowerCase())
        {
            case "north":
                targetPosition = targetPosition.north();
                break;
            case "south":
                targetPosition = targetPosition.south();
                break;
            case "east":
                targetPosition = targetPosition.east();
                break;
            case "west":
                targetPosition = targetPosition.west();
                break;
            default:
                say(String.format("Unknown direction '%s'!", direction));
                return;
        }
        
        navigateToBlock(targetPosition);
    }

    @Override
    public String toString()
    {
        return this._scriptedEntity.getName();
    }

    @Override
    public float getHealth()
    {
        return this._scriptedEntity.getHealth();
    }


    @Override
    public void mine(String direction)
    {
    	mine(direction, 0);
    }
    
    private void mine(String direction, int yModifier)
    {
        BlockPos targetBlockPosition = _scriptedEntity.getPosition();
        if (yModifier != 0)
        	targetBlockPosition = targetBlockPosition.add(0, yModifier, 0);
        
        switch (direction)
        {
            case "down":
                targetBlockPosition = targetBlockPosition.down();
                break;
            case "up":
                targetBlockPosition = targetBlockPosition.up(2);
                break;
            case "north":
                faceAndMine((targetBlockPosition = targetBlockPosition.north()));
                break;
            case "south":
                faceAndMine((targetBlockPosition = targetBlockPosition.south()));
                break;
            case "east":
                faceAndMine((targetBlockPosition = targetBlockPosition.east()));
                break;
            case "west":
                faceAndMine((targetBlockPosition = targetBlockPosition.west()));
                break;
            default:
                say(String.format("Unknown direction '%s'!", direction));
                return;
        }
        
        if (!direction.equals("up") && !direction.equals("down"))
            targetBlockPosition = targetBlockPosition.up();
        
        faceAndMine(targetBlockPosition);
    }
    
    private void faceAndMine(BlockPos position)
    {
        if (_world.isAirBlock(position))
            return;
        
        // face(position);
        mineBlock(position);
    }
    
    private synchronized void mineBlock(BlockPos position)
    {
        int waitingTime = 1;
        Command command = queueAndWait();

        if (_world.destroyBlock(position, true))
            waitingTime = 500;
        
        command.setHasBeenExecuted(true);
        
        try
        {
            wait(waitingTime);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
    public abstract void main();
}
