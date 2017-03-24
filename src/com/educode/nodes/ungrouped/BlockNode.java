package com.educode.nodes.ungrouped;

import com.educode.nodes.base.NaryNode;
import com.educode.nodes.base.Node;
import com.educode.visitors.VisitorBase;

import java.util.ArrayList;

/**
 * Created by zen on 3/9/17.
 */
public class BlockNode extends NaryNode
{
    public BlockNode(ArrayList<Node> children)
    {
        super(children);
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }
}
