package com.rebelliousuno.remotecontroldrone;

import com.rebelliousuno.remotecontroldrone.configuration.ConfigurationHandler;
import com.rebelliousuno.remotecontroldrone.proxy.IProxy;
import com.rebelliousuno.remotecontroldrone.reference.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Reference.MOD_ID, name=Reference.NAME, version=Reference.VERSION)
public class RemoteControlDrone {
	
	@Mod.Instance("remoteControlDrone")
	public static RemoteControlDrone instance; 

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent evt){
		//Items And Blocks 
		
		ConfigurationHandler.init(evt.getSuggestedConfigurationFile());
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent evt){
		//GUI Tile Entities Recipes
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent evt){
		//Wrap Up
	}
	
}