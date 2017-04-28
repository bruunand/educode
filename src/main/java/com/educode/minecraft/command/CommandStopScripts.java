package com.educode.minecraft.command;

import com.educode.minecraft.CompilerMod;
import com.educode.runtime.ScriptBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

import java.util.List;

/**
 * Created by zen on 4/28/17.
 */
public class CommandStopScripts implements ICommand
{
    private final List<String> _aliases;

    public CommandStopScripts()
    {
        _aliases = java.util.Arrays.asList("stopscripts");;
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
        return "stopscripts";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "/stopscripts";
    }

    @Override
    public List<String> getAliases()
    {
        return _aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        synchronized (CompilerMod.RUNNING_SCRIPTS)
        {
            for (ScriptBase script : CompilerMod.RUNNING_SCRIPTS)
            {
                if (!script.getRobot().isDead)
                    script.getRobot().setDead();
            }
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
