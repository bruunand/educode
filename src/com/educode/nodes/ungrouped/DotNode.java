package com.educode.nodes.ungrouped;

import com.educode.nodes.Identifiable;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 4/6/17.
 */
public class DotNode extends UnaryNode implements Identifiable
{
    
    public DotNode(Node child)
    {
        super(child);
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public String getIdentifier()
    {
        return null;
    }
}
