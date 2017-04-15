package com.educode.nodes.statement;

import com.educode.Referencing;
import com.educode.nodes.base.BinaryNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.referencing.Reference;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by User on 13-Apr-17.
 */
public class ForEachNode extends BinaryNode implements Referencing
{
    private final Type _type;
    private final Reference _reference;

    // Left child : Expression
    // Right child: Block to execute in each iteration
    public ForEachNode(Reference reference, Type type, Node leftChild, Node rightChild)
    {
        super(leftChild, rightChild);
        this._reference = reference;
        this._type = type;
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public Reference getReference()
    {
        return this._reference;
    }
}
