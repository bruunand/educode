package com.educode.nodes.ungrouped;

import com.educode.helper.NodeHelper;
import com.educode.nodes.Identifiable;
import com.educode.nodes.SingleLineStatement;
import com.educode.nodes.Typeable;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

import java.util.List;

/**
 * Created by User on 24-Mar-17.
 */
public class ObjectInstantiationNode extends UnaryNode implements Typeable, SingleLineStatement
{
    private Type _type;

    public ObjectInstantiationNode(Type type)
    {
        this(null, type);
    }

    public ObjectInstantiationNode(Node child, Type type)
    {
        super(child);
        this._type = type;
    }

    public List<Node> getActualArguments()
    {
        return NodeHelper.getGrandchildren(this);
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public Type getType()
    {
        return this._type;
    }

    @Override
    public void setType(Type type)
    {
        if (this._type != null)
            return;
        this._type = type;
    }
}
