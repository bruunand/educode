package com.educode.nodes.literal;

import com.educode.nodes.Identifiable;
import com.educode.nodes.Typeable;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/23/17.
 */
public class IdentifierLiteralNode extends UnaryNode implements Identifiable, Typeable
{
    private String _identifier;
    private Type _type = Type.VoidType;

    public IdentifierLiteralNode(Node child, String identifier)
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

    @Override
    public Type getType()
    {
        return _type;
    }

    @Override
    public void setType(Type type)
    {
        this._type = type;
    }
}
