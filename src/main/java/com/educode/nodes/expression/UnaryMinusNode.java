package com.educode.nodes.expression;

import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.visitors.VisitorBase;

/**
 * Created by Thomas Buhl on 11/05/2017.
 */
public class UnaryMinusNode extends UnaryNode {
    public UnaryMinusNode(Node child)
    {
        super(child);
    }

    @Override
    public Object accept(VisitorBase visitor) {
        return visitor.visit(this);
    }
}
