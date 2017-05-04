package com.educode.minecraft.handler;

import com.educode.events.achievements.AchievementEvent;
import com.educode.minecraft.CompilerMod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Matias on 04-05-2017.
 */
public class AchievementEventHandler
{
    @SubscribeEvent
    public void onEditorOpened(AchievementEvent.EditorOpenedEvent event)
    {
        event.player.addStat(CompilerMod.achievementOpenEditor, 1);
    }

    @SubscribeEvent
    public  void onEditorSaved(AchievementEvent.EditorSavedEvent event)
    {
        event.player.addStat(CompilerMod.achievementSaveFirst, 1);
    }
}
