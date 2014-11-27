package org.cbplugins.messageapi.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import org.bukkit.ChatColor;

public class MessageFile {

	private MessageFileType type;
	
	private String subDir;
	
	private HashMap<String, String> messages = new HashMap<String, String>();
	
	public MessageFile(MessageFileType type, String subDir) {
		this.type = type;
		this.subDir = subDir;
	}
	
	public void loadFile() {
		if(!checkExisting()) {
			return;
		}else {
			messages.clear();
			try{
				File f = new File("plugins/MessageAPI/"+subDir, type.getFileName());
				BufferedReader br = new BufferedReader(new FileReader(f));
				String line;
				boolean firstLine = true;
				while((line = br.readLine()) != null) {
					if(firstLine) {
						if(!line.contains(type.getID())) {
							break;
						}else {
							firstLine = false;
						}
					}else {
						String[] split = line.split("=");
						messages.put(split[0], split[1]);
					}
				}
				br.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean checkExisting() {
		File file = new File("plugins/MessageAPI/"+subDir, type.getFileName());
		
		return file.exists();
	}
	
	public String getRawMessage(String key) {
		return messages.get(key);
	}
	
	public String getColoredMessage(String key, char regex) {
		return ChatColor.translateAlternateColorCodes(regex, messages.get(key));
	}
	
	public String getReplacedMessage(String key, HashMap<String, String> replace) {
		String message = messages.get(key);
		for(String s : replace.keySet()) {
			message = message.replaceAll(s, replace.get(s));
		}
		return message;
	}
	
	public String getReplacedColoredMessage(String key, char regex, HashMap<String, String> replace) {
		String message = getReplacedMessage(key, replace);
		message = ChatColor.translateAlternateColorCodes(regex, message);
		return message;
	}
	
}
