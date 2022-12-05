package mandomc.mmcforce.listeners;

import mandomc.mmcforce.configs.ForceSideConfig;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class InventoryClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();

        String prefix = ChatColor.GREEN + "" + ChatColor.BOLD + "MMCForce " + ChatColor.DARK_GRAY + "» ";

        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Select Your Side!")){
            switch (event.getCurrentItem().getType()){
                case RED_GLAZED_TERRACOTTA:
                    ForceSideConfig.get().addDefault(player.getUniqueId().toString(), "dark");
                    player.closeInventory();
                    event.setCancelled(true);
                    player.sendMessage(prefix + ChatColor.GRAY + "You have joined the "
                            + ChatColor.DARK_RED + "" + ChatColor.BOLD + "Dark Side" + ChatColor.GRAY + "!");
                    break;
                case BLUE_GLAZED_TERRACOTTA:
                    ForceSideConfig.get().addDefault(player.getUniqueId().toString(), "light");
                    player.closeInventory();
                    event.setCancelled(true);
                    player.sendMessage(prefix + ChatColor.GRAY + "You have joined the "
                            + ChatColor.BLUE + "" + ChatColor.BOLD + "Light Side" + ChatColor.GRAY + "!");
                    break;
            }
        }


    }

}
