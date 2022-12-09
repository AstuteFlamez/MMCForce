package mandomc.mmcforce.commands;

import mandomc.mmcforce.handlers.ISC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ForceSide implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            Inventory side = Bukkit.createInventory(player, 9, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Select Your Side!");

            side.setItem(3, ISC.createItem(Material.RED_GLAZED_TERRACOTTA, ChatColor.DARK_RED + "" + ChatColor.BOLD + "The Dark Side"));
            side.setItem(5, ISC.createItem(Material.BLUE_GLAZED_TERRACOTTA, ChatColor.BLUE + "" + ChatColor.BOLD + "The Light Side"));

            player.openInventory(side);
        }

        return true;
    }
}
