package com.educode.nodes.ungrouped;

import com.educode.IReferencing;
import com.educode.nodes.IVisitable;
import com.educode.nodes.base.NaryNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.referencing.IReference;
import com.educode.visitors.VisitorBase;

import java.util.ArrayList;

/**
 * Created by zen on 3/9/17.
 */
public class ProgramNode extends NaryNode implements IVisitable, IReferencing
{
    private IReference _reference;

    public ProgramNode(ArrayList<Node> childNodes, IReference reference)
    {
        super(childNodes);
        this._reference = reference;
    }

    public ArrayList<EventDefinitionNode> getEventDefinitions()
    {
        ArrayList<EventDefinitionNode> nodes = new ArrayList<>();

        for (Node child : getChildren())
        {
            if (child instanceof EventDefinitionNode)
                nodes.add((EventDefinitionNode) child);
        }

        return nodes;
    }

    public ArrayList<MethodDeclarationNode> getMethodDeclarations()
    {
        ArrayList<MethodDeclarationNode> nodes = new ArrayList<>();

        for (Node child : getChildren())
        {
            if (child instanceof MethodDeclarationNode)
                nodes.add((MethodDeclarationNode) child);
        }

        return nodes;
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
