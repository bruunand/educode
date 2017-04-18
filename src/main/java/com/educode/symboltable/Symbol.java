package com.educode.symboltable;

import com.educode.Referencing;
import com.educode.Typeable;
import com.educode.nodes.base.Node;
import com.educode.nodes.referencing.Reference;
import com.educode.types.Type;

/**
 * Created by User on 15-Apr-17.
 */
public class Symbol implements Typeable, Referencing
{
    private final Reference _reference;
    private final Node _sourceNode;

    public Symbol(Reference reference, Node sourceNode)
    {
        this._reference = reference;
        this._sourceNode = sourceNode;
    }

    public Node getSourceNode()
    {
        return this._sourceNode;
    }

    @Override
    public Type getType()
    {
        return this._reference.getType();
    }

    @Override
    public void setType(Type type)
    {
        this._reference.setType(type);
    }

    @Override
    public boolean isType(Type type)
    {
        return this._reference.isType(type);
    }

    @Override
    public Reference getReference()
    {
        return this._reference;
    }
}
