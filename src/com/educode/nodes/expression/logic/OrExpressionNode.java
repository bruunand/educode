package com.educode.nodes.expression.logic;

import com.educode.nodes.base.NodeBase;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/23/17.
 */
public class OrExpressionNode extends LogicExpressionNode
{
    public OrExpressionNode(NodeBase leftExpr, NodeBase rightExpr)
    {
        super(leftExpr, rightExpr);
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }
}
