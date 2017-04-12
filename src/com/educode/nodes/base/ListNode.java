package com.educode.nodes.base;

import com.educode.visitors.VisitorBase;

import java.util.ArrayList;

/**
 * Created by zen on 3/23/17.
 */
public class ListNode extends NaryNode
{
    public ListNode()
    {
        super(new ArrayList<Node>());
    }

    public ListNode(ArrayList<Node> childNodes)
    {
        super(childNodes);
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }
}

