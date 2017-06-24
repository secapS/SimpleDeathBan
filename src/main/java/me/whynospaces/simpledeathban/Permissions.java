package me.whynospaces.simpledeathban;

import lombok.Getter;
import org.bukkit.entity.Player;

public enum Permissions {

    DEATHBAN_ADMIN("deathban.admin"),
    DEATHBAN_BYPASS("deathban.bypass");

    @Getter
    private String permission;

    Permissions(String permission) {
        this.permission = permission;
    }

    public boolean has(Player player) {
        return player.hasPermission(permission);
    }
}
