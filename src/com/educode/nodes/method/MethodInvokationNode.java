package com.educode.nodes.method;

import com.educode.nodes.Identifiable;
import com.educode.nodes.base.NodeBase;
import com.educode.nodes.base.UnaryNode;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/23/17.
 */
public class MethodInvokationNode extends UnaryNode implements Identifiable
{
    private String _calleeMethod;

    public MethodInvokationNode(NodeBase child, String calleeMethod)
    {
        super(child);
        this._calleeMethod = calleeMethod;
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public String getIdentifier()
    {
        return this._calleeMethod;
    }
}
