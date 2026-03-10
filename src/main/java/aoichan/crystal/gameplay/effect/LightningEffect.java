package aoichan.crystal.gameplay.effect;

import aoichan.crystal.api.effect.Effect;
import aoichan.crystal.api.effect.TriggerType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class LightningEffect implements Effect {

    // [!] Code: Effect ID
    @Override
    public String id() {
        return "LIGHTNING";
    }

    // [!] Code: Trigger
    @Override
    public TriggerType trigger() {
        return TriggerType.ON_ATTACK;
    }

    // [!] Code: Chance %
    @Override
    public double chance() {
        return 20;
    }

    // [!] Code: Execute effect
    @Override
    public void execute(Player player, LivingEntity target) {

        target.getWorld().strikeLightning(target.getLocation());
    }
} 
