package org.cbplugins.messageapi;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.cbplugins.messageapi.file.MessageFile;
import org.cbplugins.messageapi.file.MessageFileType;
import org.cbplugins.messageapi.util.LanguageUtil;

public class MessageManager {
	
	private MessageFile en_US = null;
	private MessageFile de_DE = null;
	private MessageFile fr_FR = null;
	private MessageFile es_ES = null;
	private MessageFile sv_SE = null;
	
	public MessageManager(Plugin plugin) {
		en_US = new MessageFile(MessageFileType.en_US, plugin.getDescription().getName());
		de_DE = new MessageFile(MessageFileType.de_DE, plugin.getDescription().getName());
		fr_FR = new MessageFile(MessageFileType.fr_FR, plugin.getDescription().getName());
		es_ES = new MessageFile(MessageFileType.es_ES, plugin.getDescription().getName());
		sv_SE = new MessageFile(MessageFileType.sv_SE, plugin.getDescription().getName());
	}
	
	public void loadFiles() {
		en_US.loadFile();
		de_DE.loadFile();
		fr_FR.loadFile();
		es_ES.loadFile();
		sv_SE.loadFile();
	}
	
	public String getRawMessage(Player player, String key) {
		String l = LanguageUtil.getLanguage(player);
		if(l.equalsIgnoreCase("en_US")) {
			return en_US.getRawMessage(key);
		}else if(l.equalsIgnoreCase("de_DE")) {
			return de_DE.getRawMessage(key);
		}else if(l.equalsIgnoreCase("fr_FR")) {
			return fr_FR.getRawMessage(key);
		}else if(l.equalsIgnoreCase("es_ES")) {
			return es_ES.getRawMessage(key);
		}else if(l.equalsIgnoreCase("sv_SE")){
			return sv_SE.getRawMessage(key);
		}else {
			return "ERROR: CAN'T GET LANGUAGE";
		}
	}
	
	public String getColoredMessage(Player player, String key, char regex) {
		String l = LanguageUtil.getLanguage(player);
		if(l.equalsIgnoreCase("en_US")) {
			return en_US.getColoredMessage(key, regex);
		}else if(l.equalsIgnoreCase("de_DE")) {
			return de_DE.getColoredMessage(key, regex);
		}else if(l.equalsIgnoreCase("fr_FR")) {
			return fr_FR.getColoredMessage(key, regex);
		}else if(l.equalsIgnoreCase("es_ES")) {
			return es_ES.getColoredMessage(key, regex);
		}else if(l.equalsIgnoreCase("sv_SE")) {
			return sv_SE.getColoredMessage(key, regex);
		}else {
			return "§cERROR: §4CAN'T GET LANGUAGE";
		}
	}
	
	public String getReplacedMessage(Player player, String key, HashMap<String, String> replace) {
		String l = LanguageUtil.getLanguage(player);
		if(l.equalsIgnoreCase("en_US")) {
			return en_US.getReplacedMessage(key, replace);
		}else if(l.equalsIgnoreCase("de_DE")) {
			return de_DE.getReplacedMessage(key, replace);
		}else if(l.equalsIgnoreCase("fr_FR")) {
			return fr_FR.getReplacedMessage(key, replace);
		}else if(l.equalsIgnoreCase("es_ES")) {
			return es_ES.getReplacedMessage(key, replace);
		}else if(l.equalsIgnoreCase("sv_SE")){
			return sv_SE.getReplacedMessage(key, replace);
		}else {
			return "ERROR: CAN'T GET LANGUAGE";
		}
	}
	
	public String getReplacedColoredMessage(Player player, String key, char regex, HashMap<String, String> replace) {
		String l = LanguageUtil.getLanguage(player);
		if(l.equalsIgnoreCase("en_US")) {
			return en_US.getReplacedColoredMessage(key, regex, replace);
		}else if(l.equalsIgnoreCase("de_DE")) {
			return de_DE.getReplacedColoredMessage(key, regex, replace);
		}else if(l.equalsIgnoreCase("fr_FR")) {
			return fr_FR.getReplacedColoredMessage(key, regex, replace);
		}else if(l.equalsIgnoreCase("es_ES")) {
			return es_ES.getReplacedColoredMessage(key, regex, replace);
		}else if(l.equalsIgnoreCase("sv_SE")) {
			return sv_SE.getReplacedColoredMessage(key, regex, replace);
		} else {
			return "§cERROR: §4CAN'T GET LANGUAGE";
		}
	}
	
}
