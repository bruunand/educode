package com.educode.nodes.literal;

import com.educode.nodes.base.LeafNode;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/23/17.
 */
public class NumberLiteralNode extends LeafNode
{
    private float _value;

    public NumberLiteralNode(float value)
    {
        this._value = value;
        setType(Type.NumberType);
    }

    public float getValue()
    {
        return this._value;
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }
}
