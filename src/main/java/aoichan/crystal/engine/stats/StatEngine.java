package aoichan.crystal.engine.stats;

import aoichan.crystal.api.gem.GemDefinition;
import aoichan.crystal.api.stat.PlayerStats;
import aoichan.crystal.infrastructure.cache.PlayerStatCache;
import org.bukkit.entity.Player;

import java.util.List;

public class StatEngine {

    // [!] Code: Player stat cache
    private final PlayerStatCache cache;

    public StatEngine(PlayerStatCache cache) {
        this.cache = cache;
    }

    // [!] Code: Recalculate stats
    public PlayerStats recalculate(Player player, List<GemDefinition> gems) {

        PlayerStats stats = new PlayerStats();

        for (GemDefinition gem : gems) {

            StatCalculator.applyGem(stats, gem);
        }

        cache.set(player, stats);

        return stats;
    }

    // [!] Code: Get cached stats
    public PlayerStats get(Player player) {

        return cache.get(player);
    }
} 
