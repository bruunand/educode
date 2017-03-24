package com.educode.nodes.statement;

import com.educode.nodes.Identifiable;
import com.educode.nodes.Typeable;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/10/17.
 */
public class VariableDeclarationNode extends UnaryNode implements Identifiable, Typeable
{
    private String _identifier;
    private Type _type;

    public VariableDeclarationNode(String identifier, Type type, Node assignmentChild)
    {
        super(assignmentChild);
        this._identifier = identifier;
        this._type = type;
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
        return this._type;
    }

    @Override
    public void setType(Type type)
    {
        this._type = type;
    }
}
