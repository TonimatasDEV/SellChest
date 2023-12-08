package net.tonimatasdev.sellchest.chest;

import net.tonimatasdev.sellchest.upgrade.Tier;
import net.tonimatasdev.sellchest.util.Messages;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class SellChestBlock {
    public Player owner;
    public Location location;
    public Tier tier;
    public Material type;

    public SellChestBlock(Player player, Location location, Tier tier) {
        this.owner = player;
        this.location = location;
        this.tier = tier;
        //this.type = tier.getType();

        //world.setType(x, y, z, type);
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
        player.sendMessage(Messages.getPrefix(ChatColor.DARK_GREEN) + "Has colocado un cofre de venta");
    }

    public Inventory getInventory() {
        return Bukkit.createInventory(null, 9*6);
    }
}
