package com.educode.nodes.base;

import com.educode.nodes.ITypeable;
import com.educode.nodes.IVisitable;
import com.educode.types.Type;
import com.educode.visitors.ASTBuilder;

/**
 * Created by zen on 3/8/17.
 */
public abstract class Node implements IVisitable, ITypeable
{
    private int _lineNumber;
    private Node _parent;
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

    public Node getParent()
    {
        return this._parent;
    }

    public void setParent(Node node)
    {
        this._parent = node;
    }

    public boolean isType(Type type)
    {
        return getType().equals(type);
    }
}