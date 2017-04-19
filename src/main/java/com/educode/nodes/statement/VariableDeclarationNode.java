package com.educode.nodes.statement;

import com.educode.IReferencing;
import com.educode.nodes.ISingleLineStatement;
import com.educode.nodes.base.UnaryNode;
import com.educode.nodes.referencing.IReference;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/10/17.
 */
public class VariableDeclarationNode extends UnaryNode implements IReferencing, ISingleLineStatement
{
    private final IReference _reference;

    public VariableDeclarationNode(AssignmentNode assignmentChild, Type type)
    {
        super(assignmentChild);
        this._reference = assignmentChild.getReference();
        setType(type);
    }

    public VariableDeclarationNode(IReference reference, Type type)
    {
        super(null);
        this._reference = reference;
        setType(type);
    }

    public IReference getIdentifierNode()
    {
        return this._reference;
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public IReference getReference()
    {
        return this._reference;
    }
}
