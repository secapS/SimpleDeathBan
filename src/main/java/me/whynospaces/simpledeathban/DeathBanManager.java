package me.whynospaces.simpledeathban;

import lombok.Getter;
import org.apache.commons.lang.Validate;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class DeathBanManager {

    private JavaPlugin plugin;
    @Getter
    private Map<UUID, Long> deathbans = Collections.emptyMap();

    public DeathBanManager(JavaPlugin instance) {
        this.plugin = instance;
        deathbans = new HashMap<>();
        loadDeathBans();
    }

    public void loadDeathBans() {
        Validate.notEmpty(this.plugin.getConfig().getStringList("banned-players"), "There are no banned players.");
        for(String bannedUUIDs : this.plugin.getConfig().getStringList("banned-players")) {
            String[] split = bannedUUIDs.split(":");
            UUID player = UUID.fromString(split[0]);
            Long unbanTime = Long.parseLong(split[1]);
            deathbans.put(player, unbanTime);
        }
    }

    public boolean checkDeathBan(Player player) {
        return System.currentTimeMillis() >= deathbans.get(player.getUniqueId());
    }

    public void addDeathBan(Player player) {
        Validate.notNull(player, "Player cannot be null.");
        Validate.isTrue(deathbans.containsKey(player.getUniqueId()), "Player is already death banned.");
        deathbans.put(player.getUniqueId(), System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(this.plugin.getConfig().getLong("ban-time")));
    }

    public void removeDeathBan(Player player) {
        Validate.notNull(player, "Player cannot be null.");
        Validate.isTrue(deathbans.containsKey(player.getUniqueId()), "Player is not death banned.");
        deathbans.remove(player.getUniqueId());
        this.plugin.getConfig().set("banned-players." + player.getUniqueId().toString(), null);
    }

    public void deleteAllDeathbans(boolean cacheOnly) {
        if(!cacheOnly) this.plugin.getConfig().set("banned-players", null);
        deathbans = Collections.emptyMap();
    }
}
