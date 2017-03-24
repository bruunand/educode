package com.educode.nodes.base;

import java.util.ArrayList;

/**
 * Created by zen on 3/9/17.
 */
public abstract class NaryNode extends NodeBase
{
    private ArrayList<NodeBase> _childNodes = new ArrayList<NodeBase>();

    public NaryNode(ArrayList<NodeBase> childNodes)
    {
        this._childNodes = childNodes;
    }

    public void addChild(NodeBase node)
    {
        _childNodes.add(node);
    }

    public ArrayList<NodeBase> getChildren()
    {
        return _childNodes;
    }
}
