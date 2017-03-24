package com.educode.nodes.statement.conditional;

import com.educode.nodes.base.BinaryNode;
import com.educode.nodes.base.NodeBase;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/23/17.
 */
public class ConditionNode extends BinaryNode
{
    public ConditionNode(NodeBase logic, NodeBase block)
    {
        super(logic, block);
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }
}
