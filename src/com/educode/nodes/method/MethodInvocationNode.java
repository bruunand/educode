package com.educode.nodes.method;

import com.educode.nodes.Identifiable;
import com.educode.nodes.SingleLineStatement;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/23/17.
 */
public class MethodInvocationNode extends UnaryNode implements Identifiable, SingleLineStatement
{
    private String _calleeMethod;

    public MethodInvocationNode(Node child, String calleeMethod)
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
