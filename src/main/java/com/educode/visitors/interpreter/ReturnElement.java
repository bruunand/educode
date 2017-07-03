package com.educode.visitors.interpreter;

/**
 * Created by User on 03-Jul-17.
 */
class ReturnElement
{
    private final Object _contained;

    public ReturnElement(Object contained)
    {
        this._contained = contained;
    }

    public Object getContained()
    {
        return this._contained;
    }
}
