package com.educode.nodes.statement.conditional;

import com.educode.nodes.base.NodeBase;
import com.educode.nodes.base.UnaryNode;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/24/17.
 */
public class RepeatWhileNode extends UnaryNode
{
    public RepeatWhileNode(NodeBase conditionChild)
    {
        super(conditionChild);
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }
}
