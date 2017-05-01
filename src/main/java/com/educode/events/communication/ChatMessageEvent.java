package com.educode.events.communication;

import com.educode.events.EventTypeBase;
import com.educode.types.Type;

import java.util.List;

/**
 * Created by User on 30-Apr-17.
 */
public class ChatMessageEvent extends EventTypeBase
{
    @Override
    public List<Type> getRequiredParameters()
    {
        return java.util.Arrays.asList(Type.EntityType, Type.StringType);
    }

    @Override
    public String getName()
    {
        return "ChatMessage";
    }
}
