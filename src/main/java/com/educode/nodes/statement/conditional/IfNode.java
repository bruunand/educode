package com.educode.nodes.statement.conditional;

import com.educode.nodes.base.NaryNode;
import com.educode.nodes.base.Node;
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
        super(new ArrayList<>());
    }

    public BlockNode getElseBlock()
    {
        for (Node n : getChildren())
        {
            if (n instanceof BlockNode)
                return (BlockNode) n;
        }

        return null; // If statement has no else-block
    }

    public ArrayList<ConditionNode> getConditionBlocks()
    {
        ArrayList<ConditionNode> conditionBlocks = new ArrayList<ConditionNode>();
        for (Node child : getChildren())
        {
            if (child instanceof ConditionNode)
                conditionBlocks.add((ConditionNode)child);
        }

        return conditionBlocks;
    }

    @Override
    public Object accept(com.educode.visitors.AbstractVisitor visitor)
    {
        return visitor.visit(this);
    }
}
