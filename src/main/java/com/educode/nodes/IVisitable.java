package com.educode.nodes;

import com.educode.visitors.AbstractVisitor;

/**
 * Created by zen on 3/23/17.
 */
public interface IVisitable
{
    Object accept(AbstractVisitor visitor);
}
