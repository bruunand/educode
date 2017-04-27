package com.educode.events;

import com.educode.types.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zen on 4/26/17.
 */
public class RobotDeathEvent extends EventTypeBase
{
    @Override
    public List<Type> getRequiredParameters()
    {
        return new ArrayList<>();
    }

    @Override
    public String getName()
    {
        return "RobotDeath";
    }
}
