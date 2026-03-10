package aoichan.crystal.gameplay.gem;

import aoichan.crystal.bootstrap.CrystalPlugin;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GemRegistry {

    private static final Map<String, ConfigurationSection> gems =
            new HashMap<>();

    // [!] Code: Load gems from YAML
    public static void load() {

        gems.clear();

        ConfigurationSection section =
                CrystalPlugin.get()
                        .getConfig()
                        .getConfigurationSection("gems");

        if (section == null) return;

        Set<String> keys = section.getKeys(false);

        for (String key : keys) {

            gems.put(key, section.getConfigurationSection(key));
        }
    }

    // [!] Code: Get gem config
    public static ConfigurationSection get(String id) {

        return gems.get(id);
    }

} 
