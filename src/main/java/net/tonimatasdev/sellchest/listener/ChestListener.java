package net.tonimatasdev.sellchest.listener;

import net.tonimatasdev.sellchest.chest.SellChestBlock;
import net.tonimatasdev.sellchest.chest.ChestManager;
import net.tonimatasdev.sellchest.util.NBTUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.Lidded;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ChestListener implements Listener {
    @EventHandler
    private void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = event.getItemInHand();
        Block block = event.getBlockPlaced();

        if (itemStack.getType() != Material.CHEST) return;

        if (NBTUtils.hasItemNbtTag(itemStack, "sellchest")) {
            Location location = new Location(player.getWorld(), block.getX(), block.getY(), block.getZ());
            player.sendMessage(block.getX() + " " + block.getY() + " " + block.getZ());
            ChestManager.chests.put(location, new SellChestBlock(player, location, null));
        }
    }

    @EventHandler
    private void onPlayerClickChest(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (block == null) return;

            Location location = new Location(player.getWorld(), block.getX(), block.getY(), block.getZ());
            SellChestBlock sellChestBlock = ChestManager.chests.get(location);
            if (sellChestBlock == null) return;

            Inventory inventory = sellChestBlock.getInventory();

            ChestManager.inventories.put(inventory, location);
            player.openInventory(inventory);

            if (block.getState() instanceof Lidded lidded) {
                lidded.open();
            }

            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onCloseInventory(InventoryCloseEvent event) {
        if (ChestManager.inventories.containsKey(event.getInventory())) {
            Location location = ChestManager.inventories.get(event.getInventory());
            ChestManager.inventories.remove(event.getInventory());

            Block block = event.getPlayer().getWorld().getBlockAt(location);

            if (block.getState() instanceof Lidded lidded) {
                lidded.close();
            }
        }
    }
}
