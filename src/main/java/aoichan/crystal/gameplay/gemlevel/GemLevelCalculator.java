package aoichan.crystal.gameplay.gemlevel;

// [!] Code: Gem level scaling calculator
public class GemLevelCalculator {

    public static GemLevelData calculate(int level) {

        if (level <= 1)
            return new GemLevelData(1, 1.0, 1.0);

        double statMultiplier =
                1 + (level * 0.15);

        double effectMultiplier =
                1 + (level * 0.10);

        return new GemLevelData(
                level,
                statMultiplier,
                effectMultiplier
        );
    }

} 
