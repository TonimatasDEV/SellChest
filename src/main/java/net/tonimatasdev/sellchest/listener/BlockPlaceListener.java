package net.tonimatasdev.sellchest.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {
    @EventHandler
    private static void onBlockPlace(BlockPlaceEvent event) {
        if (event.getItemInHand().getType() != Material.CHEST) return;

        event.setCancelled(true);
    }
}
