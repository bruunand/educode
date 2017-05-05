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
        event.player.addStat(CompilerMod.achievementOpenEditor);
    }

    @SubscribeEvent
    public  void onEditorSaved(AchievementEvent.EditorSavedEvent event)
    {
        event.player.addStat(CompilerMod.achievementSaveFirst);

        //If compiler errors
        event.player.addStat(CompilerMod.achievementError);
    }

    @SubscribeEvent
    public  void onRobotChat(AchievementEvent.RobotChatEvent event)
    {
        event.player.addStat(CompilerMod.achievementRobotChat);
    }

    @SubscribeEvent
    public  void onRobotBroadcast(AchievementEvent.RobotBroadcastEvent event)
    {
        event.player.addStat(CompilerMod.achievementBroadcastMessage);

        //If channel has listeners
        event.player.addStat(CompilerMod.achievementCoordination);
    }

    @SubscribeEvent
    public  void onRobotAction(AchievementEvent.RobotActionEvent event)
    {
        if(event.robotAction.equals("explode"))
            event.player.addStat(CompilerMod.achievementRobotExplode);

        if(event.robotAction.equals("attack"))
            event.player.addStat(CompilerMod.achievementRobotAttackOther);
    }

    @SubscribeEvent
    public  void onRobotPlaceBlock(AchievementEvent.RobotPlaceBlockEvent event)
    {
        //Check how blocks are placed
        event.player.addStat(CompilerMod.achievementBuildHouse);
    }
}
