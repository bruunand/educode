package com.educode.runtime.events;

import com.educode.nodes.ungrouped.EventDefinitionNode;
import com.educode.runtime.ScriptBase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by zen on 4/27/17.
 */
public class EventInvoker
{
    public static void invokeByType(ScriptBase script, Class<?> eventType, Object ... args)
    {
        List<EventDefinitionNode> eventDefinitions = script.getEventDefinitions();
        if (eventDefinitions == null)
            return;

        for (EventDefinitionNode eventDef : eventDefinitions)
        {
            if (eventDef.getEventType().getClass() != eventType)
                continue;

            EventInvoker.invokeByName(script, eventDef.getName(), args);
        }
    }

    public static void invokeByName(ScriptBase script, String methodName, Object ... args)
    {
        // Gets class of each argument
        Class[] classArray = new Class[args.length];
        for (int i = 0; i < args.length; i++)
            classArray[i] = args[i].getClass();

        // Find the appropriate event and invokeByName it
        try
        {
            Method invokeMethod = script.getClass().getMethod(methodName, classArray);

            // Invoke method from a different thread
            // TODO: Would be better if it did not run in parallel
            Thread methodInvocationThread = new Thread(() ->
            {
                try
                {
                    invokeMethod.invoke(script, args);
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
}
