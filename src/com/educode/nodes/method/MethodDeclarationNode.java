package com.educode.nodes.method;

import com.educode.nodes.Identifiable;
import com.educode.nodes.Typeable;
import com.educode.nodes.base.NodeBase;
import com.educode.nodes.base.UnaryNode;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/9/17.
 */
public class MethodDeclarationNode extends UnaryNode implements Identifiable, Typeable
{
    private String _identifier;
    private Type _returnType;

    public MethodDeclarationNode(NodeBase child, String identifier, Type returnType)
    {
        super(child);
        this._identifier = identifier;
        this._returnType = returnType;
    }

    @Override
    public String getIdentifier()
    {
        return this._identifier;
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public Type getType()
    {
        return this._returnType;
    }

    @Override
    public void setType(Type type)
    {
        if (_returnType != null)
            return;
        _returnType = type;
    }
}
