package com.educode.runtime.types;

import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Created by User on 18-Apr-17.
 */
public class ExtendedCollection<E> extends ArrayList<E> implements ICollection<E>
{
    public ExtendedCollection()
    {
    }

    public ExtendedCollection(E ... args)
    {
        for (E item : args)
            add(item);
    }

    @Override
    public String toString()
    {
        StringJoiner joiner = new StringJoiner(", ");

        for (Object item : this)
            joiner.add(item.toString());

        return String.format("{%s}", joiner);
    }

    @Override
    public void removeItemAt(double index)
    {

        remove((int) index);
    }

    @Override
    public E getItemAt(double index)
    {
        if ((int) index >= size() || index < 0)
            throw new RuntimeException("Index was out of range.");

        return super.get((int) index);
    }

    @Override
    public void addItem(E item)
    {
        super.add(item);
    }

    @Override
    public E setItemAt(double index, E item)
    {
        if ((int) index >= size() || index < 0)
            throw new RuntimeException("Index was out of range.");

        super.set((int) index, item);
        return item;
    }

    @Override
    public double getSize()
    {
        return size();
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof ExtendedCollection)
        {
            ExtendedCollection collection = (ExtendedCollection) o;

            // If size is not the same, they are not equal
            if (this.getSize() != collection.getSize())
                return false;

            // Iterate over items
            for (int i = 0; i < this.getSize(); i++)
            {
                Object ownObj   = this.get(i);
                Object otherObj = collection.get(i);

                if (!ownObj.equals(otherObj))
                    return false;
            }

            return true;
        }

        return false;
    }
}
