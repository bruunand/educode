package com.educode.nodes.statement;

import com.educode.nodes.Identifiable;
import com.educode.nodes.SingleLineStatement;
import com.educode.nodes.Typeable;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.nodes.literal.IdentifierLiteralNode;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/10/17.
 */
public class AssignmentNode extends UnaryNode implements Identifiable, Typeable, SingleLineStatement
{
    private IdentifierLiteralNode _identifierNode;
    private Type _type;

    public AssignmentNode(IdentifierLiteralNode identifierNode, Node child)
    {
        super(child);
        this._identifierNode = identifierNode;
    }

    public IdentifierLiteralNode getIdentifierNode()
    {
        return this._identifierNode;
    }

    @Override
    public String getIdentifier()
    {
        return _identifierNode.getIdentifier();
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
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
