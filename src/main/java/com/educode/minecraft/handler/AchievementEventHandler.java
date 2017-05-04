package com.educode.minecraft.handler;

import com.educode.events.achievements.AchievementEvent;
import com.educode.minecraft.CompilerMod;

/**
 * Created by Matias on 04-05-2017.
 */
public class AchievementEventHandler
{
    public void editorOpened(AchievementEvent.EditorOpenedEvent event)
    {
        event.player.addStat(CompilerMod.achievementOpenEditor, 1);
    }

    public  void editorSaved(AchievementEvent.EditorSavedEvent event)
    {
        event.player.addStat(CompilerMod.achievementSaveFirst, 1);
    }
}
