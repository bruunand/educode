package com.educode.nodes.referencing;

import com.educode.nodes.base.LeafNode;
import com.educode.visitors.VisitorBase;

/**
 * Created by User on 14-Apr-17.
 */
public class IdentifierReferencing extends LeafNode implements Reference
{
    private String _identifier;

    public IdentifierReferencing(String identifier)
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
}
