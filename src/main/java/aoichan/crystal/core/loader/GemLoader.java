package aoichan.crystal.core.loader;

import aoichan.crystal.api.gem.GemDefinition;
import aoichan.crystal.bootstrap.CrystalPlugin;
import aoichan.crystal.core.registry.GemRegistry;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.*;

public class GemLoader {

    private final CrystalPlugin plugin;
    private final GemRegistry registry;

    public GemLoader(CrystalPlugin plugin, GemRegistry registry) {
        this.plugin = plugin;
        this.registry = registry;
    }

    // [!] Code: Load gems.yml
    public void load() {

        File file = new File(plugin.getDataFolder(), "gems.yml");

        if (!file.exists()) {
            plugin.saveResource("gems.yml", false);
        }

        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);

        registry.clear();

        for (String id : yaml.getKeys(false)) {

            ConfigurationSection section = yaml.getConfigurationSection(id);
            if (section == null) continue;

            String name = section.getString("name");
            String rarity = section.getString("rarity");
            String element = section.getString("element");
            int tier = section.getInt("tier");
            double successRate = section.getDouble("success-rate");

            Map<String, Double> stats = new HashMap<>();
            ConfigurationSection statsSec = section.getConfigurationSection("stats");

            if (statsSec != null) {
                for (String stat : statsSec.getKeys(false)) {
                    stats.put(stat, statsSec.getDouble(stat));
                }
            }

            List<String> effects = section.getStringList("effects");
            List<String> lore = section.getStringList("lore");

            GemDefinition gem = new GemDefinition(
                    id,
                    name,
                    rarity,
                    element,
                    tier,
                    successRate,
                    stats,
                    effects,
                    lore
            );

            registry.register(gem);
        }

        plugin.getLogger().info("Loaded " + registry.getAll().size() + " gems.");
    }
} 
