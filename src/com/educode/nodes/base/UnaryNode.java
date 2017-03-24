package com.educode.nodes.base;

/**
 * Created by zen on 3/9/17.
 */
public abstract class UnaryNode extends NodeBase
{
    private NodeBase _child;

    public UnaryNode(NodeBase child)
    {
        this._child = child;
    }

    public NodeBase getChild()
    {
        return _child;
    }
}
