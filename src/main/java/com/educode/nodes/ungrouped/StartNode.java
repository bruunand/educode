package com.educode.nodes.ungrouped;

import com.educode.nodes.base.*;
import com.educode.visitors.VisitorBase;

import java.util.ArrayList;

/**
 * Created by Thomas Buhl on 10/05/2017.
 */
public class StartNode extends BinaryNode{

    public StartNode(Node leftChild, Node rightChild) {
        super(leftChild, rightChild);
    }




    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }
}
