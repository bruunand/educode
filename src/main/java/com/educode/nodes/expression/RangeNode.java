package com.educode.nodes.expression;

import com.educode.nodes.base.BinaryNode;
import com.educode.nodes.base.Node;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 6/4/17.
 */
public class RangeNode extends BinaryNode
{
    public RangeNode(Node leftChild, Node rightChild)
    {
        super(leftChild, rightChild);
        super.setType(new Type(Type.NumberType));
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }
}
