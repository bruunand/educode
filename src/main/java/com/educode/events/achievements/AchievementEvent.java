package com.educode.events.achievements;

import com.educode.minecraft.CompilerMod;
import net.minecraft.stats.Achievement;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * Created by Matias on 04-05-2017.
 */
public class AchievementEvent extends Event
{
    public final EntityPlayer player;
    private AchievementEvent(EntityPlayer player){ this.player = player; }

    public static class EditorOpenedEvent extends AchievementEvent
    {
        public EditorOpenedEvent(EntityPlayer player)
        {
            super(player);
        }
    }

    public static class EditorSavedEvent extends AchievementEvent
    {
        public EditorSavedEvent(EntityPlayer player)
        {
            super(player);
        }
    }
}
