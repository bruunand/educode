package com.educode.events.achievements;

import net.minecraft.block.Block;
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

    public static class ProgramRunEvent extends AchievementEvent
    {

        public ProgramRunEvent(EntityPlayer player) {
            super(player);
        }
    }

    public static class CompilerErrorEvent extends AchievementEvent
    {

        public CompilerErrorEvent(EntityPlayer player) {
            super(player);
        }
    }

    public static class RobotChatEvent extends AchievementEvent
    {
        public String chatMessage;
        public RobotChatEvent(EntityPlayer owner, String chatMessage)
        {
            super(owner);
            this.chatMessage = chatMessage;
        }
    }

    public static class RobotBroadcastEvent extends AchievementEvent
    {
        public String message;
        public String channel;
        public RobotBroadcastEvent(EntityPlayer owner, String message, String channel)
        {
            super(owner);
            this.message = message;
            this.channel = channel;
        }
    }

    public static class RobotActionEvent extends AchievementEvent
    {
        //This could be changed to an enum
        public String robotAction;
        public RobotActionEvent(EntityPlayer owner, String robotAction)
        {
            super(owner);
            this.robotAction = robotAction;
        }
    }

    public static class RobotPlaceBlockEvent extends AchievementEvent
    {
        //This could be changed to an enum
        public Block block;
        public RobotPlaceBlockEvent(EntityPlayer owner, Block block)
        {
            super(owner);
            this.block = block;
        }
    }
}
