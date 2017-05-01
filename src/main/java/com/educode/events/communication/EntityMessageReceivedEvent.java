package com.educode.events.communication;

import com.educode.nodes.literal.NumberLiteralNode;
import com.educode.types.Type;

import java.util.List;

/**
 * Created by User on 28-Apr-17.
 */
public class EntityMessageReceivedEvent extends MessageReceivedEventBase
{
    public EntityMessageReceivedEvent(NumberLiteralNode numberLiteral)
    {
        super(numberLiteral);
    }

    @Override
    public List<Type> getRequiredParameters()
    {
        return java.util.Arrays.asList(Type.EntityType, Type.EntityType);
    }

    @Override
    public String getName()
    {
        return "EntityMessageReceived";
    }
}
