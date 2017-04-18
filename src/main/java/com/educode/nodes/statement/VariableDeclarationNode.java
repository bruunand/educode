package com.educode.nodes.statement;

import com.educode.Referencing;
import com.educode.nodes.SingleLineStatement;
import com.educode.nodes.base.UnaryNode;
import com.educode.nodes.referencing.Reference;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/10/17.
 */
public class VariableDeclarationNode extends UnaryNode implements Referencing, SingleLineStatement
{
    private final Reference _reference;

    public VariableDeclarationNode(AssignmentNode assignmentChild, Type type)
    {
        super(assignmentChild);
        this._reference = assignmentChild.getReference();
        setType(type);
    }

    public VariableDeclarationNode(Reference reference, Type type)
    {
        super(null);
        this._reference = reference;
        setType(type);
    }

    public Reference getIdentifierNode()
    {
        return this._reference;
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
