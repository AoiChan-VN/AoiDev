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

    // MUST call in onEnable(): PDCUtil.init(plugin)
    public static void init(Plugin plugin) {
        if (KEY == null) KEY = new NamespacedKey(plugin, "gems");
    }

    private static void ensureInit() {
        if (KEY == null) throw new IllegalStateException("PDCUtil not initialized. Call PDCUtil.init(plugin) in onEnable.");
    }

    public static List<String> getSocketList(ItemStack item) {
        ensureInit();
        if (item == null || !item.hasItemMeta()) return new ArrayList<>();
        ItemMeta meta = item.getItemMeta();
        String raw = meta.getPersistentDataContainer().get(KEY, PersistentDataType.STRING);
        if (raw == null || raw.isEmpty()) return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(raw.split(",")));
    }

    public static void setSocketList(ItemStack item, List<String> list) {
        ensureInit();
        if (item == null) return;
        if (!item.hasItemMeta()) return;
        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(KEY, PersistentDataType.STRING, String.join(",", list));
        item.setItemMeta(meta);
    }

    // Convenience: check whether an ItemStack has any gem sockets/tags
    public static boolean hasGemTag(ItemStack item) {
        ensureInit();
        if (item == null || !item.hasItemMeta()) return false;
        ItemMeta meta = item.getItemMeta();
        String raw = meta.getPersistentDataContainer().get(KEY, PersistentDataType.STRING);
        return raw != null && !raw.isEmpty();
    }

    // Optional: clear socket list
    public static void clearSocketList(ItemStack item) {
        ensureInit();
        if (item == null || !item.hasItemMeta()) return;
        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().remove(KEY);
        item.setItemMeta(meta);
    }
}
