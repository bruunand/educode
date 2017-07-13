package com.educode.nodes.statement;

import com.educode.nodes.ISingleLineStatement;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/24/17.
 */
public class ReturnNode extends UnaryNode implements ISingleLineStatement
{
    public ReturnNode()
    {
        this(null);
    }

    public ReturnNode(Node child)
    {
        super(child);
    }

    @Override
    public Object accept(com.educode.visitors.AbstractVisitor visitor)
    {
        return visitor.visit(this);
    }
}
