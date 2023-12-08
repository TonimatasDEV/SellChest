package net.tonimatasdev.sellchest.util;

import org.bukkit.ChatColor;

public class Messages {
    public static String getPrefix(ChatColor chatColor) {
        return ChatColor.WHITE + "[" + chatColor + "+" + ChatColor.WHITE + "] SellChest: " + ChatColor.WHITE;
    }
}
