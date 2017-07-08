package com.educode.minecraft.handler;

import com.educode.minecraft.gui.GuiProgramEditor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
    private static final int GUI_PROGRAM_EDITOR = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if (ID == GUI_PROGRAM_EDITOR)
            return new GuiProgramEditor();

        return null;
    }
}