package com.educode.runtime.threads;

import com.educode.runtime.EventInvocation;
import com.educode.runtime.ScriptBase;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by User on 29-Apr-17.
 */
public class EventInvoker extends Thread
{
    private final ScriptBase _script;

    public EventInvoker(ScriptBase script)
    {
        this._script = script;
    }

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                EventInvocation invocation = this._script.getEventQueue().take();
                invocation.getMethod().invoke(_script, invocation.getArguments());
            }
        }
        catch (IllegalAccessException | InterruptedException | InvocationTargetException e)
        {
            System.out.println("Event invoker thread exiting.");
        }
    }
}