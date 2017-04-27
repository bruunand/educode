package com.educode.minecraft.proxy;

import com.educode.minecraft.CompilerMod;
import com.educode.minecraft.networking.MessageOpenEditor;

import com.educode.minecraft.networking.MessageSaveFile;
import net.minecraftforge.fml.relauncher.Side;

public class ServerProxy
{
    public void preInit()
    {
        CompilerMod.NETWORK_INSTANCE.registerMessage(MessageSaveFile.MessageHandler.class, MessageSaveFile.class, MessageSaveFile.PACKET_ID, Side.SERVER);
        CompilerMod.NETWORK_INSTANCE.registerMessage(MessageOpenEditor.MessageHandler.class, MessageOpenEditor.class, MessageOpenEditor.PACKET_ID, Side.CLIENT);
    }
    
    public void registerModels()
    {
    }
}
