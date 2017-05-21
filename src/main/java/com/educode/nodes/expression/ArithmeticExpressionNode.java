package com.educode.nodes.expression;

import com.educode.nodes.base.BinaryNode;
import com.educode.nodes.base.Node;
import com.educode.types.ArithmeticOperator;
import com.educode.types.Type;

/**
 * Created by zen on 3/10/17.
 */
public abstract class ArithmeticExpressionNode extends ExpressionNode
{
    private Type _type = Type.Error;
    private ArithmeticOperator _operator;

    public ArithmeticExpressionNode(ArithmeticOperator operator, Node leftChild, Node rightChild)
    {
        super(leftChild, rightChild);
        this._operator = operator;
    }

    public ArithmeticOperator getOperator()
    {
        return this._operator;
    }

    @Override
    public Type getType()
    {
        return _type;
    }

    @Override
    public void setType(Type type)
    {
        this._type = type;
    }
}
