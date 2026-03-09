package aoichan.crystal.infrastructure.cache;

import aoichan.crystal.api.stat.PlayerStats;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerStatCache {

    // [!] Code: Cached stats
    private final Map<UUID, PlayerStats> cache = new HashMap<>();

    // [!] Code: Get stats
    public PlayerStats get(Player player) {

        return cache.get(player.getUniqueId());
    }

    // [!] Code: Set stats
    public void set(Player player, PlayerStats stats) {

        cache.put(player.getUniqueId(), stats);
    }

    // [!] Code: Remove player
    public void remove(Player player) {

        cache.remove(player.getUniqueId());
    }
}
