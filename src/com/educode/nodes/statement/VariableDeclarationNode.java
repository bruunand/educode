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
public class VariableDeclarationNode extends UnaryNode implements Identifiable, Typeable, SingleLineStatement
{
    private Type _type;
    private IdentifierLiteralNode _identifierNode;

    public VariableDeclarationNode(Type type, AssignmentNode assignmentChild)
    {
        super(assignmentChild);
        this._identifierNode = assignmentChild.getIdentifierNode();
        this._type = type;
    }

    public VariableDeclarationNode(IdentifierLiteralNode identifierNode, Type type)
    {
        super(null);
        this._identifierNode = identifierNode;
        this._type = type;
    }

    public IdentifierLiteralNode getIdentifierNode()
    {
        return this._identifierNode;
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
