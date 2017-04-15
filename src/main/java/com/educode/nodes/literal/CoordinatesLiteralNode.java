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
    private NumberLiteralNode _x, _y, _z;

    public CoordinatesLiteralNode(Node x, Node y, Node z)
    {
        this._x = (NumberLiteralNode) x;
        this._y = (NumberLiteralNode) y;
        this._z = (NumberLiteralNode) z;
        setType(Type.CoordinatesType);
    }

    public NumberLiteralNode getX()
    {
        return this._x;
    }

    public NumberLiteralNode getY()
    {
        return this._y;
    }

    public NumberLiteralNode getZ()
    {
        return this._z;
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }
}
