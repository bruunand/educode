package com.educode.nodes.literal;

import com.educode.nodes.Identifiable;
import com.educode.nodes.base.NodeBase;
import com.educode.nodes.base.UnaryNode;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/23/17.
 */
public class IdentifierLiteralNode extends UnaryNode implements Identifiable
{
    private String _identifier;

    public IdentifierLiteralNode(NodeBase child, String identifier)
    {
        super(child);
        this._identifier = identifier;
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public String getIdentifier()
    {
        return this._identifier;
    }
}
