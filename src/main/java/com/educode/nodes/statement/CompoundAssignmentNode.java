package com.educode.nodes.statement;

import com.educode.nodes.IReferencing;
import com.educode.nodes.ISingleLineStatement;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.nodes.referencing.IReference;
import com.educode.types.ArithmeticOperator;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 7/11/17.
 */
public class CompoundAssignmentNode extends UnaryNode implements IReferencing, ISingleLineStatement
{
    private final IReference _reference;
    private final ArithmeticOperator _operator;

    public CompoundAssignmentNode(IReference reference, Node child, ArithmeticOperator operator)
    {
        super(child);
        this._reference = reference;
        this._operator = operator;
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

    public ArithmeticOperator getOperator()
    {
        return this._operator;
    }
}
