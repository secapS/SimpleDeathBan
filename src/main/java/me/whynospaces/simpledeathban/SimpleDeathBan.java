package me.whynospaces.simpledeathban;

import co.aikar.commands.ACF;
import co.aikar.commands.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleDeathBan extends JavaPlugin {

    private CommandManager commandManager;
    private DeathBanManager deathBanManager;

    @Override
    public void onEnable() {
        commandManager = ACF.createManager(this);
        deathBanManager = new DeathBanManager(this);
    }

    @Override
    public void onDisable() {

    }

}
