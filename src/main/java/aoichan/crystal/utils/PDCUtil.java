package aoichan.crystal.utils;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PDCUtil {

    private static NamespacedKey KEY;

    public static void init(Plugin plugin) {
        if (KEY == null) KEY = new NamespacedKey(plugin, "gems");
    }

    public static List<String> getSocketList(ItemStack item) {
        if (KEY == null) throw new IllegalStateException("PDCUtil not initialized. Call PDCUtil.init(plugin) in onEnable.");

        if (item == null || !item.hasItemMeta()) return new ArrayList<>();
        ItemMeta meta = item.getItemMeta();
        String raw = meta.getPersistentDataContainer().get(KEY, PersistentDataType.STRING);
        if (raw == null || raw.isEmpty()) return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(raw.split(",")));
    }

    public static void setSocketList(ItemStack item, List<String> list) {
        if (KEY == null) throw new IllegalStateException("PDCUtil not initialized. Call PDCUtil.init(plugin) in onEnable.");

        if (item == null) return;
        if (!item.hasItemMeta()) return;
        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(KEY, PersistentDataType.STRING, String.join(",", list));
        item.setItemMeta(meta);
    }
}
