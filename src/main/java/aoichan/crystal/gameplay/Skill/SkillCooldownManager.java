package aoichan.crystal.gameplay.skill;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SkillCooldownManager {

    private static final Map<UUID, Map<String, Long>> cooldowns = new HashMap<>();

    public static boolean isCooldown(Player player, String skillId) {

        Map<String, Long> map = cooldowns.get(player.getUniqueId());

        if (map == null) return false;

        Long time = map.get(skillId);

        if (time == null) return false;

        return System.currentTimeMillis() < time;

    }

    public static void setCooldown(Player player, String skillId, int seconds) {

        Map<String, Long> map = cooldowns.computeIfAbsent(
                player.getUniqueId(),
                k -> new HashMap<>()
        );

        long expire = System.currentTimeMillis() + (seconds * 1000L);

        map.put(skillId, expire);

    }

}
 
