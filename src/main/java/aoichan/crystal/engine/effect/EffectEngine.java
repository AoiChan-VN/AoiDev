package aoichan.crystal.engine.effect;

import aoichan.crystal.api.effect.Effect;
import aoichan.crystal.api.effect.TriggerType;
import aoichan.crystal.core.registry.EffectRegistry;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.Random;

public class EffectEngine {

    // [!] Code: Effect registry
    private final EffectRegistry registry;

    private final Random random = new Random();

    public EffectEngine(EffectRegistry registry) {
        this.registry = registry;
    }

    // [!] Code: Trigger effects
    public void trigger(TriggerType type, Player player, LivingEntity target) {

        for (Effect effect : registry.getAll()) {

            if (effect.trigger() != type) continue;

            double roll = random.nextDouble() * 100;

            if (roll <= effect.chance()) {

                effect.execute(player, target);
            }
        }
    }
}
