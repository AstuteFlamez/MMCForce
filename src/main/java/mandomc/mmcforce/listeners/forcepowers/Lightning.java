package mandomc.mmcforce.listeners.forcepowers;

import mandomc.mmcforce.MMCForce;
import mandomc.mmcforce.configs.ForceSideConfig;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Lightning implements Listener {

    @EventHandler
    public void onLightning(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if(ForceSideConfig.get().getString(player.getUniqueId().toString()) != null){
            if(ForceSideConfig.get().getString(player.getUniqueId().toString()).equalsIgnoreCase("dark")){
                if(event.getAction().equals(Action.LEFT_CLICK_AIR)) {
                    if (player.getInventory().getItemInMainHand().getType() == Material.FEATHER && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Force Lightning")) {
                        player.sendMessage("0");
                        if (!MMCForce.cooldown.containsKey(player.getUniqueId())) {
                            MMCForce.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                            player.sendMessage("0");
                            for (Entity entity : player.getNearbyEntities(15, 15, 15)) {
                                if (entity instanceof LivingEntity) {
                                    player.sendMessage("0");
                                    LivingEntity livingEntity = (LivingEntity) entity;

                                    player.getWorld().strikeLightning(livingEntity.getLocation());

                                    player.sendMessage(ChatColor.DARK_RED + "All enemies around you have been burned with lightning.");
                                } else {
                                    player.sendMessage(ChatColor.GOLD + "There were no near entities in range.");
                                }
                            }
                        } else {
                            long timeElapsed = System.currentTimeMillis() - MMCForce.cooldown.get(player.getUniqueId());
                            if (timeElapsed >= 3000) {
                                MMCForce.cooldown.remove(player.getUniqueId());
                            } else {
                                player.sendMessage(ChatColor.GOLD + "You can't use Force Lightning for another " + ChatColor.RED + "" + ((3000 - timeElapsed) / 1000) + "" + ChatColor.GOLD + " seconds!");

                            }
                        }
                    }
                }
            }else{
                player.sendMessage(ChatColor.RED + "The force is not with you.");
            }
        }

    }

}
