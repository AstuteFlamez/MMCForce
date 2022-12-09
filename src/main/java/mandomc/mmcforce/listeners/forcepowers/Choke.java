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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Choke implements Listener {

    @EventHandler
    public void onChoke(PlayerInteractEvent event){

        Player player = event.getPlayer();

        String prefix = ChatColor.GREEN + "" + ChatColor.BOLD + "MMCForce " + ChatColor.DARK_GRAY + "» ";

        if(ForceSideConfig.get().getString(player.getUniqueId().toString()) != null){
            if(ForceSideConfig.get().getString(player.getUniqueId().toString()).equalsIgnoreCase("dark")) {
                if (event.getAction().equals(Action.LEFT_CLICK_AIR)) {
                    if (player.getInventory().getItemInMainHand().getType() == Material.FEATHER && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Force Choke")) {
                        if (!MMCForce.cooldown.containsKey(player.getUniqueId())) {
                            MMCForce.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                            for (Entity entity : player.getNearbyEntities(5, 5, 5)) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity livingEntity = (LivingEntity) entity;
                                    livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 120, 0));
                                    livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 120, 0));
                                }
                            }
                            player.sendMessage(prefix + ChatColor.GRAY + "You used Force Choke!");
                        }else {
                            long timeElapsed = System.currentTimeMillis() - MMCForce.cooldown.get(player.getUniqueId());
                            if (timeElapsed >= 3000) {
                                MMCForce.cooldown.remove(player.getUniqueId());
                            } else {
                                player.sendMessage(ChatColor.GOLD + "You can't use Force Choke for another " + ChatColor.RED + "" + ((3000 - timeElapsed) / 1000) + "" + ChatColor.GOLD + " seconds!");

                            }
                        }
                    }
                }
            }else if(ForceSideConfig.get().getString(player.getUniqueId().toString()).equalsIgnoreCase("light")) {
                if (event.getAction().equals(Action.LEFT_CLICK_AIR)) {
                    if (player.getInventory().getItemInMainHand().getType() == Material.FEATHER && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Force Choke")) {
                        player.sendMessage(ChatColor.RED + "The force is not with you.");
                    }
                }
            }
        }
    }

}
