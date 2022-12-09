package mandomc.mmcforce.listeners.forcepowers;

import mandomc.mmcforce.MMCForce;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class Telekinesis implements Listener {

    @EventHandler
    public void onTelekinesis(PlayerInteractEvent event){

        Player player = event.getPlayer();

        String prefix = ChatColor.GREEN + "" + ChatColor.BOLD + "MMCForce " + ChatColor.DARK_GRAY + "» ";

        if (event.getAction().equals(Action.LEFT_CLICK_AIR)) {
            if (player.getInventory().getItemInMainHand().getType() == Material.FEATHER// light blue glass pane?
                    && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Force Telekinesis")) { //name?
                if (!MMCForce.cooldown.containsKey(player.getUniqueId())) {
                    MMCForce.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                    for (Entity entity : player.getNearbyEntities(8, 8, 8)) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity livingEntity = (LivingEntity) entity;
                            double livingEntityHealth = livingEntity.getHealth();
                            livingEntity.setHealth(livingEntityHealth - 2.0);
                            Vector vector = genVec(player.getLocation(), livingEntity.getLocation());
                            vector.setY(1);
                            livingEntity.setVelocity(vector);
                        }
                    }
                    player.sendMessage(prefix + ChatColor.GRAY + "You used Force Push!");
                }
                else{
                    long timeElapsed = System.currentTimeMillis() - MMCForce.cooldown.get(player.getUniqueId());
                    if(timeElapsed>=3000){
                        MMCForce.cooldown.remove(player.getUniqueId());
                    }else{
                        player.sendMessage(ChatColor.GOLD + "You can't use Force Push for another " + ChatColor.RED + "" + ((3000 - timeElapsed)/1000) + "" + ChatColor.GOLD + " seconds!");

                    }
                }
            }
        }
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (player.getInventory().getItemInMainHand().getType() == Material.FEATHER// light blue glass pane?
                    && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Force Telekinesis")) { //name?
                if (!MMCForce.cooldown.containsKey(player.getUniqueId())) {
                    MMCForce.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                    for (Entity entity : player.getNearbyEntities(15, 15, 15)) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity livingEntity = (LivingEntity) entity;
                            double livingEntityHealth = livingEntity.getHealth();
                            livingEntity.setHealth(livingEntityHealth - 2.0);
                            Vector vector = genVec(livingEntity.getLocation(), player.getLocation());
                            livingEntity.setVelocity(vector);
                        }
                    }
                    player.sendMessage(prefix + ChatColor.GRAY + "You used Force Pull!");
                }else{
                    long timeElapsed = System.currentTimeMillis() - MMCForce.cooldown.get(player.getUniqueId());
                    if (timeElapsed >= 3000) {
                        MMCForce.cooldown.remove(player.getUniqueId());
                    } else {
                        player.sendMessage(ChatColor.GOLD + "You can't use Force Pull for another " + ChatColor.RED + "" + ((3000 - timeElapsed) / 1000) + "" + ChatColor.GOLD + " seconds!");

                    }
                }
            }
        }

    }

    public static Vector genVec(Location a, Location b) {
        double dX = a.getX() - b.getX();
        double dY = a.getY() - b.getY();
        double dZ = a.getZ() - b.getZ();
        double yaw = Math.atan2(dZ, dX);
        double pitch = Math.atan2(Math.sqrt(dZ * dZ + dX * dX), dY) + Math.PI;
        double x = Math.sin(pitch) * Math.cos(yaw);
        double y = Math.sin(pitch) * Math.sin(yaw);
        double z = Math.cos(pitch);

        Vector vector = new Vector(x, z, y);
        vector = vector.normalize();

        return vector;
    }

}
