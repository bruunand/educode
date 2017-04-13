package com.educode.nodes.statement;

import com.educode.nodes.Identifiable;
import com.educode.nodes.Typeable;
import com.educode.nodes.base.BinaryNode;
import com.educode.nodes.base.Node;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by User on 13-Apr-17.
 */
public class ForEachNode extends BinaryNode implements Identifiable, Typeable
{
    private final Type _type;
    private final String _identifier;

    // Left child : Expression
    // Right child: Block to execute in each iteration
    public ForEachNode(String identifier, Type type, Node leftChild, Node rightChild)
    {
        super(leftChild, rightChild);
        this._identifier = identifier;
        this._type = type;
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public String getIdentifier()
    {
        return this._identifier;
    }

    @Override
    public Type getType()
    {
        return this._type;
    }

    @Override
    public void setType(Type type)
    {
        // Cannot set type of for each node
    }

    @Override
    public boolean equals(Object other)
    {
        return false;
    }
}
