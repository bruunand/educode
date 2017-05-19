package com.educode.nodes.referencing;

import com.educode.nodes.base.BinaryNode;
import com.educode.nodes.base.Node;
import com.educode.visitors.VisitorBase;

/**
 * Created by User on 14-Apr-17.
 */
public class ArrayReferencingNode extends BinaryNode implements IReference
{
    public ArrayReferencingNode(Node arrayName, Node arithmeticExpression)
    {
        super(arrayName, arithmeticExpression);
    }

    public Node getArrayName()
    {
        return this.getLeftChild();
    }

    public Node getExpression()
    {
        return this.getRightChild();
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public String toString()
    {
        return String.format("%s[%s]", getLeftChild(), getRightChild());
    }
}
