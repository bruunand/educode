package com.educode.nodes.expression.logic;

import com.educode.nodes.base.Node;
import com.educode.types.LogicalOperator;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/23/17.
 */
public class OrExpressionNode extends LogicalExpressionNode
{
    public OrExpressionNode(Node leftExpr, Node rightExpr)
    {
        super(LogicalOperator.Or, leftExpr, rightExpr);
    }

    @Override
    public Object accept(com.educode.visitors.AbstractVisitor visitor)
    {
        return visitor.visit(this);
    }
}
