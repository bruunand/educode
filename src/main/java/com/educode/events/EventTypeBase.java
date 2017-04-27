package com.educode.events;

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

            // Invoke method from a different thread, todo: find a better way to execute this
            Thread methodInvocationThread = new Thread(() ->
            {
                try
                {
                    invokeMethod.invoke(script, params);
                }
                catch (IllegalAccessException | InvocationTargetException e)
                {
                    e.printStackTrace();
                }
            });
            methodInvocationThread.setName(String.format("EVENT - %s", methodName));
            methodInvocationThread.start();
        }
        catch (NoSuchMethodException e)
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
