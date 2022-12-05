package mandomc.mmcforce;

import mandomc.mmcforce.configs.ForceSideConfig;
import mandomc.mmcforce.listeners.InventoryClick;
import mandomc.mmcforce.listeners.PlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;

public final class MMCForce extends JavaPlugin {

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        ForceSideConfig.setup();
        ForceSideConfig.get().addDefault("Player Sides:", "VVV");
        ForceSideConfig.get().options().copyDefaults(true);
        ForceSideConfig.save();

        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);

    }

    @Override
    public void onDisable() {

    }

}
