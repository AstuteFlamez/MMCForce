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

public class Slow implements Listener {

    @EventHandler
    public void onSlow(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if(ForceSideConfig.get().getString(player.getUniqueId().toString()) != null){
            if(ForceSideConfig.get().getString(player.getUniqueId().toString()).equalsIgnoreCase("dark")){
                if(player.getInventory().getItemInMainHand().getType() == Material.FEATHER && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Force Slow")){
                    for(Entity entity : player.getNearbyEntities(5, 5, 5)){
                        if(!MMCForce.cooldown.containsKey(player.getUniqueId())){
                            MMCForce.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                            if(entity instanceof LivingEntity){
                                LivingEntity livingEntity = (LivingEntity) entity;
                                livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 2));
                                player.sendMessage(ChatColor.DARK_RED + "They've all been slowed, deal the finishing blow!");
                            }else{
                                player.sendMessage(ChatColor.GOLD + "There were no near entities in range.");
                            }
                        }else{
                            long timeElapsed = System.currentTimeMillis() - MMCForce.cooldown.get(player.getUniqueId());
                            if(timeElapsed>=3000){
                                MMCForce.cooldown.remove(player.getUniqueId());
                            }else{
                                player.sendMessage(ChatColor.GOLD + "You can't use Force Slow for another " + ChatColor.RED + "" + ((3000 - timeElapsed)/1000) + "" + ChatColor.GOLD + " seconds!");

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
