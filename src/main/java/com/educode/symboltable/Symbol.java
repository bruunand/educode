package com.educode.symboltable;

import com.educode.IReferencing;
import com.educode.ITypeable;
import com.educode.nodes.base.Node;
import com.educode.nodes.referencing.IReference;
import com.educode.types.Type;

/**
 * Created by User on 15-Apr-17.
 */
public class Symbol implements ITypeable, IReferencing
{
    private final IReference _reference;
    private final Node _sourceNode;

    public Symbol(IReference reference, Node sourceNode)
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
    public IReference getReference()
    {
        return this._reference;
    }
}
