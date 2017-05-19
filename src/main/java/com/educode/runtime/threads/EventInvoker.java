package com.educode.runtime.threads;

import com.educode.runtime.EventInvocation;
import com.educode.runtime.ProgramBase;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by User on 29-Apr-17.
 */
public class EventInvoker extends Thread
{
    private final ProgramBase _program;

    public EventInvoker(ProgramBase program)
    {
        this._program = program;
    }

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                EventInvocation invocation = this._program.getEventQueue().take();
                invocation.getMethod().invoke(_program, invocation.getArguments());
            }
        }
        catch (IllegalAccessException | InterruptedException | InvocationTargetException e)
        {
            System.out.println("Event invoker thread exiting.");
        }
    }
}