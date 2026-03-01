package aoichan.crystal.core;

import aoichan.crystal.AoiMain;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.util.*;

public class GemsManager {

    private final Map<String, Map<String, Object>> gems = new HashMap<>();

    public GemsManager(AoiMain plugin) {
        File file = new File(plugin.getDataFolder(), "gems.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        for (String key : config.getConfigurationSection("gems").getKeys(false)) {
            gems.put(key, config.getConfigurationSection("gems." + key).getValues(false));
        }
    }

    public Map<String, Object> getGem(String id) {
        return gems.get(id);
    }

    public Set<String> getAllGems() {
        return gems.keySet();
    }
}
