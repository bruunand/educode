package com.educode.nodes.statement;

import com.educode.nodes.IReferencing;
import com.educode.nodes.ISingleLineStatement;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.nodes.referencing.IReference;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/10/17.
 */
public class AssignmentNode extends UnaryNode implements IReferencing, ISingleLineStatement
{
    private IReference _reference;

    public AssignmentNode(IReference reference, Node child)
    {
        super(child);
        this._reference = reference;
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
