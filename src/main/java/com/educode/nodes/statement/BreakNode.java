package com.educode.nodes.statement;

import com.educode.nodes.base.LeafNode;
import com.educode.nodes.base.Node;
import com.educode.visitors.VisitorBase;

/**
 * Created by Thomas Buhl on 15/05/2017.
 */
public class BreakNode extends LeafNode{
    private Node _affectingLoop;

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }

    public Node getAffectingLoop()
    {
        return this._affectingLoop;
    }
    public void setAffectingLoop(Node value)
    {
        _affectingLoop = value;
    }
}
