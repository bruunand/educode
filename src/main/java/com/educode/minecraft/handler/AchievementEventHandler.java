package com.educode.minecraft.handler;

import com.educode.events.achievements.AchievementEvent;
import com.educode.minecraft.CompilerMod;
import net.minecraftforge.fml.common.Mod;

/**
 * Created by Matias on 04-05-2017.
 */
public class AchievementEventHandler
{
    @Mod.EventHandler
    public void onEditorOpened(AchievementEvent.EditorOpenedEvent event)
    {
        event.player.addStat(CompilerMod.achievementOpenEditor, 1);
    }

    @Mod.EventHandler
    public  void onEditorSaved(AchievementEvent.EditorSavedEvent event)
    {
        event.player.addStat(CompilerMod.achievementSaveFirst, 1);

        //If compiler errors
        event.player.addStat(CompilerMod.achievementError, 1);
    }

    @Mod.EventHandler
    public  void onRobotChat(AchievementEvent.RobotChatEvent event)
    {
        event.player.addStat(CompilerMod.achievementRobotChat, 1);
    }

    @Mod.EventHandler
    public  void onRobotBroadcast(AchievementEvent.RobotBroadcastEvent event)
    {
        event.player.addStat(CompilerMod.achievementBroadcastMessage, 1);

        //If channel has listeners
        event.player.addStat(CompilerMod.achievementCoodination, 1);
    }

    @Mod.EventHandler
    public  void onRobotAction(AchievementEvent.RobotActionEvent event)
    {
        if(event.robotAction.equals("explode"))
            event.player.addStat(CompilerMod.achievementRobotExplode, 1);

        if(event.robotAction.equals("attack"))
            event.player.addStat(CompilerMod.achievementRobotAttackOther, 1);
    }

    @Mod.EventHandler
    public  void onRobotPlaceBlock(AchievementEvent.RobotPlaceBlockEvent event)
    {
        //Check how blocks are placed
        event.player.addStat(CompilerMod.achievementBuildHouse, 1);
    }
}
