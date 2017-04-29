package com.educode.runtime.threads;

import com.educode.runtime.EventInvocation;
import com.educode.runtime.ScriptBase;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by User on 29-Apr-17.
 */
public class EventInvoker extends Thread
{
    private final ScriptBase _child;

    public EventInvoker(ScriptBase child)
    {
        this._child = child;
    }

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                EventInvocation invocation = this._child.getEventQueue().take();
                invocation.getMethod().invoke(_child, invocation.getArguments());
            }
        }
        catch (IllegalAccessException | InterruptedException | InvocationTargetException e)
        {
            System.out.println("Event invoker thread interrupted.");
            e.printStackTrace();
        }
    }
}