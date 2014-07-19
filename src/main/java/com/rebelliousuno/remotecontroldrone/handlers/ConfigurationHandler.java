package com.rebelliousuno.remotecontroldrone.handlers;

import java.io.File;

import com.rebelliousuno.remotecontroldrone.reference.Reference;
import com.rebelliousuno.remotecontroldrone.util.LogHelper;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler {

	public static Configuration configuration;

	public static void init(File configFile) {
		if (configuration == null) {
			configuration = new Configuration(configFile);
			configuration.load();
		}
		loadConfiguration();

	}

	private static void loadConfiguration() {

		boolean configValue = configuration.get(Configuration.CATEGORY_GENERAL,
				"configValue", true, "Example config value").getBoolean(true);

		if (configuration.hasChanged()) {
			configuration.save();

		}
	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(
			ConfigChangedEvent.OnConfigChangedEvent evt) {
		LogHelper.debug("Configuration Changed " + evt.modID);
		if (evt.modID.equalsIgnoreCase(Reference.MOD_ID)) {
			// Resync configs.
			loadConfiguration();
		}
		;
	}
}
