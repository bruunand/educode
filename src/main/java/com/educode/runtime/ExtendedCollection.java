package com.educode.runtime;

import java.util.ArrayList;

/**
 * Created by User on 18-Apr-17.
 */
public class ExtendedCollection<E> extends ArrayList<E> implements ICollection<E>
{
    @Override
    public void removeAt(float index)
    {
        remove((int) index);
    }

    @Override
    public E getItemAt(float index)
    {
        return get((int) index);
    }

    @Override
    public void addItem(E item)
    {
        super.add(item);
    }

    @Override
    public float getSize()
    {
        return size();
    }
}
