package com.educode.nodes.ungrouped;

import com.educode.nodes.Identifiable;
import com.educode.nodes.Visitable;
import com.educode.nodes.base.NaryNode;
import com.educode.nodes.base.NodeBase;
import com.educode.visitors.VisitorBase;

import java.util.ArrayList;

/**
 * Created by zen on 3/9/17.
 */
public class ProgramNode extends NaryNode implements Visitable, Identifiable
{
    private String _identifier;

    public ProgramNode(ArrayList<NodeBase> childNodes, String identifier)
    {
        super(childNodes);
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
        return _identifier;
    }
}
