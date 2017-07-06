package com.educode.visitors.interpreter;

/**
 * Created by User on 03-Jul-17.
 */
class ReturnFlag extends JumpFlag
{
    private final Object _contained;

    public ReturnFlag(Object contained)
    {
        this._contained = contained;
    }

    public Object getContained()
    {
        return this._contained;
    }
}
