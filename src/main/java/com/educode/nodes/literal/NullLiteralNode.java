package com.educode.nodes.literal;

import com.educode.nodes.base.LeafNode;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 5/11/17.
 */
public class NullLiteralNode extends LeafNode implements ILiteral<String>
{
    @Override
    public String getValue()
    {
        return "NULL";
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }
}
