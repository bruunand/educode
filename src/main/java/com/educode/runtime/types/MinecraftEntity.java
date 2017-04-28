package com.educode.runtime.types;

import com.educode.minecraft.entity.EntityRobot;
import com.educode.runtime.types.Coordinates;
import com.educode.runtime.types.IEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by User on 13-Apr-17.
 */
public class MinecraftEntity implements IEntity
{
    private Entity _wrappedEntity;

    public MinecraftEntity(Entity wrappedEntity)
    {
        this._wrappedEntity = wrappedEntity;
    }

    public Entity getWrappedEntity()
    {
        return this._wrappedEntity;
    }

    @Override
    public String toString()
    {
        return getWrappedEntity().getName();
    }

    @Override
    public Coordinates getCoordinates()
    {
        return new Coordinates(getWrappedEntity().getPosition());
    }

    @Override
    public boolean isRobot()
    {
        return getWrappedEntity() instanceof EntityRobot;
    }

    @Override
    public boolean isPlayer()
    {
        return getWrappedEntity() instanceof EntityPlayer;
    }

    @Override
    public float getHealth()
    {
        if (!(getWrappedEntity() instanceof EntityLivingBase))
            return -1;
        else
            return ((EntityLivingBase) getWrappedEntity()).getHealth();
    }

    @Override
    public float getX()
    {
        return (float) getWrappedEntity().posX;
    }

    @Override
    public float getY()
    {
        return (float) getWrappedEntity().posY;
    }

    @Override
    public float getZ()
    {
        return (float) getWrappedEntity().posZ;
    }
}
