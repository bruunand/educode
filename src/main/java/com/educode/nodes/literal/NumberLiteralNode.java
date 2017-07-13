package com.educode.nodes.literal;

import com.educode.nodes.base.LeafNode;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/23/17.
 */
public class NumberLiteralNode extends LeafNode implements ILiteral<Double>
{
    private Double _value;

    public NumberLiteralNode(Double value)
    {
        this._value = value;
        setType(Type.NumberType);
    }

    public Double getValue()
    {
        return this._value;
    }

    @Override
    public Object accept(com.educode.visitors.AbstractVisitor visitor)
    {
        return visitor.visit(this);
    }
}
