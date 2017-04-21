package com.educode.runtime.types;

import java.util.ArrayList;

/**
 * Created by User on 18-Apr-17.
 */
public class ExtendedCollection<E> extends ArrayList<E> implements ICollection<E>
{
    @Override
    public ExtendedCollection<ExtendedCollection<Float>> test()
    {
        return null;
    }

    @Override
    public void removeItemAt(float index)
    {
        remove((int) index);
    }

    @Override
    public E getItemAt(float index)
    {
        return super.get((int) index);
    }

    @Override
    public void addItem(E item)
    {
        super.add(item);
    }

    @Override
    public E setItemAt(float index, E item)
    {
        super.set((int) index, item);
        return item;
    }

    @Override
    public float getSize()
    {
        return size();
    }
}
