package com.educode.nodes.base;

import com.educode.nodes.Visitable;
import com.educode.visitors.ASTBuilder;

/**
 * Created by zen on 3/8/17.
 */
public abstract class Node implements Visitable
{
    private int _lineNumber;

    protected Node()
    {
        this._lineNumber = ASTBuilder.getLineNumber();
    }

    public int getLineNumber()
    {
        return this._lineNumber;
    }
}