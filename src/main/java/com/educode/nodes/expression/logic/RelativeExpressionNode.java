package com.educode.nodes.expression.logic;

import com.educode.nodes.base.Node;
import com.educode.types.LogicalOperator;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/23/17.
 */
public class RelativeExpressionNode extends LogicalExpressionNode
{
    public RelativeExpressionNode(LogicalOperator operator, Node leftExpr, Node rightExpr)
    {
        super(operator, leftExpr, rightExpr);
    }

    @Override
    public Object accept(com.educode.visitors.AbstractVisitor visitor)
    {
        return visitor.visit(this);
    }
}
