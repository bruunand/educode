package com.educode.runtime;

public class TickCommand
{
    private final IExecutableReturns _executable;
    private Object _result;
    private boolean _executed = false;

    public TickCommand(IExecutableReturns executable)
    {
        _executable = executable;
    }

    public IExecutableReturns getExecutable()
    {
        return _executable;
    }

    public synchronized Object getResult() throws InterruptedException
    {
        while (!_executed)
            wait();

        return _result;
    }

    public synchronized void setResult(Object result)
    {
        _executed = true;
        _result = result;
        notify();
    }
}
