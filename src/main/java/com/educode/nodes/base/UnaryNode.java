package com.educode.nodes.base;

/**
 * Created by zen on 3/9/17.
 */
public abstract class UnaryNode extends Node implements INodeWithChildren
{
    private Node _child;

    public UnaryNode(Node child)
    {
        this._child = child;

        // Set child node to this
        if (this._child != null)
            this._child.setParent(this);
    }

    @Override
    public void replaceChildReference(Node fromReference, Node toReference)
    {
        if (this._child == null || this._child != fromReference)
            return;

        this._child = toReference;
        if (toReference != null)
            toReference.setParent(this);
    }

    public boolean hasChild()
    {
        return _child != null;
    }
    
    public Node getChild()
    {
        return _child;
    }
}
