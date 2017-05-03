package com.educode.nodes.base;

/**
 * Created by zen on 3/10/17.
 */
public abstract class BinaryNode extends Node implements INodeWithChildren
{
    private Node _leftChild, _rightChild;

    public BinaryNode(Node leftChild, Node rightChild)
    {
        this._leftChild  = leftChild;
        this._rightChild = rightChild;

        // Set parent of children to this
        if (this._leftChild != null)
            this._leftChild.setParent(this);
        if (this._rightChild != null)
            this._rightChild.setParent(this);
    }

    public boolean hasLeftChild()
    {
        return _leftChild != null;
    }

    public boolean hasRightChild()
    {
        return _rightChild != null;
    }

    public Node getLeftChild()
    {
        return _leftChild;
    }

    public Node getRightChild()
    {
        return _rightChild;
    }

    @Override
    public void replaceChildReference(Node fromReference, Node toReference)
    {
        // Replace left child
        if (this._leftChild != null && this._leftChild == fromReference)
        {
            this._leftChild = toReference;

            if (toReference != null)
                toReference.setParent(this);
        }

        // Replace right child
        if (this._rightChild != null && this._rightChild == fromReference)
        {
            this._rightChild = toReference;

            if (toReference != null)
                toReference.setParent(this);
        }
    }
}
