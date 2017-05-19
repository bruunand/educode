package com.educode.minecraft.command;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.educode.events.achievements.AchievementEvent;
import com.educode.minecraft.CompilerMod;
import com.educode.minecraft.Utility;
import com.educode.minecraft.networking.MessageOpenEditor;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;

public class CommandEdit implements ICommand
{
	private final static String programTemplate = "program %s\n  method main()\n  end method\nend program";

    private final List<String> _aliases;
    
    public CommandEdit()
    {
        _aliases = Arrays.asList("edit", "editprogram");
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

        final String programName = args[0];
		try
		{
            File programFile = new File(CompilerMod.PROGRAM_FILES_LOCATION + programName + ".educ");

            //Give editor opened achievement
			MinecraftForge.EVENT_BUS.post(new AchievementEvent.EditorOpenedEvent((EntityPlayer) sender));

            if (programFile.exists())
				CompilerMod.NETWORK_INSTANCE.sendTo(new MessageOpenEditor(programName, new String(Utility.readBytesFromFile(programFile))), (EntityPlayerMP) sender);
            else
            	CompilerMod.NETWORK_INSTANCE.sendTo(new MessageOpenEditor(programName, String.format(programTemplate, programName)), (EntityPlayerMP) sender);
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
