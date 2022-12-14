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

public class Scream implements Listener {

    @EventHandler
    public void onScream(PlayerInteractEvent event){

        Player player = event.getPlayer();

        String prefix = ChatColor.GREEN + "" + ChatColor.BOLD + "MMCForce " + ChatColor.DARK_GRAY + "» ";

        if(ForceSideConfig.get().getString(player.getUniqueId().toString()) != null){
            if(ForceSideConfig.get().getString(player.getUniqueId().toString()).equalsIgnoreCase("dark")) {
                if (event.getAction().equals(Action.LEFT_CLICK_AIR)) {
                    if (player.getInventory().getItemInMainHand().getType() == Material.FEATHER && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Force Scream")) {
                        if (!MMCForce.cooldown.containsKey(player.getUniqueId())) {
                            MMCForce.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 2));
                            player.sendMessage(prefix + ChatColor.GRAY + "You used Force Scream!");
                        }else{
                            long timeElapsed = System.currentTimeMillis() - MMCForce.cooldown.get(player.getUniqueId());
                            if (timeElapsed >= 3000) {
                                MMCForce.cooldown.remove(player.getUniqueId());
                            } else {
                                player.sendMessage(ChatColor.GOLD + "You can't use Force Scream for another " + ChatColor.RED + "" + ((3000 - timeElapsed) / 1000) + "" + ChatColor.GOLD + " seconds!");
                            }
                        }
                    }
                }
            }else if(ForceSideConfig.get().getString(player.getUniqueId().toString()).equalsIgnoreCase("light")) {
                if (event.getAction().equals(Action.LEFT_CLICK_AIR)) {
                    if (player.getInventory().getItemInMainHand().getType() == Material.FEATHER && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Force Scream")) {
                        player.sendMessage(ChatColor.RED + "The force is not with you.");
                    }
                }
            }
        }
    }

}
