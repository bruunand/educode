package com.educode.nodes.statement;

import com.educode.Referencing;
import com.educode.nodes.SingleLineStatement;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.nodes.referencing.Reference;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/10/17.
 */
public class AssignmentNode extends UnaryNode implements Referencing, SingleLineStatement
{
    private Reference _reference;

    public AssignmentNode(Reference reference, Node child)
    {
        super(child);
        this._reference = reference;
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
