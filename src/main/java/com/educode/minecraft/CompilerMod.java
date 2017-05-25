package com.educode.minecraft;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.educode.minecraft.command.CommandEdit;
import com.educode.minecraft.command.CommandRun;
import com.educode.minecraft.command.CommandStopPrograms;
import com.educode.minecraft.entity.EntityRobot;
import com.educode.minecraft.handler.AchievementEventHandler;
import com.educode.minecraft.handler.EventHandler;
import com.educode.minecraft.proxy.ServerProxy;
import com.educode.minecraft.handler.GuiHandler;
import com.educode.runtime.*;

import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.stats.Achievement;

import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(modid = CompilerMod.MODID, version = CompilerMod.VERSION)
public class CompilerMod
{
    public static final String MODID = "compilermod";
    public static final String VERSION = "1.0";
    
    public static final String EDUCODE_PROGRAMS_LOCATION = System.getProperty("user.home") + File.separator + "EduCode Programs" + File.separator;

    public static final String ROBOT_TEXTURE_LOCATION = "textures/entity/robot.png";
    
    public static final String[] NAMES = new String[] {"Anders", "Andreas", "Matias", "Simon", "Theis", "Thomas"};
    
    public static final List<UUID> CHILD_ENTITIES = new ArrayList<UUID>();
    
    public static final SimpleNetworkWrapper NETWORK_INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);

    public static final List<ProgramBase> RUNNING_PROGRAMS = new ArrayList<>();

    //Achievement stuff
    public static AchievementPage eduCodeAchievementPage;
    
    //Robot
    public static Achievement achievementRobotChat;
    public static Achievement achievementRobotExplode;
    public static Achievement achievementRobotAttackOther;
    public static Achievement achievementBroadcastMessage;
    
    //Build progression
    public static Achievement achievementBuildLine;
    public static Achievement achievementBuildInclinedLine;
    public static Achievement achievementBuildTriangle;
    public static Achievement achievementBuildSquare;
    public static Achievement achievementBuildCube;
    public static Achievement achievementBuildHouse;
    
    //Editor progression
    public static Achievement achievementOpenEditor;
    public static Achievement achievementSaveFirst;
    public static Achievement achievementRunFirst;
    
    //Other
    public static Achievement achievementCoordination;
    public static Achievement achievementError;

    @Mod.Instance(MODID)
    public static CompilerMod Instance;

    @SidedProxy(clientSide = "com.educode.minecraft.proxy.ClientProxy", serverSide = "com.educode.minecraft.proxy.ServerProxy")
    public static ServerProxy Proxy;
    
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	Proxy.preInit();

    	// Register event handlers
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        MinecraftForge.EVENT_BUS.register(new AchievementEventHandler());

        // Register entities
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, ROBOT_TEXTURE_LOCATION), EntityRobot.class, "EntityTest", 255, Instance, 64, 1, true);

		// Register GUI
		NetworkRegistry.INSTANCE.registerGuiHandler(Instance, new GuiHandler());
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Proxy.registerModels();

        //Start of achievement chain
        achievementOpenEditor = new Achievement("program_opened", "openEditor", 0, -4, Items.BOOK, null);//Added
        achievementSaveFirst = new Achievement("program_saved", "saveFirst", 0, -2, Items.ITEM_FRAME, achievementOpenEditor);//Added
        achievementRunFirst = new Achievement("program_run", "runFirst", 0, 0, Items.STRING, achievementSaveFirst);//Added
        
        //Robot achievement chain
        achievementRobotChat = new Achievement("robot_chat", "robotChat", 2, -2, Items.GHAST_TEAR, achievementRunFirst);//Added
        achievementRobotExplode = new Achievement("robot_attack", "robotAttackOther", 2,-1, Items.TNT_MINECART, achievementRunFirst).setSpecial();
        achievementRobotAttackOther = new Achievement("robot_explode", "robotExplode", 2,0, Items.DIAMOND_SWORD, achievementRunFirst);//Added
        achievementBroadcastMessage = new Achievement("robot_broadcast", "broadcastMessage", 2, 1, Items.WRITABLE_BOOK, achievementRunFirst);
        achievementCoordination = new Achievement("robot_broadcast_received", "coordination", 2, 2, Items.WRITTEN_BOOK, achievementBroadcastMessage);

        //Build achievement chain
        achievementBuildLine = new Achievement("build_line", "buildLine", 0, 2, Items.BONE, achievementRunFirst);
        achievementBuildInclinedLine = new Achievement("build_inclined_line", "buildInclinedLine", 2, 2, Items.STRING, achievementBuildLine);
        achievementBuildSquare = new Achievement("build_square", "buildSquare", 0, 4, Items.ITEM_FRAME, achievementBuildLine);
        achievementBuildTriangle = new Achievement("build_triangle", "buildTriangle", 4, 2, Items.ARROW, achievementBuildInclinedLine);
        achievementBuildCube = new Achievement("build_cube","buildCube", 2,3, Items.CHEST_MINECART, achievementBuildSquare);
        achievementBuildHouse = new Achievement("build_house", "buildHouse", 0,4, Items.COMMAND_BLOCK_MINECART, achievementBuildCube);

        //Other
        achievementError = new Achievement("program_error", "error", 0,-6, Items.BOOK, achievementSaveFirst).setSpecial();//Added

        eduCodeAchievementPage = new AchievementPage("EduCode",
                achievementOpenEditor,
                achievementSaveFirst,
                achievementRunFirst,
                achievementRobotChat,
                achievementRobotExplode,
                achievementRobotAttackOther,
                achievementBroadcastMessage,
                achievementCoordination,
                achievementBuildLine,
                achievementBuildInclinedLine,
                achievementBuildSquare,
                achievementBuildTriangle,
                achievementBuildCube,
                achievementBuildHouse,
                achievementError);
        AchievementPage.registerAchievementPage(eduCodeAchievementPage);
    }
    
    @Mod.EventHandler
    public void serverStart(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new CommandRun());
        event.registerServerCommand(new CommandEdit());
        event.registerServerCommand(new CommandStopPrograms());
    }

    public static void createDirectory()
    {

    }
}