package com.educode.runtime.types;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Created by User on 18-Apr-17.
 */
public class ExtendedList<E> extends ArrayList<Object> implements IList
{
    public ExtendedList()
    {
    }

    public ExtendedList(Object ... args)
    {
        this.addAll(Arrays.asList(args));
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
    public void removeItemAt(Double index)
    {
        remove(index.intValue());
    }

    @Override
    public Object getItemAt(Double index)
    {
        if (index.intValue() >= size() || index < 0)
            throw new RuntimeException("Index was out of range.");

        return super.get(index.intValue());
    }

    @Override
    public void addItem(Object item)
    {
        super.add(item);
    }

    @Override
    public Object setItemAt(Double index, Object item)
    {
        if (index.intValue() >= size() || index < 0)
            throw new RuntimeException("Index was out of range.");

        super.set(index.intValue(), item);
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
        if (o instanceof ExtendedList)
        {
            ExtendedList collection = (ExtendedList) o;

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
