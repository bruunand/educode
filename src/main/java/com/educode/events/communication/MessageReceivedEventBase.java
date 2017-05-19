package com.educode.events.communication;

import com.educode.events.EventTypeBase;
import com.educode.nodes.literal.NumberLiteralNode;

/**
 * Created by zen on 4/26/17.
 */
public abstract class MessageReceivedEventBase extends EventTypeBase
{
    private final double _channel;

    public MessageReceivedEventBase(NumberLiteralNode numberLiteral)
    {
        this._channel = numberLiteral.getValue();
    }

    public double getChannel()
    {
        return this._channel;
    }
}
