package com.educode.minecraft;

import com.educode.runtime.IExecutableReturns;

public class Command
{
    private final IExecutableReturns _executable;
    private Object _result;
    private boolean _executed = false;

    public Command(IExecutableReturns executable)
    {
        _executable = executable;
    }

    public IExecutableReturns getExecutable()
    {
        return _executable;
    }

    public synchronized Object getResult()
    {
        // Wait for execution
        while (!_executed)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        return _result;
    }

    public synchronized void setResult(Object result)
    {
        _executed = true;
        _result = result;
        notify();
    }
}
