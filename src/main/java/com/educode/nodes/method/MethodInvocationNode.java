package com.educode.nodes.method;

import com.educode.Referencing;
import com.educode.helper.NodeHelper;
import com.educode.nodes.SingleLineStatement;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.nodes.referencing.Reference;
import com.educode.visitors.VisitorBase;

import java.util.List;

/**
 * Created by zen on 3/23/17.
 */
public class MethodInvocationNode extends UnaryNode implements SingleLineStatement, Referencing
{
    private Reference _reference;

    public MethodInvocationNode(Reference calleeReference, Node child)
    {
        super(child);
        this._reference = calleeReference;
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
    public Reference getReference()
    {
        return this._reference;
    }
}
