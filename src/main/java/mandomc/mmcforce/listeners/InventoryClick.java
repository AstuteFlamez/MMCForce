package mandomc.mmcforce.listeners;

import mandomc.mmcforce.configs.ForceSideConfig;
import mandomc.mmcforce.handlers.ISC;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();

        String prefix = ChatColor.GREEN + "" + ChatColor.BOLD + "MMCForce " + ChatColor.DARK_GRAY + "» ";

        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Select Your Side!")){

            switch (event.getCurrentItem().getType()){
                case RED_GLAZED_TERRACOTTA:
                    ForceSideConfig.get().set(player.getUniqueId().toString(), "dark");
                    ForceSideConfig.save();
                    player.closeInventory();
                    player.sendMessage(prefix + ChatColor.GRAY + "You have joined the "
                            + ChatColor.DARK_RED + "" + ChatColor.BOLD + "Dark Side" + ChatColor.GRAY + "!");
                    break;
                case BLUE_GLAZED_TERRACOTTA:
                    ForceSideConfig.get().set(player.getUniqueId().toString(), "light");
                    ForceSideConfig.save();
                    player.closeInventory();
                    player.sendMessage(prefix + ChatColor.GRAY + "You have joined the "
                            + ChatColor.BLUE + "" + ChatColor.BOLD + "Light Side" + ChatColor.GRAY + "!");
                    break;
            }
            event.setCancelled(true);
        }
        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "" + ChatColor.BOLD + "Light Side Force Powers")){
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Force Heal")){
                player.getInventory().addItem(ISC.createItem(Material.FEATHER, ChatColor.BLUE + "Force Heal", "", ChatColor.GRAY + "Regain 2 hearts!", "", ChatColor.GOLD + "Ability: Force Heal ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Force Telekinesis")){
                player.getInventory().addItem(ISC.createItem(Material.FEATHER, ChatColor.GRAY + "Force Telekinesis", "", ChatColor.GRAY + "Pushes and pulles nearby entities back!", "", ChatColor.GOLD + "Ability: Force Push ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", ChatColor.GOLD + "Ability: Force Pull ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " RIGHT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Force Dash")){
                player.getInventory().addItem(ISC.createItem(Material.FEATHER, ChatColor.GRAY + "Force Dash", "", ChatColor.GRAY + "Gain Speed IV for 5 seconds!", "", ChatColor.GOLD + "Ability: Force Dash ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Force Stasis")){
                player.getInventory().addItem(ISC.createItem(Material.FEATHER, ChatColor.GRAY + "Force Stasis", "", ChatColor.GRAY + "Slow nearby enemies for 10 seconds", "", ChatColor.GOLD + "Ability: Force Stasis ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Force Light")){
                player.getInventory().addItem(ISC.createItem(Material.FEATHER, ChatColor.BLUE + "Force Light", "", ChatColor.GRAY + "Give weakness to nearby enemies!", "", ChatColor.GOLD + "Ability: Force Light ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Force Stealth")){
                player.getInventory().addItem(ISC.createItem(Material.FEATHER, ChatColor.BLUE + "Force Stealth", "", ChatColor.GRAY + "Turn invisible for 15 seconds", "", ChatColor.GOLD + "Ability: Force Stealth ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            }
            event.setCancelled(true);
        }
        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Dark Side Force Powers")){
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Force Telekinesis")){
                player.getInventory().addItem(ISC.createItem(Material.FEATHER, ChatColor.GRAY + "Force Telekinesis", "", ChatColor.GRAY + "Pushes and pulles nearby entities back!", "", ChatColor.GOLD + "Ability: Force Push ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", ChatColor.GOLD + "Ability: Force Pull ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " RIGHT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Force Dash")){
                player.getInventory().addItem(ISC.createItem(Material.FEATHER, ChatColor.GRAY + "Force Dash", "", ChatColor.GRAY + "Gain Speed IV for 5 seconds!", "", ChatColor.GOLD + "Ability: Force Dash ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Force Lightning")){
                player.getInventory().addItem( ISC.createItem(Material.FEATHER, ChatColor.DARK_RED + "Force Lightning", "", ChatColor.GRAY + "Strike nearby enemies with lightning!", "", ChatColor.GOLD + "Ability: Force Lightning ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Force Choke")){
                player.getInventory().addItem(ISC.createItem(Material.FEATHER, ChatColor.DARK_RED + "Force Choke", "", ChatColor.GRAY + "Choke out nearby enemies!", "", ChatColor.GOLD + "Ability: Force Choke ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Force Scream")){
                player.getInventory().addItem(ISC.createItem(Material.FEATHER, ChatColor.DARK_RED + "Force Scream", "", ChatColor.GRAY + "Gain Strength III for 5 seconds!", "", ChatColor.GOLD + "Ability: Force Scream ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Force Crush")){
               player.getInventory().addItem(ISC.createItem(Material.FEATHER, ChatColor.DARK_RED + "Force Crush", "", ChatColor.GRAY + "Instantly take away 2 hearts from nearby enemies!", "", ChatColor.GOLD + "Ability: Force Crush ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Force Stasis")){
                player.getInventory().addItem(ISC.createItem(Material.FEATHER, ChatColor.GRAY + "Force Stasis", "", ChatColor.GRAY + "Slow nearby enemies for 10 seconds", "", ChatColor.GOLD + "Ability: Force Stasis ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Force Drain")){
                player.getInventory().addItem(ISC.createItem(Material.FEATHER, ChatColor.DARK_RED + "Force Drain", "", ChatColor.GRAY + "Take 1 heart from nearby enemies for yourself!", "", ChatColor.GOLD + "Ability: Force Drain ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Force Blind")){
                player.getInventory().addItem(ISC.createItem(Material.FEATHER, ChatColor.DARK_RED + "Force Blind", "", ChatColor.GRAY + "Blind everyone and everything around you!", "", ChatColor.GOLD + "Ability: Force Blind ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK", "", ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 seconds"));
            }
            event.setCancelled(true);
        }
    }
}
