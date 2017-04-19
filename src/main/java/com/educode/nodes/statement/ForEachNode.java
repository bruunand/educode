package com.educode.nodes.statement;

import com.educode.IReferencing;
import com.educode.nodes.base.BinaryNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.referencing.IReference;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by User on 13-Apr-17.
 */
public class ForEachNode extends BinaryNode implements IReferencing
{
    private final IReference _reference;

    // Left child : Expression
    // Right child: Block to execute in each iteration
    public ForEachNode(IReference reference, Type type, Node leftChild, Node rightChild)
    {
        super(leftChild, rightChild);
        this._reference = reference;
        setType(type);
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public IReference getReference()
    {
        return this._reference;
    }
}
