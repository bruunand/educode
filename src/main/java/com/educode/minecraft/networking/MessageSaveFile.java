package com.educode.minecraft.networking;

import com.educode.events.achievements.AchievementEvent;
import com.educode.minecraft.CompilerMod;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by zen on 4/10/17.
 */
public class MessageSaveFile implements IMessage
{
    public static final int PACKET_ID = 0;

    private String _name, _contents;

    public MessageSaveFile()
    {
    }

    public MessageSaveFile(String name, String contents)
    {
        this._name = name;
        this._contents = contents;
    }

    public String getFileName()
    {
        return this._name;
    }

    public String getContents()
    {
        return this._contents;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this._name = ByteBufUtils.readUTF8String(buf);
        this._contents = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        ByteBufUtils.writeUTF8String(buf, this._name);
        ByteBufUtils.writeUTF8String(buf, this._contents);
    }

    public static final class MessageHandler implements IMessageHandler<MessageSaveFile, IMessage>
    {
        @Override
        public IMessage onMessage(MessageSaveFile message, MessageContext ctx)
        {
            if (ctx.side == Side.CLIENT)
                return null; // Should not happen

            // Write contents of file to disk
            try
            {
                //Give editor save achievement
                MinecraftForge.EVENT_BUS.post(new AchievementEvent.EditorSavedEvent(ctx.getServerHandler().playerEntity));

                FileWriter fw = new FileWriter(new File(CompilerMod.EDUCODE_PROGRAMS_LOCATION + message.getFileName() + ".educ"));
                fw.write(message.getContents());
                fw.close();

                // Inform player that file was saved
                ctx.getServerHandler().playerEntity.sendMessage(new TextComponentString(TextFormatting.GREEN + "[Success]" + TextFormatting.RESET + " File was saved."));
            }
            catch (IOException e)
            {
                e.printStackTrace();

                ctx.getServerHandler().playerEntity.sendMessage(new TextComponentString(TextFormatting.RED + "[Error]" + TextFormatting.RESET + " " + e.getMessage()));
            }

            return null;
        }
    }
}
