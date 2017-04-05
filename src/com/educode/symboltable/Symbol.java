package com.educode.symboltable;

import com.educode.nodes.Identifiable;
import com.educode.nodes.base.Node;
import com.educode.nodes.literal.IdentifierLiteralNode;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.method.MethodInvocationNode;
import com.educode.nodes.statement.VariableDeclarationNode;
import com.educode.types.Type;

/**
 * Created by Thomas Buhl on 31/03/2017.
 */
public class Symbol
{
    private Identifiable _node;
    private boolean _isValid;

    public Symbol(Identifiable node, Boolean isValid)
    {
        this._node = node;
        this._isValid = isValid;
    }

    public Symbol(Identifiable node)
    {
        this(node, true);
    }

    public String getName()
    {
        return _node.getIdentifier();
    }

    @Override
    public boolean equals(Object other)
    {
        if (this._isValid && (other instanceof Identifiable))
            return _node.equals(other);

        return false;
    }

    public boolean corresponds(Node other)
    {
        if (this._isValid)
        {
            if (other instanceof MethodInvocationNode && _node instanceof MethodDeclarationNode)
                return ((MethodDeclarationNode) _node).corresponds((MethodInvocationNode)other);
            else if (other instanceof IdentifierLiteralNode && _node instanceof VariableDeclarationNode)
                return _node.getIdentifier().equals(((IdentifierLiteralNode) other).getIdentifier());
        }

        return false;
    }
}
