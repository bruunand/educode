package com.educode.minecraft;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.educode.minecraft.command.CommandEdit;
import com.educode.minecraft.command.CommandRun;
import com.educode.minecraft.command.CommandStopScripts;
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
import net.minecraftforge.fml.common.FMLCommonHandler;
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
    
    public static final String SCRIPTS_LOCATION = System.getProperty("user.home") + File.separator + "Scripts" + File.separator;

    public static final String ROBOT_TEXTURE_LOCATION = "textures/entity/robot.png";
    
    public static final String[] NAMES = new String[] {"Anders", "Andreas", "Matias", "Simon", "Theis", "Thomas"};
    
    public static final List<UUID> CHILD_ENTITIES = new ArrayList<UUID>();
    
    public static final SimpleNetworkWrapper NETWORK_INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);

    public static final List<ScriptBase> RUNNING_SCRIPTS = new ArrayList<>();

    //Achievement stuff
    public static AchievementPage educodeAchievementPage;
    public static Achievement achievementOpenEditor;
    public static Achievement achievementSaveFirst;

    @Mod.Instance(MODID)
    public static CompilerMod Instance;

    @SidedProxy(clientSide = "com.educode.minecraft.proxy.ClientProxy", serverSide = "com.educode.minecraft.proxy.ServerProxy")
    public static ServerProxy Proxy;
    
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	Proxy.preInit();
        MinecraftForge.EVENT_BUS.register(new EventHandler());
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, ROBOT_TEXTURE_LOCATION), EntityRobot.class, "EntityTest", 255, Instance, 64, 1, true);
        NetworkRegistry.INSTANCE.registerGuiHandler(Instance, new GuiHandler());
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Proxy.registerModels();

        achievementOpenEditor = new Achievement("", "Opened editor", 0, 0, Items.BOOK, null);
        achievementSaveFirst = new Achievement("", "Saved first script", 2, 0, Items.ITEM_FRAME, achievementOpenEditor);

        educodeAchievementPage = new AchievementPage("EduCode Achievements", achievementOpenEditor, achievementSaveFirst);
        AchievementPage.registerAchievementPage(educodeAchievementPage);

        MinecraftForge.EVENT_BUS.register(new AchievementEventHandler());
    }
    
    @Mod.EventHandler
    public void serverStart(FMLServerStartingEvent event)
    {
        File scriptsDir = new File(SCRIPTS_LOCATION);
        if (!scriptsDir.exists())
            scriptsDir.mkdir();

        event.registerServerCommand(new CommandRun());
        event.registerServerCommand(new CommandEdit());
        event.registerServerCommand(new CommandStopScripts());
    }
}