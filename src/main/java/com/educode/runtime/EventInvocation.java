package com.educode.runtime;

import java.lang.reflect.Method;

/**
 * Created by User on 29-Apr-17.
 */
public class EventInvocation
{
    private final Method _method;
    private final Object[] _arguments;

    public EventInvocation(Method method, Object ... arguments)
    {
        this._method = method;
        this._arguments = arguments;
    }

    public Method getMethod()
    {
        return this._method;
    }

    public Object[] getArguments()
    {
        return this._arguments;
    }
}
