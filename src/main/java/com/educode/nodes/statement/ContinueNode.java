package com.educode.nodes.statement;

import com.educode.nodes.base.LeafNode;
import com.educode.visitors.VisitorBase;

/**
 * Created by Thomas Buhl on 15/05/2017.
 */
public class ContinueNode extends LeafNode{

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }
}
