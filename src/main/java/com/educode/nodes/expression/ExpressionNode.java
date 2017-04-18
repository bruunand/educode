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
}
