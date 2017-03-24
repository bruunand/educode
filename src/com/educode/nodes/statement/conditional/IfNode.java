package com.educode.nodes.statement.conditional;

import com.educode.nodes.base.NaryNode;
import com.educode.nodes.base.NodeBase;
import com.educode.nodes.ungrouped.BlockNode;
import com.educode.visitors.VisitorBase;

import java.util.ArrayList;

/**
 * Created by zen on 3/23/17.
 */
public class IfNode extends NaryNode
{
    public IfNode()
    {
        super(new ArrayList<NodeBase>());
    }

    public BlockNode getElseBlock()
    {
        for (NodeBase n : getChildren())
        {
            if (n instanceof BlockNode)
                return (BlockNode) n;
        }

        return null; // If statement has no else-block
    }

    public ArrayList<ConditionNode> getConditionBlocks()
    {
        ArrayList<ConditionNode> conditionBlocks = new ArrayList<ConditionNode>();
        for (NodeBase child : getChildren())
        {
            if (child instanceof ConditionNode)
                conditionBlocks.add((ConditionNode)child);
        }

        return conditionBlocks;
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }
}
