package com.educode.types.events;

import com.educode.nodes.literal.NumberLiteralNode;
import com.educode.runtime.ScriptBase;
import com.educode.types.Type;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zen on 4/26/17.
 */
public class MessageReceivedEvent extends EventTypeBase
{
    private final float _channel;

    public MessageReceivedEvent(NumberLiteralNode numberLiteral)
    {
        this._channel = numberLiteral.getValue();
    }

    public float getChannel()
    {
        return this._channel;
    }

    @Override
    public List<Type> getRequiredParameters()
    {
        return Arrays.asList(Type.EntityType, Type.StringType);
    }

    @Override
    public String getName()
    {
        return "MessageReceived";
    }
}
