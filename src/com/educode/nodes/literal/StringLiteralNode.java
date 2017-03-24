package com.educode.nodes.literal;

import com.educode.nodes.base.LeafNode;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/23/17.
 */
public class StringLiteralNode extends LeafNode
{
    private String _value;

    public StringLiteralNode(String value)
    {
        this._value = value;
    }

    public String getValue()
    {
        return this._value;
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }
}
