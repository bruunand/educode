package com.educode.nodes.base;

import com.educode.nodes.Visitable;

/**
 * Created by zen on 3/8/17.
 */
public abstract class Node implements Visitable
{
    private int _lineNumber;

    public int getLineNumber()
    {
        return this._lineNumber;
    }
}