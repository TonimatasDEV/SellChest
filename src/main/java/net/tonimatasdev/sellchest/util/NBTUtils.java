package net.tonimatasdev.sellchest.util;

import net.tonimatasdev.sellchest.SellChest;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class NBTUtils {
    public static void setItemNbtTag(ItemStack item, String key, String value) {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;

        meta.getPersistentDataContainer().set(new NamespacedKey(SellChest.getInstance(), key), PersistentDataType.STRING, value);
        item.setItemMeta(meta);
    }

    public static String getItemNbtTag(ItemStack item, String key) {
        ItemMeta meta = item.getItemMeta();

        if (meta != null) return meta.getPersistentDataContainer().get(new NamespacedKey(SellChest.getInstance(), key), PersistentDataType.STRING);
        return null;
    }

    public static boolean hasItemNbtTag(ItemStack item, String key) {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return false;
        return meta.getPersistentDataContainer().has(new NamespacedKey(SellChest.getInstance(), key), PersistentDataType.STRING);
    }
}
