package com.educode.nodes.method;

import com.educode.Referencing;
import com.educode.nodes.base.BinaryNode;
import com.educode.nodes.base.ListNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.referencing.Reference;
import com.educode.nodes.ungrouped.BlockNode;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

import java.util.ArrayList;

/**
 * Created by zen on 3/9/17.
 */
public class MethodDeclarationNode extends BinaryNode implements Referencing
{
    private Reference _reference;

    public MethodDeclarationNode(Node leftChild, Node rightChild, Reference reference, Type returnType)
    {
        super(leftChild, rightChild);
        this._reference = reference;
        setType(returnType);
    }

    public ArrayList<ParameterNode> getParameters()
    {
        ArrayList<ParameterNode> nodeList = new ArrayList<>();

        if (!hasParameterList())
            return nodeList; // Return an empty list

        // Add all parameter nodes from child
        for (Node grandchild : getParameterList().getChildren())
        {
            if (grandchild instanceof ParameterNode)
                nodeList.add((ParameterNode) grandchild);
        }

        return nodeList;
    }

    public ListNode getParameterList()
    {
        return (ListNode) this.getLeftChild();
    }

    public boolean hasParameterList()
    {
        return this.hasLeftChild();
    }

    public BlockNode getBlockNode()
    {
        return (BlockNode) this.getRightChild();
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
