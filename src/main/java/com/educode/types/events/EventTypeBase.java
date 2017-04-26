package com.educode.types.events;

import com.educode.runtime.ScriptBase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by zen on 4/26/17.
 */
public abstract class EventTypeBase
{
    public abstract List<com.educode.types.Type> getRequiredParameters();
    public abstract String getName();

    public void invokeFor(ScriptBase script, String methodName, Object ... params)
    {
        Class[] classArray = new Class[params.length];
        for (int i = 0; i < params.length; i++)
            classArray[i] = params[i].getClass();

        // Find the appropriate event and invoke it
        try
        {
            Method invokeMethod = script.getClass().getMethod(methodName, classArray);
            invokeMethod.invoke(script, params); // todo: invoke in other thread
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public String toString()
    {
        return this.getName();
    }
}
