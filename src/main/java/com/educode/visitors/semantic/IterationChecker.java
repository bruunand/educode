package com.educode.visitors.semantic;

import com.educode.nodes.base.Node;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 5/3/17.
 */
public class IterationChecker extends VisitorBase
{
    @Override
    public Object defaultVisit(Node node)
    {
        System.out.println("no visitor for " + node.getClass());
        return null;
    }
}
