package com.educode.nodes.referencing;

import com.educode.nodes.base.BinaryNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.expression.ArithmeticExpression;
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

    public ArithmeticExpression getExpression()
    {
        return (ArithmeticExpression) this.getRightChild();
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return null;
    }

    @Override
    public String toString()
    {
        return String.format("%s[%s]", getLeftChild(), getRightChild());
    }
}
