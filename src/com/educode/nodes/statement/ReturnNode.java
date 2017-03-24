package com.educode.nodes.statement;

import com.educode.nodes.base.NodeBase;
import com.educode.nodes.base.UnaryNode;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/24/17.
 */
public class ReturnNode extends UnaryNode
{
    public ReturnNode()
    {
        this(null);
    }

    public ReturnNode(NodeBase child)
    {
        super(child);
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }
}
