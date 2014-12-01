package org.cbplugins.messageapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.cbplugins.messageapi.file.MessageFile;
import org.cbplugins.messageapi.util.LanguageUtil;

public class MessageManager {
	
	private Plugin plugin;
	private Map<String, MessageFile> files = new HashMap<String, MessageFile>();
	private ArrayList<String> langs = new ArrayList<String>();	
	
	public MessageManager(Plugin plugin) {
		this.plugin = plugin;
		langs = MessageAPI.getInstance().getLanguages(plugin);
	}
	
	public void loadFiles() {
		for(String lang : langs) {
			MessageFile file = new MessageFile(lang, plugin.getName());
			file.loadFile();
			files.put(lang, file);
		}
	}
	
	public String getRawMessage(Player player, String key) {
		String l = LanguageUtil.getLanguage(player);
		if(files.containsKey(l)) {
			return files.get(l).getRawMessage(key);
		}else {
			return "No message found.";
		}
	}
	
	public String getColoredMessage(Player player, String key, char regex) {
		String l = LanguageUtil.getLanguage(player);
		if(files.containsKey(l)) {
			return files.get(l).getColoredMessage(key, regex);
		}else {
			return "§4No message found.";
		}
	}
	
	public String getReplacedMessage(Player player, String key, HashMap<String, String> replace) {
		String l = LanguageUtil.getLanguage(player);
		if(files.containsKey(l)) {
			return files.get(l).getReplacedMessage(key, replace);
		}else {
			return "No message found.";
		}
	}
	
	public String getReplacedColoredMessage(Player player, String key, char regex, HashMap<String, String> replace) {
		String l = LanguageUtil.getLanguage(player);
		if(files.containsKey(l)) {
			return files.get(l).getReplacedColoredMessage(key, regex, replace);
		}else {
			return "§4No message found.";
		}
	}
	
}
