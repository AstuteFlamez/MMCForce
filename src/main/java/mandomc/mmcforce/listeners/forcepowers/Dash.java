package mandomc.mmcforce.listeners.forcepowers;

import mandomc.mmcforce.MMCForce;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class Dash implements Listener {

    public void onDash(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if (event.getAction().equals(Action.LEFT_CLICK_AIR)) {
            if (player.getInventory().getItemInMainHand().getType() == Material.FEATHER// light blue glass pane?
                    && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Force Dash")) { //name?
                if(!MMCForce.cooldown.containsKey(player.getUniqueId())){
                    MMCForce.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 3));
                }else{
                    long timeElapsed = System.currentTimeMillis() - MMCForce.cooldown.get(player.getUniqueId());
                    if(timeElapsed>=3000){
                        MMCForce.cooldown.remove(player.getUniqueId());
                    }else{
                        player.sendMessage(ChatColor.GOLD + "You can't use Force Dash for another " + ChatColor.RED + "" + ((3000 - timeElapsed)/1000) + "" + ChatColor.GOLD + " seconds!");

                    }
                }
            }
        }
    }

}
