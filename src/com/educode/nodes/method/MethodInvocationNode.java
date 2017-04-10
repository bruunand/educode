package com.educode.nodes.method;

import com.educode.helper.NodeHelper;
import com.educode.nodes.Identifiable;
import com.educode.nodes.SingleLineStatement;
import com.educode.nodes.Typeable;
import com.educode.nodes.base.NaryNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.nodes.expression.ExpressionNode;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zen on 3/23/17.
 */
public class MethodInvocationNode extends UnaryNode implements Identifiable, SingleLineStatement, Typeable
{
    private String _calleeMethod;

    private Type _type;

    public MethodInvocationNode(Node child, String calleeMethod)
    {
        super(child);
        this._calleeMethod = calleeMethod;
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
    public String getIdentifier()
    {
        return this._calleeMethod;
    }

    @Override
    public Type getType()
    {
        return this._type;
    }

    @Override
    public void setType(Type type)
    {
        this._type = type;
    }
}
