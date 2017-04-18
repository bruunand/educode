package com.educode.runtime;

import net.minecraft.entity.Entity;

/**
 * Created by User on 13-Apr-17.
 */
public class MinecraftEntity
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
}
