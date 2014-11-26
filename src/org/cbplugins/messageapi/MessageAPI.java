package org.cbplugins.messageapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class MessageAPI extends JavaPlugin {
	
	private static MessageAPI instance;
	
	public void onEnable() {
		instance = this;
	}
	
	public static MessageAPI getInstance() {
		return instance;
	}
	
	public MessageManager getMessageManager(Plugin plugin) {
		MessageManager manager = new MessageManager(Bukkit.getPluginManager().getPlugin(plugin.getDescription().getName()));
		return manager;
	}

}
