package com.educode.nodes.statement;

import com.educode.IReferencing;
import com.educode.nodes.ISingleLineStatement;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.nodes.referencing.IReference;
import com.educode.types.AssignmentOperator;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/10/17.
 */
public class AssignmentNode extends UnaryNode implements IReferencing, ISingleLineStatement
{
    private IReference _reference;
    private AssignmentOperator _operator;

    public AssignmentNode(AssignmentOperator operator, IReference reference, Node child)
    {
        super(child);
        this._operator = operator;
        this._reference = reference;
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public IReference getReference()
    {
        return this._reference;
    }

    public AssignmentOperator getOperator()
    {
        return this._operator;
    }
}
