package net.tonimatasdev.sellchest;

import org.bukkit.plugin.java.JavaPlugin;

import net.tonimatasdev.sellchest.command.SellChestCommand;
import net.tonimatasdev.sellchest.listener.BlockPlaceListener;

public final class SellChest extends JavaPlugin {
    private static SellChest instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);

        getCommand("sellchest").setExecutor(new SellChestCommand());
        getCommand("sellchest").setTabCompleter(new SellChestCommand());
    }

    @Override
    public void onDisable() {
        reloadConfig();
        saveConfig();
    }

    public static SellChest getInstance() {
        return instance;
    }
}
