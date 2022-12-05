package mandomc.mmcforce.commands;

import mandomc.mmcforce.configs.ForceSideConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Force implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(ForceSideConfig.get().getString(player.getUniqueId().toString()) != null){
                player.sendMessage(ForceSideConfig.get().getString(player.getUniqueId().toString()));
            }else{
                player.sendMessage("what happenduhh");
            }

        }

        return true;
    }
}
