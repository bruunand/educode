package com.educode.nodes.expression.logic;

import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/23/17.
 */
public class NegateNode extends UnaryNode
{
    public NegateNode(Node child)
    {
        super(child);
        setType(Type.BoolType);
    }

    @Override
    public Object accept(com.educode.visitors.AbstractVisitor visitor)
    {
        return visitor.visit(this);
    }
}
