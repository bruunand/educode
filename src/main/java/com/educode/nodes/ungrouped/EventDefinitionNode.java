package com.educode.nodes.ungrouped;

import com.educode.nodes.IReferencing;
import com.educode.nodes.base.LeafNode;
import com.educode.nodes.referencing.IReference;
import com.educode.events.EventTypeBase;
import com.educode.nodes.referencing.IdentifierReferencingNode;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 4/26/17.
 */
public class EventDefinitionNode extends LeafNode implements IReferencing
{
    private final IReference _reference;
    private final EventTypeBase _eventType;

    public EventDefinitionNode(IReference reference, EventTypeBase eventType)
    {
        this._reference = reference;
        this._eventType = eventType;
    }

    public String getName()
    {
        if (getReference() instanceof IdentifierReferencingNode)
            return ((IdentifierReferencingNode) getReference()).getText();
        return null;
    }

    @Override
    public IReference getReference()
    {
        return this._reference;
    }

    public EventTypeBase getEventType()
    {
        return _eventType;
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }
}
