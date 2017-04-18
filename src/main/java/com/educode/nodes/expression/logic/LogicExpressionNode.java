package com.educode.nodes.expression.logic;

import com.educode.nodes.base.Node;
import com.educode.nodes.expression.ExpressionNode;
import com.educode.types.LogicalOperator;
import com.educode.types.Type;

/**
 * Created by zen on 3/10/17.
 */
public abstract class LogicExpressionNode extends ExpressionNode
{
    private LogicalOperator _operator;

    public LogicExpressionNode(LogicalOperator operator, Node leftExpr, Node rightExpr)
    {
        super(leftExpr, rightExpr);
        this._operator = operator;
        setType(Type.BoolType);
    }

    public LogicalOperator getOperator()
    {
        return this._operator;
    }
}
