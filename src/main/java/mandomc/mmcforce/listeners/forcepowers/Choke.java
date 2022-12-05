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
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Choke implements Listener {

    @EventHandler
    public void onChoke(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if(ForceSideConfig.get().getString(player.getUniqueId().toString()) != null){
            if(ForceSideConfig.get().getString(player.getUniqueId().toString()).equalsIgnoreCase("dark")){
                if(player.getInventory().getItemInMainHand().getType() == Material.FEATHER && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Force Choke")){
                    for(Entity entity : player.getNearbyEntities(5, 5, 5)){
                        if(!MMCForce.cooldown.containsKey(player.getUniqueId())){
                            MMCForce.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                            if(entity instanceof LivingEntity){
                                LivingEntity livingEntity = (LivingEntity) entity;
                                livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 60, 0));
                                livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 60, 0));
                                player.sendMessage(ChatColor.DARK_RED + "You slowly choke your surrounding foes.");
                            }else{
                                player.sendMessage(ChatColor.GOLD + "There were no near entities in range.");
                            }
                        }else{
                            long timeElapsed = System.currentTimeMillis() - MMCForce.cooldown.get(player.getUniqueId());
                            if(timeElapsed>=3000){
                                MMCForce.cooldown.remove(player.getUniqueId());
                            }else{
                                player.sendMessage(ChatColor.GOLD + "You can't use Force Choke for another " + ChatColor.RED + "" + ((3000 - timeElapsed)/1000) + "" + ChatColor.GOLD + " seconds!");

                            }
                        }
                    }
                }
            }
        }else{
            player.sendMessage(ChatColor.RED + "The force is not with you.");
        }
    }

}
