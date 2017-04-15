package com.educode.nodes.method;

import com.educode.Referencing;
import com.educode.nodes.base.LeafNode;
import com.educode.nodes.referencing.Reference;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/24/17.
 */
public class ParameterNode extends LeafNode implements Referencing
{
    private Reference _reference;

    public ParameterNode(Reference visit, Type type)
    {
        super();
        this._reference = visit;
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public Reference getReference()
    {
        return this._reference;
    }
}
