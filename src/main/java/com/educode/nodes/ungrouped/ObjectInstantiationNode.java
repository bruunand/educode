package com.educode.nodes.ungrouped;

import com.educode.helper.NodeHelper;
import com.educode.nodes.ISingleLineStatement;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

import java.util.List;

/**
 * Created by User on 24-Mar-17.
 */
public class ObjectInstantiationNode extends UnaryNode implements ISingleLineStatement
{
    public ObjectInstantiationNode(Node child, Type type)
    {
        super(child);
        setType(type);
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
}
