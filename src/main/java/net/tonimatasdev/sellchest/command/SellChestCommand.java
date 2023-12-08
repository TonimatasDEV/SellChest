package net.tonimatasdev.sellchest.command;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import net.tonimatasdev.sellchest.util.Messages;
import net.tonimatasdev.sellchest.util.NBTUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import net.tonimatasdev.sellchest.SellChest;
import org.bukkit.inventory.ItemStack;

public class SellChestCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args[0].equalsIgnoreCase("reload") && hasPermission(sender, "sellchest.reload")) {
            sender.sendMessage("Reloaded");
        }

        if (args[0].equalsIgnoreCase("version") && hasPermission(sender, "sellchest.version")) {
            sender.sendMessage(Messages.getPrefix(ChatColor.DARK_GREEN) + "The plugin version is: " + SellChest.getInstance().getDescription().getVersion());
        }

        if (args[0].equals("give")) {
            ItemStack itemStack = new ItemStack(Material.CHEST);
            NBTUtils.setItemNbtTag(itemStack, "sellchest", "true"); // TODO: Change true to tier
            if (sender instanceof Player player) {
                player.sendMessage("Things");
                player.getInventory().addItem(itemStack);
            }


            //Tier.valueOf(args[1]);
        }

        return true;
    }

    private boolean hasPermission(CommandSender sender, String permission) {
        if (sender.hasPermission(permission)) {
            return true;
        } else {
            sender.sendMessage(Messages.getPrefix(ChatColor.DARK_RED) + "You don't have permissions for execute this command");
            return false;
        }
    }


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> argList = new ArrayList<>();

        if (command.getName().equalsIgnoreCase("sellchest")) {
            if (args.length == 1) {
                argList.add("reload");
                argList.add("give");
                return argList;
            }

            if (args.length == 2 && args[0].equalsIgnoreCase("give")) {
                //argList.addAll(Arrays.stream(Tier.values()).map(Tier::name).collect(Collectors.toList()));
                return argList;
            }

            if (args.length == 3 && args[0].equalsIgnoreCase("give")) {
                argList.add("1");
                return argList;
            }

            if (args.length == 4 && args[0].equalsIgnoreCase("give")) {
                argList.addAll(sender.getServer().getOnlinePlayers().stream().map(Player::getName).collect(Collectors.toList()));
                return argList;
            }
        }

        return null;
    }
}
