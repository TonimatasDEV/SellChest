package net.tonimatasdev.sellchest.chest;

import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChestManager {
    public static final Map<Location, SellChestBlock> chests = new HashMap<>();
    public static Map<Inventory, Location> inventories = new HashMap<>();
}
