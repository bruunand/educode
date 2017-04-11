package com.educode.nodes.ungrouped;

import com.educode.nodes.Identifiable;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.nodes.literal.IdentifierLiteralNode;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 4/6/17.
 */
public class DotNode extends UnaryNode implements Identifiable
{
    private IdentifierLiteralNode _identifierNode;

    public DotNode(IdentifierLiteralNode identifier, Node child)
    {
        super(child);
        this._identifierNode = identifier;
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public String getIdentifier()
    {
        return this._identifierNode.getIdentifier();
    }
}
