package com.rebelliousuno.remotecontroldrone.util;

import org.apache.logging.log4j.Level;

import com.rebelliousuno.remotecontroldrone.reference.Reference;

import cpw.mods.fml.common.FMLLog;

public class LogHelper {

	public static void log(Level logLevel, Object obj){
		FMLLog.log(Reference.NAME, logLevel, String.valueOf(obj));
		
	}
	
	
	
}
