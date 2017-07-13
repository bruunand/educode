package com.educode.nodes.expression;

import com.educode.nodes.base.Node;
import com.educode.types.ArithmeticOperator;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/10/17.
 */
public class MultiplicationExpressionNode extends ArithmeticExpressionNode
{
    public MultiplicationExpressionNode(ArithmeticOperator operator, Node leftChild, Node rightChild)
    {
        super(operator, leftChild, rightChild);
    }

    @Override
    public Object accept(com.educode.visitors.AbstractVisitor visitor)
    {
        return visitor.visit(this);
    }
}
