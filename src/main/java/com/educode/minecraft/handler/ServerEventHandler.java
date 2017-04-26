package com.educode.minecraft.handler;

import com.educode.minecraft.CompilerMod;
import com.educode.minecraft.gui.GuiProgramEditor;
import com.educode.minecraft.networking.MessageOpenEditor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by zen on 4/9/17.
 */
public class ServerEventHandler
{
    @SubscribeEvent
    public void onLivingDeathEvent(LivingDeathEvent event)
    {
        // TODO: Broadcast event
        System.out.println(event.getEntity().getName() + " dead");
    }

    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event)
    {
        //System.out.println("server tick");
    }
}
