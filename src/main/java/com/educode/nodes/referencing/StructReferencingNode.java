package com.educode.nodes.referencing;

import com.educode.nodes.ISingleLineStatement;
import com.educode.nodes.base.BinaryNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.method.MethodInvocationNode;
import com.educode.visitors.VisitorBase;

/**
 * Created by User on 14-Apr-17.
 */
public class StructReferencingNode extends BinaryNode implements IReference, ISingleLineStatement
{
    public StructReferencingNode(Node objectName, Node memberName)
    {
        super(objectName, memberName);
    }

    public Node getObjectName()
    {
        return this.getLeftChild();
    }

    public Node getMemberName()
    {
        return this.getRightChild();
    }

    public boolean isMethodInvocation()
    {
        return this.getRightChild() instanceof MethodInvocationNode;
    }

    public boolean isFieldReference()
    {
        return this.getRightChild() instanceof IdentifierReferencingNode;
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public String toString()
    {
        return String.format("%s.%s", getLeftChild(), getRightChild());
    }
}
