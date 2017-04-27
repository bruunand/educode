package com.educode.minecraft.networking;

import com.educode.minecraft.handler.ClientEventHandler;
import com.educode.minecraft.handler.ServerEventHandler;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageOpenEditor implements IMessage
{
	public static final int PACKET_ID = 1;

	private String _scriptContent, _fileName;
	
	public MessageOpenEditor() {}
	
	public MessageOpenEditor(String fileName, String scriptContent)
	{
		this._fileName = fileName;
		this._scriptContent = scriptContent;
	}
	
	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, this._fileName);
	    ByteBufUtils.writeUTF8String(buf, this._scriptContent);
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
	    this._fileName = ByteBufUtils.readUTF8String(buf);
		this._scriptContent = ByteBufUtils.readUTF8String(buf);
	}

	public String getScriptContent()
	{
		return this._scriptContent;
	}

    public String getFileName()
    {
        return this._fileName;
    }

    public static final class MessageHandler implements IMessageHandler<MessageOpenEditor, IMessage>
	{
		@Override
		public IMessage onMessage(MessageOpenEditor message, MessageContext ctx)
		{
			if (ctx.side.isClient())
				ClientEventHandler.queueMessage(message);

			return null;
		}
	}
}