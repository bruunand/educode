package com.educode.nodes.expression;

import com.educode.nodes.Typeable;
import com.educode.nodes.base.BinaryNode;
import com.educode.nodes.base.Node;
import com.educode.types.ArithmeticOperator;
import com.educode.types.Type;

/**
 * Created by zen on 3/10/17.
 */
public abstract class ArithmeticExpression extends BinaryNode implements Typeable
{
    private Type _type;
    private ArithmeticOperator _operator;

    public ArithmeticExpression(ArithmeticOperator operator, Node leftChild, Node rightChild)
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
