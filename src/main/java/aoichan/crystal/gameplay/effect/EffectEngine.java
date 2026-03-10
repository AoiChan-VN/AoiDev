package aoichan.crystal.gameplay.effect;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class EffectEngine {

    private static final Random random = new Random();

    // [!] Code: Trigger effect
    public static void trigger(
            Player player,
            LivingEntity target,
            GemEffect effect
    ) {

        if (random.nextDouble() > effect.getChance())
            return;

        switch (effect.getType()) {

            case LIGHTNING ->

                    target.getWorld().strikeLightning(
                            target.getLocation()
                    );

            case BURN ->

                    target.setFireTicks(
                            (int) effect.getPower() * 20
                    );

            case SLOW ->

                    target.addPotionEffect(
                            new PotionEffect(
                                    PotionEffectType.SLOW,
                                    60,
                                    (int) effect.getPower()
                            )
                    );

            case LIFESTEAL -> {

                double heal =
                        player.getHealth() + effect.getPower();

                player.setHealth(
                        Math.min(
                                heal,
                                player.getMaxHealth()
                        )
                );
            }

            case HOLY_HEAL ->

                    player.addPotionEffect(
                            new PotionEffect(
                                    PotionEffectType.REGENERATION,
                                    60,
                                    (int) effect.getPower()
                            )
                    );
        }
    }
} 
