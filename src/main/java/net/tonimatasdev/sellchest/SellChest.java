package net.tonimatasdev.sellchest;

import net.tonimatasdev.sellchest.command.SellChestCommand;
import net.tonimatasdev.sellchest.listener.BlockPlaceListener;
import net.tonimatasdev.sellchest.upgrade.Tier;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class SellChest extends JavaPlugin {
    private static SellChest instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);

        Objects.requireNonNull(getCommand("sellchest")).setExecutor(new SellChestCommand());
        Objects.requireNonNull(getCommand("sellchest")).setTabCompleter(new SellChestCommand());
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
