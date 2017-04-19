package com.educode.nodes;

import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/23/17.
 */
public interface IVisitable
{
    Object accept(VisitorBase visitor);
}
