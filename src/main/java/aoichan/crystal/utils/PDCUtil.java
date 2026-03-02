package aoichan.crystal.utils;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PDCUtil {

    private static NamespacedKey KEY;
    private static Plugin plugin;

    // MUST call in onEnable(): PDCUtil.init(plugin);
    public static void init(Plugin pl) {
        plugin = pl;
        if (KEY == null) {
            KEY = new NamespacedKey(pl, "gems");
        }
    }

    private static void ensureInit() {
        if (plugin == null) {
            throw new IllegalStateException("PDCUtil not initialized. Call PDCUtil.init(plugin) in onEnable.");
        }
    }

    // =========================================================
    //                    SOCKET LIST SYSTEM
    // =========================================================

    public static List<String> getSocketList(ItemStack item) {
        ensureInit();
        if (item == null || !item.hasItemMeta()) return new ArrayList<>();

        ItemMeta meta = item.getItemMeta();
        String raw = meta.getPersistentDataContainer()
                .get(KEY, PersistentDataType.STRING);

        if (raw == null || raw.isEmpty()) return new ArrayList<>();

        return new ArrayList<>(Arrays.asList(raw.split(";")));
    }

    public static void setSocketList(ItemStack item, List<String> list) {
        ensureInit();
        if (item == null || !item.hasItemMeta()) return;

        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer()
                .set(KEY, PersistentDataType.STRING, String.join(";", list));
        item.setItemMeta(meta);
    }

    public static boolean hasGemTag(ItemStack item) {
        ensureInit();
        if (item == null || !item.hasItemMeta()) return false;

        ItemMeta meta = item.getItemMeta();
        String raw = meta.getPersistentDataContainer()
                .get(KEY, PersistentDataType.STRING);

        return raw != null && !raw.isEmpty();
    }

    public static void clearSocketList(ItemStack item) {
        ensureInit();
        if (item == null || !item.hasItemMeta()) return;

        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().remove(KEY);
        item.setItemMeta(meta);
    }

    // =========================================================
    // GENERIC SUB-KEY SYSTEM (Refine / Protection / Future)
    // =========================================================

    private static NamespacedKey subKey(String name) {
        ensureInit();
        return new NamespacedKey(plugin, name);
    }

    // SET INT
    public static void setInt(ItemStack item, String key, int value) {
        ensureInit();
        if (item == null || !item.hasItemMeta()) return;

        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer()
                .set(subKey(key), PersistentDataType.INTEGER, value);
        item.setItemMeta(meta);
    }

    // GET INT
    public static int getInt(ItemStack item, String key) {
        ensureInit();
        if (item == null || !item.hasItemMeta()) return 0;

        ItemMeta meta = item.getItemMeta();
        Integer value = meta.getPersistentDataContainer()
                .get(subKey(key), PersistentDataType.INTEGER);

        return value == null ? 0 : value;
    }

    // HAS INT KEY
    public static boolean hasKey(ItemStack item, String key) {
        ensureInit();
        if (item == null || !item.hasItemMeta()) return false;

        ItemMeta meta = item.getItemMeta();
        return meta.getPersistentDataContainer()
                .has(subKey(key), PersistentDataType.INTEGER);
    }

    // REMOVE KEY
    public static void removeKey(ItemStack item, String key) {
        ensureInit();
        if (item == null || !item.hasItemMeta()) return;

        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer()
                .remove(subKey(key));
        item.setItemMeta(meta);
    }
}
