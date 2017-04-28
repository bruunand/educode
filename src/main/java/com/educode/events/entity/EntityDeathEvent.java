package com.educode.events.entity;

import com.educode.events.EventTypeBase;
import com.educode.types.Type;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zen on 4/27/17.
 */
public class EntityDeathEvent extends EventTypeBase
{
    @Override
    public List<Type> getRequiredParameters()
    {
        return Arrays.asList(Type.EntityType);
    }

    @Override
    public String getName()
    {
        return "EntityDeath";
    }
}
