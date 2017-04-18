package com.educode.nodes.base;

import com.educode.Typeable;
import com.educode.nodes.Visitable;
import com.educode.types.Type;
import com.educode.visitors.ASTBuilder;

/**
 * Created by zen on 3/8/17.
 */
public abstract class Node implements Visitable, Typeable
{
    private int _lineNumber;
    private Type _type = Type.Error;

    protected Node()
    {
        this._lineNumber = ASTBuilder.getLineNumber();
    }

    public int getLineNumber()
    {
        return this._lineNumber;
    }

    public Type getType()
    {
        return this._type;
    }

    public void setType(Type type)
    {
        this._type = type;
    }

    public boolean isType(Type type)
    {
        return getType().equals(type);
    }
}