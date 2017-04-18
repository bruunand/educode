package com.educode.nodes.ungrouped;

import com.educode.Referencing;
import com.educode.nodes.Visitable;
import com.educode.nodes.base.NaryNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.referencing.Reference;
import com.educode.visitors.VisitorBase;

import java.util.ArrayList;

/**
 * Created by zen on 3/9/17.
 */
public class ProgramNode extends NaryNode implements Visitable, Referencing
{
    private Reference _reference;

    public ProgramNode(ArrayList<Node> childNodes, Reference reference)
    {
        super(childNodes);
        this._reference = reference;
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
    public Reference getReference()
    {
        return this._reference;
    }
}
