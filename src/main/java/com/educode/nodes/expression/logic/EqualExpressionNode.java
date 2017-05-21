package com.educode.nodes.expression.logic;

import com.educode.nodes.base.Node;
import com.educode.nodes.literal.BoolLiteralNode;
import com.educode.nodes.literal.NullLiteralNode;
import com.educode.nodes.literal.NumberLiteralNode;
import com.educode.types.LogicalOperator;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/23/17.
 */
public class EqualExpressionNode extends LogicalExpressionNode
{
    public EqualExpressionNode(LogicalOperator operator, Node leftExpr, Node rightExpr)
    {
        super(operator, leftExpr, rightExpr);
    }

    public boolean isNumberComparison()
    {
        return getLeftChild() instanceof NumberLiteralNode || getRightChild() instanceof NumberLiteralNode;
    }

    public boolean isBoolComparison()
    {
        return getLeftChild() instanceof BoolLiteralNode || getRightChild() instanceof BoolLiteralNode;
    }

    public boolean isNullComparison()
    {
        return getLeftChild() instanceof NullLiteralNode || getRightChild() instanceof NullLiteralNode;
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }
}
