package aoichan.crystal.core;

import aoichan.crystal.AoiMain;
import aoichan.crystal.utils.PDCUtil;
import org.bukkit.inventory.ItemStack;

/**
 * Protection helper for refine system.
 * - uses PDCUtil sub-key API (hasKey / setInt / removeKey / getInt)
 * - safe null checks
 */
public class ProtectionManager {

    private final AoiMain plugin;

    public ProtectionManager(AoiMain plugin) {
        this.plugin = plugin;
    }

    /**
     * Check if an item has permanent protection flag.
     */
    public boolean isPermanentProtected(ItemStack item) {
        if (item == null) return false;
        return PDCUtil.hasKey(item, "permanent_protect");
    }

    /**
     * Consume a one-time protection (if present) and return true.
     */
    public boolean consumeProtection(ItemStack item) {
        if (item == null) return false;

        if (PDCUtil.hasKey(item, "protect_once")) {
            PDCUtil.removeKey(item, "protect_once");
            return true;
        }
        return false;
    }

    /**
     * Apply permanent protection to the item (persist until removed by code).
     */
    public void applyPermanent(ItemStack item) {
        if (item == null) return;
        PDCUtil.setInt(item, "permanent_protect", 1);
    }

    /**
     * Apply a single-use protection to the item (will be removed on use).
     */
    public void applyOnce(ItemStack item) {
        if (item == null) return;
        PDCUtil.setInt(item, "protect_once", 1);
    }
}
