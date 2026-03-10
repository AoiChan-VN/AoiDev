package aoichan.crystal.gameplay.gem;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

public class GemFactory {

    // [!] Code: Create gem
    public static ItemStack create(String id, int level) {

        ConfigurationSection gem =
                GemRegistry.get(id);

        if (gem == null) return null;

        return GemItemBuilder.build(
                id,
                level,
                gem
        );
    }
} 
