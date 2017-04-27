package com.educode.minecraft.proxy;

import com.educode.minecraft.CompilerMod;
import com.educode.minecraft.entity.EntityRobot;
import com.educode.minecraft.handler.ClientEventHandler;
import com.educode.minecraft.handler.ServerEventHandler;
import com.educode.minecraft.networking.MessageOpenEditor;
import com.educode.minecraft.networking.MessageSaveFile;
import com.educode.minecraft.render.RenderRobot;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;

public class ClientProxy extends ServerProxy
{
    public void registerModels()
    {
        RenderManager manager = Minecraft.getMinecraft().getRenderManager();
        manager.entityRenderMap.put(EntityRobot.class, new RenderRobot(manager));
    }

    @Override
    public void preInit()
    {
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
        CompilerMod.NETWORK_INSTANCE.registerMessage(MessageSaveFile.MessageHandler.class, MessageSaveFile.class, MessageSaveFile.PACKET_ID, Side.SERVER);
    	CompilerMod.NETWORK_INSTANCE.registerMessage(MessageOpenEditor.MessageHandler.class, MessageOpenEditor.class, MessageOpenEditor.PACKET_ID, Side.CLIENT);
    }
}