package aoichan.crystal.gameplay.drop;

import aoichan.crystal.bootstrap.CrystalPlugin;
import aoichan.crystal.gameplay.gem.GemFactory;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class GemDropManager {

    private static final Map<EntityType, List<DropTable>> drops =
            new HashMap<>();

    private static final Random random = new Random();

    // [!] Code: Load drop tables
    public static void load() {

        drops.clear();

        ConfigurationSection section =
                CrystalPlugin.get().getConfig()
                        .getConfigurationSection("mob-drops");

        if (section == null) return;

        for (String mob : section.getKeys(false)) {

            EntityType type = EntityType.valueOf(mob);

            List<DropTable> list = new ArrayList<>();

            for (String key : section
                    .getConfigurationSection(mob)
                    .getKeys(false)) {

                ConfigurationSection entry =
                        section.getConfigurationSection(mob + "." + key);

                String gem = entry.getString("gem");
                int level = entry.getInt("level");
                double chance = entry.getDouble("chance");

                list.add(new DropTable(gem, level, chance));
            }

            drops.put(type, list);
        }
    }

    // [!] Code: Roll drop
    public static ItemStack roll(EntityType type) {

        List<DropTable> table = drops.get(type);

        if (table == null) return null;

        for (DropTable entry : table) {

            if (random.nextDouble() <= entry.getChance()) {

                return GemFactory.create(
                        entry.getGemId(),
                        entry.getLevel()
                );
            }
        }

        return null;
    }
} 
