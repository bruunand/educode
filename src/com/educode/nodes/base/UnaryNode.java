package com.educode.nodes.base;

/**
 * Created by zen on 3/9/17.
 */
public abstract class UnaryNode extends Node
{
    private Node _child;

    public UnaryNode(Node child)
    {
        this._child = child;
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
