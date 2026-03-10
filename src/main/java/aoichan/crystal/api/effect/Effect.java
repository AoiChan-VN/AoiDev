package aoichan.crystal.api.effect;

import org.bukkit.entity.Player;
import org.bukkit.entity.LivingEntity;

public interface Effect {

    // [!] Code: Effect ID
    String id();

    // [!] Code: Trigger type
    TriggerType trigger();

    // [!] Code: Chance %
    double chance();

    // [!] Code: Execute effect
    void execute(Player player, LivingEntity target);
} 
