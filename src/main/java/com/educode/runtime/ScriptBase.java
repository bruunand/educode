package com.educode.runtime;

import com.educode.minecraft.Command;
import com.educode.minecraft.entity.EntityRobot;
import com.educode.runtime.types.Coordinates;
import com.educode.runtime.types.ExtendedCollection;
import com.educode.runtime.types.IRobot;
import com.educode.runtime.types.MinecraftEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public abstract class ScriptBase implements IRobot
{
    private World _world;
    private EntityRobot _robot;
    private EntityPlayer _player;
    private Random _rand = new Random();

    protected final ScriptBase robot = this;

    public void init(World world, EntityPlayer player)
    {
        this._world = world;
        this._player = player;

        _robot = new EntityRobot(_world, player);
        BlockPos spawnPosition = this._player.getPosition();
        do
        {
        	this._robot.setPosition(spawnPosition.getX() + world.rand.nextInt(3), spawnPosition.getY(), spawnPosition.getZ() + world.rand.nextInt(3));
        	
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
        } while (!this._robot.getCanSpawnHere() && _robot.getPosition().equals(_player.getPosition()));
        this._world.spawnEntity(_robot);
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

    public synchronized Command queueAndAwait()
    {
        try
        {
            Command newCommand = new Command();
            this._robot.CommandQueue.add(newCommand);
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
        executeOnTick(() -> _world.setWorldTime((long) time % 24000));
    }

    public void say(String message)
    {
        executeOnTick(() -> _robot.sendMessageTo(_player, message));
    }

    public void selfDestruct()
    {
        explode(0.0F);
        removeEntity();
    }

    public void explode(float strength)
    {
        boolean mobGriefingEnabled = this._world.getGameRules().getBoolean("mobGriefing");
        executeOnTick(() -> _world.createExplosion(this._robot, getX(), getY(), getZ(), strength, mobGriefingEnabled));
    }

    private void removeEntity()
    {
        executeOnTick(() -> _world.removeEntity(_robot));
    }

    public void dropItems()
    {
        executeOnTick(() -> _robot.dropItems());
    }

    public float getX()
    {
        return (float) _robot.posX;
    }

    public float getY()
    {
        return (float) _robot.posY;
    }

    public float getZ()
    {
        return (float) _robot.posZ;
    }

    @Override
    public Coordinates getCoordinates()
    {
        return new Coordinates(_robot.getPosition());
    }

    @Override
    public boolean attack(MinecraftEntity entity)
    {
        if (this._robot.isDead || this.getDistanceTo(entity) > 3.0F)
            return false;

        executeOnTick(() -> _robot.attackEntity(entity.getWrappedEntity()));
        wait(350F);

        return true;
    }

    private synchronized Object executeOnTick(IExecutableReturns executable)
    {
        Command command = queueAndAwait();

        Object executionResult = executable.execute();

        command.setHasBeenExecuted(true);

        return executionResult;
    }

    private synchronized void executeOnTick(IExecutable executable)
    {
        Command command = queueAndAwait();

        executable.execute();

        command.setHasBeenExecuted(true);
    }

    @Override
    public float dropInventoryItem(String name, final float quantity)
    {
        return (float) executeOnTick(() -> _robot.dropInventoryItem(name, quantity));
    }

    @Override
    public float getDistanceTo(MinecraftEntity entity)
    {
    	return _robot.getDistanceToEntity(entity.getWrappedEntity());
    }

    private void walkToEntity(MinecraftEntity entity)
    {
        navigateToBlock(entity.getWrappedEntity().getPosition());
    }

    @Override
    public void walkTo(Coordinates coords)
    {
        navigateToBlock(coords.toBlockPos());
    }
    
    private void navigateToBlock(BlockPos pos)
    {
        executeOnTick(() ->
        {
            _robot.getNavigator().clearPathEntity();
            _robot.getNavigator().setPath(_robot.getNavigator().getPathToPos(pos), 0.5D);
        });

        wait(500F);
    }

    @Override
    public ExtendedCollection<MinecraftEntity> getNearbyEntities()
    {
        return (ExtendedCollection<MinecraftEntity>) executeOnTick(() ->
        {
            ExtendedCollection<MinecraftEntity> returnList = new ExtendedCollection<>();
            for (Entity entity : this._world.getEntitiesWithinAABB(EntityLiving.class, this._robot.getEntityBoundingBox().expand(30, 5, 30)))
            {
                if (entity.equals(this._robot) || entity.equals(this._player))
                    continue;

                returnList.addItem(new MinecraftEntity(entity));
            }

            return returnList;
        });
    }

    @Override
    public MinecraftEntity getOwner()
    {
        return new MinecraftEntity(this._player);
    }

    @Override
    public void move(String direction)
    {
        BlockPos targetPosition = _robot.getPosition();
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
        return this._robot.getName();
    }

    @Override
    public float getHealth()
    {
        return this._robot.getHealth();
    }


    @Override
    public void mine(String direction)
    {
    	mine(direction, 0);
    }
    
    private void mine(String direction, int yModifier)
    {
        BlockPos targetBlockPosition = _robot.getPosition();
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
    
    private void mineBlock(BlockPos position)
    {
        boolean blockDestroyed = (boolean) executeOnTick(() -> _world.destroyBlock(position, true));
        if (blockDestroyed)
            wait(500F);
    }
    
    public abstract void main();
}
