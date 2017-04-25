package com.educode.runtime.types;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

/**
 * Created by zen on 4/24/17.
 */
public class MinecraftItem implements IItem
{
    private final ItemStack _wrappedItem;

    public MinecraftItem()
    {
        this._wrappedItem = new ItemStack(Blocks.AIR);
    }

    public MinecraftItem(ItemStack item)
    {
        this._wrappedItem = item;
    }

    public ItemStack getWrappedItem()
    {
        return this._wrappedItem;
    }

    @Override
    public String toString()
    {
        return this.getWrappedItem().getDisplayName();
    }

    @Override
    public int getCount()
    {
        return this.getWrappedItem().getCount();
    }
}
