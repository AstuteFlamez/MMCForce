package mandomc.mmcforce.commands;

import mandomc.mmcforce.configs.ForceSideConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if(player.hasPermission("mmcforce.reload")){
            ForceSideConfig.reload();
        }else{
            player.sendMessage(ChatColor.RED + "The force is not with you.");
        }

        return true;
    }
}
