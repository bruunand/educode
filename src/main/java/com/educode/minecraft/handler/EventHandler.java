package com.educode.minecraft.handler;

import com.educode.events.entity.EntityDeathEvent;
import com.educode.minecraft.Command;
import com.educode.minecraft.CompilerMod;
import com.educode.minecraft.gui.GuiProgramEditor;
import com.educode.minecraft.networking.MessageOpenEditor;
import com.educode.runtime.ScriptBase;
import com.educode.events.Broadcaster;
import com.educode.runtime.types.MinecraftEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by User on 26-Apr-17.
 */
public class EventHandler
{
    private static Queue<IMessage> _commandQueue = new ConcurrentLinkedQueue<IMessage>();

    public static void queueMessage(IMessage message)
    {
        _commandQueue.add(message);
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event)
    {
        IMessage nextMessage = _commandQueue.poll();
        if (nextMessage != null)
        {
            // Ensures that GUI is only opened on client tick
            // Opening GUI outside client tick causes undefined behavior
            if (nextMessage instanceof MessageOpenEditor)
            {
                MessageOpenEditor openGuiMessage = (MessageOpenEditor) nextMessage;
                GuiProgramEditor.resetPosition();
                GuiProgramEditor.setText(openGuiMessage.getScriptContent());
                GuiProgramEditor.setFileName(openGuiMessage.getFileName());

                EntityPlayerSP player = Minecraft.getMinecraft().player;
                player.openGui(CompilerMod.MODID, 0, player.world, 0, 0, 0);
            }
        }
    }

    @SubscribeEvent
    public void onLivingDeathEvent(LivingDeathEvent event)
    {
        // Skip client side
        if (event.getEntity().getEntityWorld().isRemote)
            return;

        Broadcaster.broadcastEvent(EntityDeathEvent.class, new MinecraftEntity(event.getEntity()));
    }

    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event)
    {
        synchronized (CompilerMod.RUNNING_SCRIPTS)
        {
            Iterator<ScriptBase> iterator = CompilerMod.RUNNING_SCRIPTS.iterator();

            while (iterator.hasNext())
            {
                ScriptBase script = iterator.next();
                if (script.getRobot().isDead)
                {
                    script.getMainThread().interrupt();
                    iterator.remove();
                    continue;
                }

                // Poll command
                Command command = script.pollCommand();
                if (command != null)
                    command.setResult(command.getExecutable().execute());
            }
        }
    }
}
