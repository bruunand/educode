package com.educode.nodes.referencing;

import com.educode.nodes.base.BinaryNode;
import com.educode.nodes.base.Node;
import com.educode.visitors.VisitorBase;

/**
 * Created by User on 14-Apr-17.
 */
public class StructReferencingNode extends BinaryNode
{
    public StructReferencingNode(Node objectName, Node fieldName)
    {
        super(objectName, fieldName);
    }

    public Node getObjectName()
    {
        return this.getLeftChild();
    }

    public Node getFieldName()
    {
        return this.getRightChild();
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }
}
