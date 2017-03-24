package com.educode.nodes.base;

/**
 * Created by zen on 3/10/17.
 */
public abstract class BinaryNode extends Node
{
    private Node _leftChild, _rightChild;

    public BinaryNode(Node leftChild, Node rightChild)
    {
        this._leftChild = leftChild;
        this._rightChild = rightChild;
    }

    public Node getLeftChild()
    {
        return _leftChild;
    }

    public Node getRightChild()
    {
        return _rightChild;
    }
}
