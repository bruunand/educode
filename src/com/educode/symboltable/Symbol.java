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
    public Identifiable node;
    public boolean IsValid;

    public Symbol(Identifiable _node, Boolean _isValid)
    {
        node = _node;
        IsValid = _isValid;
    }
    public Symbol(Identifiable _node)
    {
        this(_node, true);
    }

    public String getName()
    {
        return node.getIdentifier();
    }

    @Override
    public boolean equals(Object other)
    {
        if (this.IsValid && (other instanceof Identifiable))
            return node.equals(other);

        return false;
    }

    public boolean corresponds(Node other){
        if (this.IsValid){
            if (other instanceof MethodInvocationNode && node instanceof MethodDeclarationNode)
                return ((MethodDeclarationNode) node).corresponds((MethodInvocationNode)other);
            else if (other instanceof IdentifierLiteralNode && node instanceof VariableDeclarationNode)
                return node.getIdentifier().equals(((IdentifierLiteralNode) other).getIdentifier());
        }

        return false;
    }



}
