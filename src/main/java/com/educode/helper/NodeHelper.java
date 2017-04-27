package com.educode.helper;

import com.educode.nodes.base.NaryNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zen on 4/10/17.
 */
public class NodeHelper
{
    public static List<Node> getGrandchildren(UnaryNode node)
    {
        ArrayList<Node> nodes = new ArrayList<>();

        // If child is null, return empty list
        if (node.getChild() == null || !(node.getChild() instanceof NaryNode))
            return nodes;

        // Add expressions
        nodes.addAll(((NaryNode) node.getChild()).getChildren());

        return nodes;
    }
}
