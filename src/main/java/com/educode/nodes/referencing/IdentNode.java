package com.educode.nodes.referencing;

import com.educode.nodes.Identifiable;
import com.educode.nodes.base.LeafNode;
import com.educode.visitors.VisitorBase;

/**
 * Created by User on 14-Apr-17.
 */
public class IdentNode extends LeafNode implements Identifiable
{
    private String _identifier;

    public IdentNode(String identifier)
    {
        this._identifier = identifier;
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
}
