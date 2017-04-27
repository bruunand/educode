package com.educode.events;

import java.util.List;

/**
 * Created by zen on 4/26/17.
 */
public abstract class EventTypeBase
{
    public abstract List<com.educode.types.Type> getRequiredParameters();
    public abstract String getName();

    @Override
    public String toString()
    {
        return this.getName();
    }
}
