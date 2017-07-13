package com.educode.nodes.method;

import com.educode.nodes.IReferencing;
import com.educode.nodes.base.LeafNode;
import com.educode.nodes.referencing.IReference;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/24/17.
 */
public class ParameterNode extends LeafNode implements IReferencing
{
    private IReference _reference;

    public ParameterNode(IReference visit, Type type)
    {
        super();
        this._reference = visit;
        setType(type);
    }

    @Override
    public Object accept(com.educode.visitors.AbstractVisitor visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public IReference getReference()
    {
        return this._reference;
    }
}
