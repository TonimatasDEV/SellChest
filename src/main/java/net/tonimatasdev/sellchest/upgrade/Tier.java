package net.tonimatasdev.sellchest.upgrade;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.Material;

public class Tier {
    private String name;
    private Material voidMaterial;
    private List<Integer> sellSlots;

    // Sell item
    // Sell item boolean
    // Sell item position
    // Auto sell item
    // Auto sell item boolean
    // Auto sell item position
    // Auto sell time
    // Auto sell instant
    // Accept hopper items (boolean)

    public Tier(String name, Material voidMaterial, String sellSlots) {
        this.name = name;
        this.voidMaterial = voidMaterial;
        this.sellSlots = Arrays.stream(sellSlots.split(",")).map((Integer::parseInt)).collect(Collectors.toList());


        TierManager.tiers.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
