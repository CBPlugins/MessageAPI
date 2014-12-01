package org.cbplugins.messageapi.util;

import net.minecraft.server.v1_7_R4.EntityPlayer;

import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class LanguageUtil {

	public static String getLanguage(Player p) {
		EntityPlayer ep = ((CraftPlayer)p).getHandle();
		String locale = ep.locale;
		return locale;
	}
	
}
