package com.educode.nodes.expression;

import com.educode.nodes.base.Node;
import com.educode.types.ArithmeticOperator;
import com.educode.visitors.AbstractVisitor;

/**
 * Created by zen on 3/10/17.
 */
public class AdditionExpressionNode extends ArithmeticExpressionNode
{
    public AdditionExpressionNode(ArithmeticOperator operator, Node leftChild, Node rightChild)
    {
        super(operator, leftChild, rightChild);
    }

    @Override
    public Object accept(AbstractVisitor visitor)
    {
        return visitor.visit(this);
    }
}
