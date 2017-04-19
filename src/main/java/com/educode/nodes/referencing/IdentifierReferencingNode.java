package com.educode.nodes.referencing;

import com.educode.nodes.base.LeafNode;
import com.educode.visitors.VisitorBase;

/**
 * Created by User on 14-Apr-17.
 */
public class IdentifierReferencingNode extends LeafNode implements IReference
{
    private String _identifier;

    public IdentifierReferencingNode(String identifier)
    {
        this._identifier = identifier;
    }

    @Override
    public Object accept(VisitorBase visitor)
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

    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof IdentifierReferencingNode))
            return false;
        else
            return ((IdentifierReferencingNode) other).getText().equals(this.getText());
    }
}
