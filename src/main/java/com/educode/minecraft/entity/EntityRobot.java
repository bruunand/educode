package com.educode.minecraft.entity;

import com.educode.events.achievements.AchievementEvent;
import com.educode.events.entity.robot.RobotAttackedEvent;
import com.educode.minecraft.CompilerMod;
import com.educode.runtime.ProgramBase;
import com.educode.events.EventInvoker;
import com.educode.events.entity.robot.RobotDeathEvent;
import com.educode.runtime.types.MinecraftEntity;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorldNameable;
import net.minecraft.world.World;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

import io.netty.buffer.ByteBuf;
import javax.annotation.Nullable;

public class EntityRobot extends EntityCreature implements IWorldNameable, IEntityAdditionalSpawnData
{
    private final InventoryBasic _inventory;

    private String _name = "Unnamed";
    
    private int _tickCounter = 0;

    private TextFormatting _textFormatting = TextFormatting.RESET;

    private ProgramBase _parent;

    private long _lastAttackAt = 0;

    @Override
    protected boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        this.sendMessageTo(player, "REEEEEEEEEEE!");
        return super.processInteract(player, hand);
    }

    public EntityRobot(World worldIn)
    {
        super(worldIn);

        this.setSize(0.6F, 1.8F);
        this.setCanPickUpLoot(true);
        this._inventory = new InventoryBasic("Items", false, 36);

        PathNavigateGround navigator = (PathNavigateGround) this.getNavigator();
        navigator.setEnterDoors(true);
        navigator.setCanSwim(true);
    }

    @Override
    public void setDead()
    {
        super.setDead();
    }

    public EntityRobot(ProgramBase parent, World worldIn, EntityPlayer owner)
    {
    	this(worldIn);

    	this._parent = parent;
    	this._name = String.format("%s (%s)", parent.getProgramName(), owner.getName());
    	CompilerMod.CHILD_ENTITIES.add(this.getUniqueID());
        updateTextFormatting();
    }

    @Override
    public void onLivingUpdate()
    {
        // Remove entity if not spawned in this server instance
        if (!this.world.isRemote)
        {
            if (this._tickCounter++ == 0 && !CompilerMod.CHILD_ENTITIES.contains(this.getUniqueID()))
                this.world.removeEntity(this);
        }

        super.onLivingUpdate();
        this.updateArmSwingProgress();
    }
    
    @Override
    public void onDeath(DamageSource cause)
    {
        super.onDeath(cause);

        // Don't execute on client side
        if (world.isRemote)
            return;

        // Invoke on death event
        EventInvoker.invokeByType(this._parent, RobotDeathEvent.class);

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
        if (isDead)
            return;

        ItemStack entityItem = getInventory().addItem(itemEntity.getEntityItem());

        this.onItemPickup(itemEntity, entityItem.getCount());
    }

    @Override
    protected boolean canDespawn()
    {
        return _parent == null || _parent.getMainThread().isInterrupted();

    }

    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
    {
        return super.onInitialSpawn(difficulty, livingdata);
    }

    public void updateTextFormatting()
    {
        int modHash = Math.abs(getName().hashCode()) % 5;
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));

        switch (modHash)
        {
            case 0:
                this._textFormatting = TextFormatting.BLUE;
            case 1:
                this._textFormatting = TextFormatting.GREEN;
            case 2:
                this._textFormatting = TextFormatting.RED;
            case 3:
                this._textFormatting = TextFormatting.YELLOW;
            case 4:
                this._textFormatting = TextFormatting.GREEN;
        }
    }

    public InventoryBasic getInventory()
    {
        return _inventory;
    }
    
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(256.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.7D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D);
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
        return new TextComponentString(this.getFormatting() + getName());
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
		this.updateTextFormatting();
	}

    public TextFormatting getFormatting()
    {
        return this._textFormatting;
    }

    public void attackEntity(Entity otherEntity)
    {
        if (otherEntity.equals(this) || isDead || otherEntity.isDead || System.currentTimeMillis() - _lastAttackAt < 500)
            return;

        // update last attack time
        _lastAttackAt = System.currentTimeMillis();

        // turn and face entity
        this.getMoveHelper().strafe(0.01F, 0.01F);
        this.faceEntity(otherEntity, 90.0F, 90.0F);

        // calculate damage
        float damage = (float) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
        if (otherEntity instanceof EntityLivingBase)
            damage += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((EntityLivingBase) otherEntity).getCreatureAttribute());

        // swing animation
        this.swingArm(EnumHand.MAIN_HAND);

        // give damage;
        otherEntity.attackEntityFrom(DamageSource.causeMobDamage(this), damage);

        if(!world.isRemote)
        {
            MinecraftForge.EVENT_BUS.post(new AchievementEvent.RobotActionEvent(_parent.getPlayer(), "attack"));
        }
    }

    public float dropInventoryItem(String name, double quantity)
    {
        int i = 0;
        float droppedItems = 0;

        while (i < getInventory().getSizeInventory() && droppedItems < quantity)
        {
            ItemStack stack = getInventory().getStackInSlot(i++);
            if (!stack.getDisplayName().equalsIgnoreCase(name))
                continue;

            // Don't drop more than needed
            int maxCount = Math.min(stack.getCount(), (int)(quantity - droppedItems));

            // Drop items on ground and reduce stack count
            dropItem(stack.getItem(), maxCount);
            getInventory().decrStackSize(i - 1, maxCount);

            droppedItems += maxCount;
        }

        return droppedItems;
    }

    public boolean sendMessageTo(EntityPlayer player, String message)
    {
        player.sendMessage(new TextComponentString(this.getFormatting()+ "[" + this.getName() + "]" + " " + TextFormatting.RESET + " " + message));

        if(!world.isRemote)
        {
            MinecraftForge.EVENT_BUS.post(new AchievementEvent.RobotChatEvent(player, message));
        }

        return true;
    }

    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);

        if (compound.hasKey("name"))
            _name = compound.getString("name");
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (!world.isRemote)
        {
            Entity sourceEntity = source.getEntity();

            if (sourceEntity != null)
                EventInvoker.invokeByType(this._parent, RobotAttackedEvent.class, new MinecraftEntity(sourceEntity));
        }

        return super.attackEntityFrom(source, amount);
    }

    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setString("name", this._name);
    }

    public void setSpawnPosition(EntityPlayer player)
    {
        BlockPos spawnPosition = player.getPosition();
        do
        {
            this.setPosition(spawnPosition.getX() + world.rand.nextInt(5), spawnPosition.getY(), spawnPosition.getZ() + world.rand.nextInt(5));

            switch (getEntityWorld().rand.nextInt() % 4)
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
        } while (!this.getCanSpawnHere() && this.getPosition().equals(player.getPosition()));
    }
}
