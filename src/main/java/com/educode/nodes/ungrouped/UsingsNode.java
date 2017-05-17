package com.educode.nodes.ungrouped;

import com.educode.nodes.base.NaryNode;
import com.educode.nodes.base.Node;
import com.educode.visitors.VisitorBase;

import java.util.ArrayList;

/**
 * Created by Thomas Buhl on 10/05/2017.
 */
public class UsingsNode extends NaryNode{

    public UsingsNode(ArrayList<Node> childNodes)
    {
        super(childNodes);
    }
    public UsingsNode()
    {
        super(new ArrayList<Node>());
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }

}
