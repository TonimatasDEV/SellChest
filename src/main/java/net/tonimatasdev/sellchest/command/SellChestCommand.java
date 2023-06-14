package net.tonimatasdev.sellchest.command;

import net.tonimatasdev.sellchest.upgrade.Tier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SellChestCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (args[0].equalsIgnoreCase("reload")) {
            sender.sendMessage("Reloaded");
        }


        if (args[0].equals("give")) {
            if (Arrays.asList(Tier.values()).contains(Tier.getTier(args[1]))) {

            }
        }

        return true;
    }


    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> argList = new ArrayList<>();

        if (command.getName().equalsIgnoreCase("sellchest")) {
            if (args.length == 1) {
                argList.add("reload");
                argList.add("give");
                return argList;
            }

            if (args.length == 2 && args[0].equalsIgnoreCase("give")) {
                argList.addAll(Arrays.stream(Tier.values()).map(Tier::name).toList());
                return argList;
            }

            if (args.length == 3 && args[0].equalsIgnoreCase("give")) {
                argList.add("1");
                return argList;
            }

            if (args.length == 4 && args[0].equalsIgnoreCase("give")) {
                argList.addAll(sender.getServer().getOnlinePlayers().stream().map(Player::getName).toList());
                return argList;
            }
        }

        return null;
    }
}
