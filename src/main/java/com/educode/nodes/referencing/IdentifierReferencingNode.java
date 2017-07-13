package com.educode.nodes.referencing;

import com.educode.nodes.base.LeafNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.statement.VariableDeclarationNode;
import com.educode.visitors.VisitorBase;

/**
 * Created by User on 14-Apr-17.
 */
public class IdentifierReferencingNode extends LeafNode implements IReference
{
    private String _identifier;

    private VariableDeclarationNode _declaration;

    public IdentifierReferencingNode(String identifier)
    {
        this._identifier = identifier;
    }

    @Override
    public Object accept(com.educode.visitors.AbstractVisitor visitor)
    {
        return visitor.visit(this);
    }

    public String getText()
    {
        return this._identifier;
    }

    @Override
    public String toString()
    {
        return this.getText();
    }

    public VariableDeclarationNode getDeclaration()
    {
        return this._declaration;
    }

    public void setDeclaration(VariableDeclarationNode node)
    {
        this._declaration = node;
    }

    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof IdentifierReferencingNode))
            return false;
        else
            return ((IdentifierReferencingNode) other).getText().equals(this.getText());
    }
}
