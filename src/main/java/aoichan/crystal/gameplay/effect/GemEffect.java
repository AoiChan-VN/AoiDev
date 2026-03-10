package aoichan.crystal.gameplay.effect;

// [!] Code: Gem effect object
public class GemEffect {

    private final EffectType type;
    private final double chance;
    private final double power;

    public GemEffect(
            EffectType type,
            double chance,
            double power
    ) {

        this.type = type;
        this.chance = chance;
        this.power = power;
    }

    public EffectType getType() {
        return type;
    }

    public double getChance() {
        return chance;
    }

    public double getPower() {
        return power;
    }
} 
