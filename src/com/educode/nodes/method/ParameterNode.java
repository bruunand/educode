package com.educode.nodes.method;

import com.educode.nodes.Identifiable;
import com.educode.nodes.Typeable;
import com.educode.nodes.base.LeafNode;
import com.educode.nodes.statement.VariableDeclarationNode;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/24/17.
 */
public class ParameterNode extends LeafNode implements Identifiable, Typeable
{
    private Type _type;
    private String _identifier;

    public ParameterNode(String identifier, Type type)
    {
        this._identifier = identifier;
        this._type = type;
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public Type getType()
    {
        return _type;
    }

    @Override
    public void setType(Type type)
    {
        if (this._type != null)
            return;
        this._type = type;
    }

    @Override
    public String getIdentifier()
    {
        return this._identifier;
    }

    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof ParameterNode))
        {
            if (other instanceof VariableDeclarationNode)
                return ((VariableDeclarationNode) other).getIdentifier().equals(this.getIdentifier());

            return false;
        }
        else
        {
            ParameterNode otherNode = (ParameterNode) other;

            return otherNode.getIdentifier().equals(this.getIdentifier());
        }
    }
}
