package com.educode.minecraft.entity;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.educode.minecraft.Command;
import com.educode.minecraft.CompilerMod;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IWorldNameable;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityRobot extends EntityCreature implements IWorldNameable, IEntityAdditionalSpawnData
{
    public BlockingQueue<Command> CommandQueue = new ArrayBlockingQueue<Command>(16);

    private final InventoryBasic _inventory;

    private String _name = "Unnamed";
    
    private int _tickCounter = 0;
    
    public EntityRobot(World worldIn)
    {
        super(worldIn);

        this.setSize(0.6F, 1.8F);
        this.setCanPickUpLoot(true);
        this._inventory = new InventoryBasic("Items", false, 4);
    }
    
    public EntityRobot(World worldIn, EntityPlayer owner)
    {
    	this(worldIn);

    	_name = CompilerMod.NAMES[this.rand.nextInt(CompilerMod.NAMES.length)] + " @ " + owner.getName();
    	CompilerMod.CHILD_ENTITIES.add(this.getUniqueID());
    }

    @Override
    public void onEntityUpdate()
    {
        this.updateArmSwingProgress();
        
    	// Remove entity if not spawned in this server instance
    	if (this._tickCounter++ == 0 && !this.world.isRemote && !CompilerMod.CHILD_ENTITIES.contains(this.getUniqueID()))
    	{
    		this.world.removeEntity(this);
    		return;
    	}

        // Poll next command
        // Only one command is executed at a time
        Command nextCommand = CommandQueue.poll();
        if (nextCommand != null)
        {
            nextCommand.setCanExecute(true);
            
            try
            {
                nextCommand.waitForHasBeenExecuted();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        
        super.onEntityUpdate();
    }
    
    @Override
    public void onDeath(DamageSource cause)
    {
        super.onDeath(cause);

        // Drop items on death
        dropItems();
    }

    public void dropItems()
    {
        for (int i = 0; i < getInventory().getSizeInventory(); i++)
        {
            ItemStack stack = getInventory().getStackInSlot(i);
            getInventory().removeStackFromSlot(i);
            dropItem(stack.getItem(), stack.getCount());
        }
    }

    @Override
    protected void updateEquipmentIfNeeded(EntityItem itemEntity)
    {
        if (isDead) return;

        ItemStack entityItem = getInventory().addItem(itemEntity.getEntityItem());

        this.onItemPickup(itemEntity, entityItem.getCount());
    }
    
    public TextFormatting getFormatting()
    {
        int modHash = Math.abs(getName().hashCode()) % 5;
        
        switch (modHash)
        {
            case 0:
                return TextFormatting.BLUE;
            case 1:
                return TextFormatting.GREEN;
            case 2:
                return TextFormatting.RED;
            case 3:
                return TextFormatting.YELLOW;
            case 4:
                return TextFormatting.GREEN;
        }
        
        return TextFormatting.RESET;
    }
    

    public InventoryBasic getInventory()
    {
        return _inventory;
    }
    
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(128.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.7D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
    }

    public void readEntityFromNBT(NBTTagCompound compound)
    {
    	super.readEntityFromNBT(compound);
    	
    	if (compound.hasKey("name"))
        	_name = compound.getString("name");
    }

    public void writeEntityToNBT(NBTTagCompound compound)
    {
    	super.writeEntityToNBT(compound);
    	compound.setString("name", "Anders");
    }
    
    @Override
    public String getName()
    {
        return _name;
    }

    @Override
    public boolean hasCustomName()
    {
        return true;
    }
    
    @Override
    public ITextComponent getDisplayName()
    {
        return new TextComponentString(getFormatting() + getName());
    }

    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_SHEEP_AMBIENT;
    }

    protected SoundEvent getHurtSound()
    {
        return SoundEvents.ENTITY_SHEEP_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_SHEEP_DEATH;
    }

    protected SoundEvent getStepSound()
    {
        return SoundEvents.ENTITY_SHEEP_STEP;
    }

	public void playSound(SoundEvent sound)
	{
		world.playSound(this.posX, this.posY, this.posZ, sound, SoundCategory.HOSTILE, this.getSoundVolume(), this.getSoundPitch(), false);
	}

	@Override
	public void writeSpawnData(ByteBuf buffer)
	{
		ByteBufUtils.writeUTF8String(buffer, _name);
	}

	@Override
	public void readSpawnData(ByteBuf additionalData)
	{
		_name = ByteBufUtils.readUTF8String(additionalData);
	}
}
