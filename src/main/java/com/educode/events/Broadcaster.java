package com.educode.events;

import com.educode.events.communication.MessageReceivedEventBase;
import com.educode.minecraft.CompilerMod;
import com.educode.nodes.ungrouped.EventDefinitionNode;
import com.educode.runtime.ProgramBase;
import com.educode.runtime.types.MinecraftEntity;
import net.minecraft.entity.Entity;

import java.util.List;

/**
 * Created by zen on 4/27/17.
 */
public class Broadcaster
{
    public static void broadcastEvent(Class<?> eventType, Object ... args)
    {
        // Iterate over running programs and find subscribers to the channel
        // Subscribers will have an appropriate event invoked
        synchronized (CompilerMod.RUNNING_PROGRAMS)
        {
            for (ProgramBase program : CompilerMod.RUNNING_PROGRAMS)
                EventInvoker.invokeByType(program, eventType, args);
        }
    }

    // There is a special method for communication because they require the subscribe to be subscribed to a specific channel
    public static void broadcastMessage(Entity sender, double channel, Object message)
    {
        synchronized (CompilerMod.RUNNING_PROGRAMS)
        {
            for (ProgramBase program : CompilerMod.RUNNING_PROGRAMS)
            {
                List<EventDefinitionNode> eventDefinitions = program.getEventDefinitions();
                if (eventDefinitions == null)
                    continue;

                for (EventDefinitionNode eventDef : eventDefinitions)
                {
                    // Check if event type is MessageReceivedEventBase
                    if (!(eventDef.getEventType() instanceof MessageReceivedEventBase))
                        continue;

                    // Check if channel matches
                    MessageReceivedEventBase receivedEvent = (MessageReceivedEventBase) eventDef.getEventType();
                    if (receivedEvent.getChannel() != channel)
                        continue;

                    EventInvoker.invokeByName(program, eventDef.getMethodName(), eventDef.getEventType(), new MinecraftEntity(sender), message);
                }
            }
        }
    }
}
