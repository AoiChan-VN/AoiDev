package aoichan.crystal.infrastructure.pdc;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class GemStorage {

    // [!] Code: Get gem JSON
    public static String get(ItemStack item) {

        ItemMeta meta = item.getItemMeta();

        if (meta == null) return "[]";

        String json =
                meta.getPersistentDataContainer()
                        .get(PDCKeys.GEMS,
                                PersistentDataType.STRING);

        return json == null ? "[]" : json;
    }

    // [!] Code: Set gem JSON
    public static void set(ItemStack item, String json) {

        ItemMeta meta = item.getItemMeta();

        meta.getPersistentDataContainer()
                .set(PDCKeys.GEMS,
                        PersistentDataType.STRING,
                        json);

        item.setItemMeta(meta);
    }
} 
