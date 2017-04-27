package com.educode.nodes.base;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by zen on 3/9/17.
 */
public abstract class NaryNode extends Node
{
    private ArrayList<Node> _childNodes = new ArrayList<Node>();

    public NaryNode(ArrayList<Node> childNodes)
    {
        this._childNodes = childNodes;
    }

    public void addChild(Node node)
    {
        _childNodes.add(node);
    }

    public ArrayList<Node> getChildren()
    {
        return _childNodes;
    }
}
