package com.educode.events.entity.robot;

import com.educode.events.EventTypeBase;
import com.educode.types.Type;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zen on 7/10/17.
 */
public class RobotPickedUpItemEvent extends EventTypeBase
{
    @Override
    public List<Type> getRequiredParameters()
    {
        return Arrays.asList(Type.ItemType);
    }

    @Override
    public String getName()
    {
        return "RobotPickedUpItem";
    }
}