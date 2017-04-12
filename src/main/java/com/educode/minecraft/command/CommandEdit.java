package com.educode.minecraft.command;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.educode.minecraft.CompilerMod;
import com.educode.minecraft.Utility;
import com.educode.minecraft.networking.MessageOpenEditor;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class CommandEdit implements ICommand
{
	private final static String scriptTemplate = "program %s\n  method run()\n  end method\nend program";

    private final List<String> _aliases;
    
    public CommandEdit()
    {
        _aliases = Arrays.asList("edit", "editscript");
    }
    
	@Override
	public int compareTo(ICommand arg0)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName()
	{
		return "edit";
	}

	@Override
	public String getUsage(ICommandSender sender)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAliases()
	{
		return _aliases;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		if (args.length < 1)
			return;

        final String scriptName = args[0];
		try
		{
            File scriptFile = new File(CompilerMod.SCRIPTS_LOCATION + scriptName + ".educ");

            if (scriptFile.exists())
				CompilerMod.NETWORK_INSTANCE.sendTo(new MessageOpenEditor(scriptName, new String(Utility.readBytesFromFile(scriptFile))), (EntityPlayerMP) sender);
            else
            	CompilerMod.NETWORK_INSTANCE.sendTo(new MessageOpenEditor(scriptName, String.format(scriptTemplate, scriptName)), (EntityPlayerMP) sender);
		}
        catch (Exception e)
		{
            sender.sendMessage(new TextComponentString(TextFormatting.RED + "[Error]" + TextFormatting.RESET + " " + e.getMessage()));
		}
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender)
	{
		return true;
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos)
	{
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index)
	{
		return false;
	}

}
