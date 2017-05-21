package com.educode.minecraft.command;

import com.educode.minecraft.CompilerMod;
import com.educode.runtime.ProgramBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

/**
 * Created by zen on 4/28/17.
 */
public class CommandStopPrograms implements ICommand
{
    private final List<String> _aliases;

    public CommandStopPrograms()
    {
        _aliases = java.util.Arrays.asList("stopprograms");;
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
        return "stopprograms";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "/stopprograms";
    }

    @Override
    public List<String> getAliases()
    {
        return _aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        int stopped = 0;

        synchronized (CompilerMod.RUNNING_PROGRAMS)
        {
            for (ProgramBase program : CompilerMod.RUNNING_PROGRAMS)
            {
                if (!program.getRobot().isDead && program.getPlayer().equals(sender.getCommandSenderEntity()))
                {
                    program.getRobot().setDead();
                    stopped++;
                }
            }
        }

        sender.sendMessage(new TextComponentString(TextFormatting.GREEN + "[Success]" + TextFormatting.RESET + " " + String.format("Stopped %d programs.", stopped)));
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
