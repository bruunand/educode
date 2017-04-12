package com.educode.nodes.ungrouped;

import com.educode.nodes.Typeable;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 4/11/17.
 */
public class TypeCastNode extends UnaryNode implements Typeable
{
    private Type _type;

    public TypeCastNode(Type type, Node expression)
    {
        super(expression);
        this._type = type;
    }

    @Override
    public Type getType()
    {
        return this._type;
    }

    @Override
    public void setType(Type type)
    {
        // Cannot set type of typecast
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }
}
