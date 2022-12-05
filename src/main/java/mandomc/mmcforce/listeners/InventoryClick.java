package mandomc.mmcforce.listeners;

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

        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Select Your Side!")){
            switch (event.getCurrentItem().getType()){
                case RED_GLAZED_TERRACOTTA:
                    break;
                case BLUE_GLAZED_TERRACOTTA:
                    break;
            }
        }


    }

}
