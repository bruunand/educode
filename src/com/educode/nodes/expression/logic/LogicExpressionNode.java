package com.educode.nodes.expression.logic;

import com.educode.nodes.Typeable;
import com.educode.nodes.base.Node;
import com.educode.nodes.expression.ExpressionNode;
import com.educode.types.LogicalOperator;
import com.educode.types.Type;

/**
 * Created by zen on 3/10/17.
 */
public abstract class LogicExpressionNode extends ExpressionNode implements Typeable
{
    private LogicalOperator _operator;

    public LogicExpressionNode(LogicalOperator operator, Node leftExpr, Node rightExpr)
    {
        super(leftExpr, rightExpr);
        this._operator = operator;
    }

    public LogicalOperator getOperator()
    {
        return this._operator;
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
