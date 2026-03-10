package aoichan.crystal.gameplay.gem;

import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

public class GemLoreRenderer {

    // [!] Code: Render gem lore
    public static List<String> render(
            ConfigurationSection gem,
            int level
    ) {

        List<String> lore = new ArrayList<>();

        lore.add("§8▬▬▬▬▬▬▬๑۩NGỌC۩๑▬▬▬▬▬▬▬");

        String name = gem.getString("name");

        lore.add("§d✦ " + name + " §7+" + level);

        lore.add("");

        ConfigurationSection stats =
                gem.getConfigurationSection(
                        "levels." + level
                );

        if (stats != null) {

            for (String stat : stats.getKeys(false)) {

                int value = stats.getInt(stat);

                lore.add("§7+" + value + " §c" + stat);
            }
        }

        lore.add("");

        lore.add("§8▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");

        return lore;
    }
} 
