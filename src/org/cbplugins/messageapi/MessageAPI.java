package org.cbplugins.messageapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class MessageAPI extends JavaPlugin {
	
	private static MessageAPI instance;
	
	private static List<String> allowed = new ArrayList<String>();
	
	private static HashMap<Plugin, ArrayList<String>> plugins = new HashMap<Plugin, ArrayList<String>>();
	
	public void onEnable() {
		saveDefaultConfig();
		saveConfig();
		instance = this;
		allowed = getConfig().getStringList("Enabled-Languages");
	}
	
	public static MessageAPI getInstance() {
		return instance;
	}
	
	public MessageManager getMessageManager(Plugin plugin) {
		MessageManager manager = new MessageManager(Bukkit.getPluginManager().getPlugin(plugin.getDescription().getName()));
		return manager;
	}
	
	public void registerLanguage(Plugin plugin, String language) {
		if(!allowed.contains(language)) return;
		ArrayList<String> registered = plugins.get(plugin);
		if(registered == null) {
			registered = new ArrayList<String>();
		}
		registered.add(language);
		plugins.put(plugin, registered);
	}
	
	public void unregisterLanguage(Plugin plugin, String language) {
		if(!allowed.contains(language)) return;
		ArrayList<String> registered = plugins.get(plugin);
		registered.remove(language);
		plugins.put(plugin, registered);
	}
	
	public ArrayList<String> getLanguages(Plugin plugin) {
		return plugins.get(plugin);
	}

}
