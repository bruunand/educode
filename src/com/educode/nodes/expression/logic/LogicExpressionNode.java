package com.educode.nodes.expression.logic;

import com.educode.nodes.Typeable;
import com.educode.nodes.base.NodeBase;
import com.educode.nodes.expression.ExpressionNode;
import com.educode.types.Type;

/**
 * Created by zen on 3/10/17.
 */
public abstract class LogicExpressionNode extends ExpressionNode implements Typeable
{
    public LogicExpressionNode(NodeBase leftExpr, NodeBase rightExpr)
    {
        super(leftExpr, rightExpr);
    }

    @Override
    public Type getType()
    {
        return Type.BoolType;
    }

    @Override
    public void setType(Type type)
    {
    }
}
