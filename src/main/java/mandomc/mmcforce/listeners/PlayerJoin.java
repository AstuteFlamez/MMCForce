package mandomc.mmcforce.listeners;

import mandomc.mmcforce.configs.ForceSideConfig;
import mandomc.mmcforce.handlers.ISC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.scoreboard.*;

public class PlayerJoin implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        if(!player.hasPlayedBefore()){

            Inventory side = Bukkit.createInventory(player, 9, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Select Your Side!");

            side.setItem(3, ISC.createItem(Material.RED_GLAZED_TERRACOTTA, ChatColor.DARK_RED + "" + ChatColor.BOLD + "The Dark Side"));
            side.setItem(5, ISC.createItem(Material.BLUE_GLAZED_TERRACOTTA, ChatColor.BLUE + "" + ChatColor.BOLD + "The Light Side"));

            player.openInventory(side);

            ForceSideConfig.get().addDefault(player.getUniqueId().toString(), "none");

        }
    }
}
