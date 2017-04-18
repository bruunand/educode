package com.educode.nodes.ungrouped;

import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 4/11/17.
 */
public class TypeCastNode extends UnaryNode
{
    public TypeCastNode(Type type, Node expression)
    {
        super(expression);
        setType(type);
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }
}
