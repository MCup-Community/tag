package mcup.gamemode.tag;

import mcup.core.Core;
import mcup.core.StageManager;
import mcup.core.stages.Waiting;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;

public final class Tag extends JavaPlugin {

    public Core core;

    public Storage storage;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Tag plugin started!");

        // Core API initialization
        core = (Core) Bukkit.getPluginManager().getPlugin("Core");

        if (core == null)
            this.getLogger().warning("This plugin require Core API plugin to function!");


        core.registerStageManager(
          new StageManager(core, this, new ArrayList<>(Arrays.asList(
            Waiting.class
          )))
        );

        saveDefaultConfig();
        storage = new Storage(this);

        core.stageManager.startSequence();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
