package mandomc.mmcforce;

import mandomc.mmcforce.commands.Force;
import mandomc.mmcforce.commands.ForceSide;
import mandomc.mmcforce.commands.Reload;
import mandomc.mmcforce.configs.ForceSideConfig;
import mandomc.mmcforce.listeners.InventoryClick;
import mandomc.mmcforce.listeners.PlayerJoin;
import mandomc.mmcforce.listeners.forcepowers.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class MMCForce extends JavaPlugin {

    public static final HashMap<UUID, Long> cooldown = new HashMap<>();

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        ForceSideConfig.setup();
        ForceSideConfig.get().options().copyDefaults(true);
        ForceSideConfig.save();

        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);

        getServer().getPluginManager().registerEvents(new Choke(), this);
        getServer().getPluginManager().registerEvents(new Crush(), this);
        getServer().getPluginManager().registerEvents(new Dash(), this);
        getServer().getPluginManager().registerEvents(new Drain(), this);
        getServer().getPluginManager().registerEvents(new Heal(), this);
        getServer().getPluginManager().registerEvents(new Lightning(), this);
        getServer().getPluginManager().registerEvents(new Scream(), this);
        getServer().getPluginManager().registerEvents(new Slow(), this);
        getServer().getPluginManager().registerEvents(new Telekinesis(), this);


        getCommand("force").setExecutor(new Force());
        getCommand("reload").setExecutor(new Reload());
        getCommand("forceside").setExecutor(new ForceSide());

    }

    @Override
    public void onDisable() {
        ForceSideConfig.save();
    }

}
