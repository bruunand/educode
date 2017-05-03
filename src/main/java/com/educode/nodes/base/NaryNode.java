package com.educode.nodes.base;

import com.educode.nodes.statement.conditional.ConditionNode;

import java.util.ArrayList;

/**
 * Created by zen on 3/9/17.
 */
public abstract class NaryNode extends Node implements INodeWithChildren
{
    private ArrayList<Node> _childNodes = new ArrayList<>();

    public NaryNode(ArrayList<Node> childNodes)
    {
        this._childNodes = childNodes;

        // Set parent of child nodes to this
        for (Node child : this._childNodes)
        {
            if (child == null)
                continue;

            child.setParent(this);
        }
    }

    @Override
    public void replaceChildReference(Node fromReference, Node toReference)
    {
        for (int i = 0; i < getChildren().size(); i++)
        {
            Node current = getChildren().get(i);
            if (current == null || current != fromReference)
                continue;

            getChildren().set(i, toReference);
            if (toReference != null)
                toReference.setParent(this);
        }
    }

    public void addChild(Node node)
    {
        _childNodes.add(node);
        node.setParent(this);
    }

    public ArrayList<Node> getChildren()
    {
        return _childNodes;
    }

    public void remove(Node child)
    {
        this._childNodes.remove(child);
    }
}
