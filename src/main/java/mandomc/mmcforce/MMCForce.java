package mandomc.mmcforce;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class MMCForce extends JavaPlugin {

    private File dataConfigFile;
    private FileConfiguration dataConfig;

    @Override
    public void onEnable() {

        createDataConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public FileConfiguration getDataConfig() {
        return this.dataConfig;
    }

    private void createDataConfig() {
        dataConfigFile = new File(getDataFolder(), "data.yml");
        if (!dataConfigFile.exists()) {
            dataConfigFile.getParentFile().mkdirs();
            saveResource("data.yml", false);
        }

        dataConfig = new YamlConfiguration();
        try {
            dataConfig.load(dataConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
