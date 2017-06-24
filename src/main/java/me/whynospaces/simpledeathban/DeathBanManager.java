package me.whynospaces.simpledeathban;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class DeathBanManager {

    private JavaPlugin plugin;
    @Getter
    private Map<UUID, Date> deathbans;

    public DeathBanManager(JavaPlugin instance) {
        this.plugin = instance;
        deathbans = Collections.emptyMap();
    }

    public void loadDeathBans() {
        
    }
}
