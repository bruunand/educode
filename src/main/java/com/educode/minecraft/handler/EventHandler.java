package com.educode.minecraft.handler;

import com.educode.events.Broadcaster;
import com.educode.events.communication.ChatMessageEvent;
import com.educode.events.entity.EntityDeathEvent;
import com.educode.minecraft.CompilerMod;
import com.educode.minecraft.gui.GuiProgramEditor;
import com.educode.minecraft.networking.MessageOpenEditor;
import com.educode.runtime.IExecutable;
import com.educode.runtime.ProgramBase;
import com.educode.runtime.TickCommand;
import com.educode.runtime.types.MinecraftEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.ServerChatEvent;
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
    private static Queue<IExecutable> _serverExecutableQueue = new ConcurrentLinkedQueue<>();
    private static Queue<IMessage> _clientMessageQueue = new ConcurrentLinkedQueue<>();

    public static void queueServerExecutable(IExecutable executable)
    {
        _serverExecutableQueue.add(executable);
    }

    public static void queueClientMessage(IMessage message)
    {
        _clientMessageQueue.add(message);
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event)
    {
        IMessage nextMessage = _clientMessageQueue.poll();
        if (nextMessage != null)
        {
            // Ensures that GUI is only opened on client tick
            // Opening GUI outside client tick causes undefined behavior
            if (nextMessage instanceof MessageOpenEditor)
            {
                MessageOpenEditor openGuiMessage = (MessageOpenEditor) nextMessage;
                GuiProgramEditor.resetPosition();
                GuiProgramEditor.setText(openGuiMessage.getProgramContent());
                GuiProgramEditor.setFileName(openGuiMessage.getFileName());

                EntityPlayerSP player = Minecraft.getMinecraft().player;
                player.openGui(CompilerMod.MODID, 0, player.world, 0, 0, 0);
            }
        }
    }

    @SubscribeEvent
    public void onServerChatEvent(ServerChatEvent event)
    {
        Broadcaster.broadcastEvent(ChatMessageEvent.class, new MinecraftEntity(event.getPlayer()), event.getMessage());
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
        // Execute all server commands
        while (!_serverExecutableQueue.isEmpty())
            _serverExecutableQueue.poll().execute();

        // Execute commands from all running programs (one command per program per tick)
        synchronized (CompilerMod.RUNNING_PROGRAMS)
        {
            Iterator<ProgramBase> iterator = CompilerMod.RUNNING_PROGRAMS.iterator();

            int count = 0;
            while (iterator.hasNext())
            {
                count++;
                ProgramBase program = iterator.next();

                // Check if threads are running
                boolean mainThreadRunning  = program.getMainThread() != null && program.getMainThread().isAlive();
                if (!mainThreadRunning)
                    program.getRobot().setDead();

                if (program.getRobot().isDead)
                {
                    // Stop threads
                    program.getMainThread().interrupt();
                    if (program.getEventThread() != null)
                        program.getEventThread().interrupt();

                    iterator.remove();
                    continue;
                }

                // Poll command
                TickCommand command = program.pollCommand();
                if (command == null)
                    continue;

                // Execute and notify on run time error
                try
                {
                    command.setResult(command.getExecutable().execute());
                }
                catch (Exception e)
                {
                    program.getOwner().getWrappedEntity().sendMessage(new TextComponentString(TextFormatting.RED + "[Runtime Error]" + TextFormatting.RESET + " " + e.toString()));
                    program.getRobot().setDead();
                }
            }
        }
    }
}
