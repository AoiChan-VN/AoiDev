package aoichan.crystal.gameplay.gem;

import aoichan.crystal.infrastructure.pdc.PDCKeys;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class GemItemBuilder {

    // [!] Code: Build gem item
    public static ItemStack build(
            String id,
            int level,
            ConfigurationSection gem
    ) {

        ItemStack item = new ItemStack(Material.AMETHYST_SHARD);

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(
                gem.getString("name") + " §7+" + level
        );

        meta.setLore(
                GemLoreRenderer.render(gem, level)
        );

        // [!] Code: Save gem id
        meta.getPersistentDataContainer().set(
                PDCKeys.GEM_ID,
                PersistentDataType.STRING,
                id
        );

        // [!] Code: Save gem level
        meta.getPersistentDataContainer().set(
                PDCKeys.GEM_LEVEL,
                PersistentDataType.INTEGER,
                level
        );

        item.setItemMeta(meta);

        return item;
    }
} 
