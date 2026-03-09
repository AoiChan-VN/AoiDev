package aoichan.crystal.api.stat;

import java.util.EnumMap;
import java.util.Map;

public class PlayerStats {

    // [!] Code: Stat storage
    private final Map<StatType, Double> stats = new EnumMap<>(StatType.class);

    public PlayerStats() {

        for (StatType type : StatType.values()) {
            stats.put(type, 0.0);
        }
    }

    // [!] Code: Add stat
    public void add(StatType type, double value) {

        stats.put(type, stats.get(type) + value);
    }

    // [!] Code: Get stat
    public double get(StatType type) {

        return stats.getOrDefault(type, 0.0);
    }

    // [!] Code: Reset stats
    public void reset() {

        for (StatType type : StatType.values()) {
            stats.put(type, 0.0);
        }
    }
} 
