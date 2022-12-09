package mandomc.mmcforce.commands;

import mandomc.mmcforce.configs.ForceSideConfig;
import mandomc.mmcforce.handlers.ISC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Force implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String prefix = ChatColor.GREEN + "" + ChatColor.BOLD + "MMCForce " + ChatColor.DARK_GRAY + "» ";

        if(sender instanceof Player){
            Player player = (Player) sender;

            Inventory lightSide = Bukkit.createInventory(player, 54, ChatColor.BLUE + "" + ChatColor.BOLD + "Light Side Force Powers");

            lightSide.setItem(0, ISC.createItem(Material.FEATHER, ChatColor.GRAY + "Force Telekinesis", 11,"", ChatColor.GRAY + "Pushes and pulles nearby entities back!", "", ChatColor.GOLD + "Ability: Force Push ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", ChatColor.GOLD + "Ability: Force Pull ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " RIGHT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            lightSide.setItem(1, ISC.createItem(Material.FEATHER, ChatColor.GRAY + "Force Dash", 3,"", ChatColor.GRAY + "Gain Speed IV for 5 seconds!", "", ChatColor.GOLD + "Ability: Force Dash ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            lightSide.setItem(2, ISC.createItem(Material.FEATHER, ChatColor.GRAY + "Force Stasis", 9,"", ChatColor.GRAY + "Slow nearby enemies for 10 seconds", "", ChatColor.GOLD + "Ability: Force Stasis ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            lightSide.setItem(9, ISC.createItem(Material.FEATHER, ChatColor.BLUE + "Force Heal", 5,"", ChatColor.GRAY + "Regain 2 hearts!", "", ChatColor.GOLD + "Ability: Force Heal ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            lightSide.setItem(10, ISC.createItem(Material.FEATHER, ChatColor.BLUE + "Force Light", 6,"", ChatColor.GRAY + "Give weakness to nearby enemies!", "", ChatColor.GOLD + "Ability: Force Light ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            lightSide.setItem(11, ISC.createItem(Material.FEATHER, ChatColor.BLUE + "Force Stealth", 10,"", ChatColor.GRAY + "Turn invisible for 15 seconds", "", ChatColor.GOLD + "Ability: Force Stealth ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            if(ForceSideConfig.get().getString(player.getUniqueId().toString()) != null){
                if(ForceSideConfig.get().getString(player.getUniqueId().toString()).equalsIgnoreCase("light")){
                    player.openInventory(lightSide);
                }
            }else{
                player.sendMessage(ChatColor.RED + "The force is not with you.");
            }

            Inventory darkSide = Bukkit.createInventory(player, 54, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Dark Side Force Powers");

            darkSide.setItem(0, ISC.createItem(Material.FEATHER, ChatColor.GRAY + "Force Telekinesis", 11, "", ChatColor.GRAY + "Pushes and pulles nearby enemies back!", "", ChatColor.GOLD + "Ability: Force Push ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", ChatColor.GOLD + "Ability: Force Pull ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " RIGHT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            darkSide.setItem(1, ISC.createItem(Material.FEATHER, ChatColor.GRAY + "Force Dash", 3, "", ChatColor.GRAY + "Gain Speed IV for 5 seconds!", "", ChatColor.GOLD + "Ability: Force Dash ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            darkSide.setItem(2, ISC.createItem(Material.FEATHER, ChatColor.GRAY + "Force Stasis", 9, "", ChatColor.GRAY + "Slow nearby enemies for 10 seconds", "", ChatColor.GOLD + "Ability: Force Stasis ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            darkSide.setItem(9, ISC.createItem(Material.FEATHER, ChatColor.DARK_RED + "Force Lightning", 7,"", ChatColor.GRAY + "Strike nearby enemies with lightning!", "", ChatColor.GOLD + "Ability: Force Lightning ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            darkSide.setItem(10, ISC.createItem(Material.FEATHER, ChatColor.DARK_RED + "Force Choke", 1,"", ChatColor.GRAY + "Choke out nearby enemies!", "", ChatColor.GOLD + "Ability: Force Choke ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            darkSide.setItem(11, ISC.createItem(Material.FEATHER, ChatColor.DARK_RED + "Force Scream", 8, "", ChatColor.GRAY + "Gain Strength III for 5 seconds!", "", ChatColor.GOLD + "Ability: Force Scream ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            darkSide.setItem(12, ISC.createItem(Material.FEATHER, ChatColor.DARK_RED + "Force Crush", 2,"", ChatColor.GRAY + "Instantly take away 2 hearts from nearby enemies!", "", ChatColor.GOLD + "Ability: Force Crush ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            darkSide.setItem(13, ISC.createItem(Material.FEATHER, ChatColor.DARK_RED + "Force Drain", 4, "", ChatColor.GRAY + "Take 1 heart from nearby enemies for yourself!", "", ChatColor.GOLD + "Ability: Force Drain ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            darkSide.setItem(14, ISC.createItem(Material.FEATHER, ChatColor.DARK_RED + "Force Blind", 0, "", ChatColor.GRAY + "Blind everyone and everything around you!", "", ChatColor.GOLD + "Ability: Force Blind ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            if(ForceSideConfig.get().getString(player.getUniqueId().toString()) != null){
                if(ForceSideConfig.get().getString(player.getUniqueId().toString()).equalsIgnoreCase("dark")){
                    player.openInventory(darkSide);
                }
            }else{
                player.sendMessage(ChatColor.RED + "The force is not with you.");
            }

        }

        return true;
    }
}
