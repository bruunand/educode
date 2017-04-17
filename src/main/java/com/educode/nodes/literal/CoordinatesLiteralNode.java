package com.educode.nodes.literal;

import com.educode.nodes.base.LeafNode;
import com.educode.nodes.base.Node;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 4/11/17.
 */
public class CoordinatesLiteralNode extends LeafNode
{
    private Node _x, _y, _z;

    public CoordinatesLiteralNode(Node x, Node y, Node z)
    {
        this._x = x;
        this._y = y;
        this._z = z;
        setType(Type.CoordinatesType);
    }

    public Node getX()
    {
        return this._x;
    }

    public Node getY()
    {
        return this._y;
    }

    public Node getZ()
    {
        return this._z;
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }
}
