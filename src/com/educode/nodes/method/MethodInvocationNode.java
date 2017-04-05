package com.educode.nodes.method;

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
public class MethodInvocationNode extends UnaryNode implements Identifiable, SingleLineStatement
{
    private String _calleeMethod;

    public MethodInvocationNode(Node child, String calleeMethod)
    {
        super(child);
        this._calleeMethod = calleeMethod;
    }

    public List<Typeable> getActualArguments()
    {
        ArrayList<Typeable> nodes = new ArrayList<>();

        // If child is null, return empty list
        if (getChild() == null || !(getChild() instanceof NaryNode))
            return nodes;

        // Add expressions
        for (Node grandchild : ((NaryNode) getChild()).getChildren())
        {
            if (grandchild instanceof Typeable)
                nodes.add((Typeable) grandchild);
        }

        return nodes;
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
