package com.educode.nodes.statement.conditional;

import com.educode.nodes.base.BinaryNode;
import com.educode.nodes.base.Node;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/23/17.
 */
public class ConditionNode extends BinaryNode
{
    public ConditionNode(Node logic, Node block)
    {
        super(logic, block);
    }

    @Override
    public Object accept(com.educode.visitors.AbstractVisitor visitor)
    {
        return visitor.visit(this);
    }
}
