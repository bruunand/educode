package com.educode.nodes.method;

import com.educode.nodes.IReferencing;
import com.educode.helper.NodeHelper;
import com.educode.nodes.ISingleLineStatement;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.nodes.referencing.IReference;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zen on 3/23/17.
 */
public class MethodInvocationNode extends UnaryNode implements ISingleLineStatement, IReferencing
{
    private MethodDeclarationNode _referencingDeclaration;

    private IReference _reference;

    public MethodInvocationNode(IReference calleeReference, Node child)
    {
        super(child);
        this._reference = calleeReference;
    }

    public List<Type> getActualTypes()
    {
        List<Type> returnList = new ArrayList<>();

        for (Node node : getActualArguments())
            returnList.add(node.getType());

        return returnList;
    }

    public void setReferencingDeclaration(MethodDeclarationNode node)
    {
        this._referencingDeclaration = node;
    }

    public MethodDeclarationNode getReferencingDeclaration()
    {
        return this._referencingDeclaration;
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
    public IReference getReference()
    {
        return this._reference;
    }
}
