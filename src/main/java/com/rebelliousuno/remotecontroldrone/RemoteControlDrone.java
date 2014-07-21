package com.rebelliousuno.remotecontroldrone;

import com.rebelliousuno.remotecontroldrone.handlers.ConfigurationHandler;
import com.rebelliousuno.remotecontroldrone.init.ModBlocks;
import com.rebelliousuno.remotecontroldrone.init.ModItems;
import com.rebelliousuno.remotecontroldrone.proxy.IProxy;
import com.rebelliousuno.remotecontroldrone.reference.Reference;
import com.rebelliousuno.remotecontroldrone.util.LogHelper;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Reference.MOD_ID, name=Reference.NAME, version=Reference.VERSION, guiFactory=Reference.GUI_FACTORY_CLASS)
public class RemoteControlDrone {
	
	@Mod.Instance("remoteControlDrone")
	public static RemoteControlDrone instance; 

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent evt){
		//Items And Blocks 
		
		ConfigurationHandler.init(evt.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		LogHelper.info("Pre Init Complete");
		ModItems.init();
		ModBlocks.init();
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent evt){
		//GUI Tile Entities Recipes
		LogHelper.info("Init Complete");
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent evt){
		//Wrap Up
		LogHelper.info("Post Init Complete");
	}
	
}
