package com.educode.nodes.base;

/**
 * Created by zen on 3/10/17.
 */
public abstract class BinaryNode extends NodeBase
{
    private NodeBase _leftChild, _rightChild;

    public BinaryNode(NodeBase leftChild, NodeBase rightChild)
    {
        this._leftChild = leftChild;
        this._rightChild = rightChild;
    }

    public NodeBase getLeftChild()
    {
        return _leftChild;
    }

    public NodeBase getRightChild()
    {
        return _rightChild;
    }
}
