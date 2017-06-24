package me.whynospaces.simpledeathban;

import co.aikar.commands.ACF;
import co.aikar.commands.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleDeathBan extends JavaPlugin {

    private CommandManager commandManager;

    @Override
    public void onEnable() {
        commandManager = ACF.createManager(this);
    }

    @Override
    public void onDisable() {

    }

}
