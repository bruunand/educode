package com.educode.nodes.expression;

import com.educode.nodes.base.BinaryNode;
import com.educode.nodes.base.Node;
import com.educode.types.Type;

/**
 * Created by zen on 3/10/17.
 */
public abstract class ExpressionNode extends BinaryNode
{
    private Type _type;

    public ExpressionNode(Node leftChild, Node rightChild)
    {
        super(leftChild, rightChild);
    }

    protected void setType(Type type) throws Exception
    {
        this._type = type;
    }

    public Type getType(Type type)
    {
        return _type;
    }
}
