package aoichan.crystal.core;

import aoichan.crystal.utils.PDCUtil;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;

/**
 * Advanced anti-duplication protection.
 *
 * - Blocks risky inventory actions for items that have gem PDC tags.
 * - Uses PDCUtil.hasGemTag(...) (safe; throws IllegalStateException if PDCUtil not initialized).
 * - Accepts a SocketManager so future logic can inspect allowed behaviour per-socket.
 */
public class AntiDupeManager implements Listener {

    private final SocketManager socketManager;

    /**
     * Construct AntiDupeManager with the SocketManager instance.
     * @param socketManager SocketManager (can be null but it's recommended)
     */
    public AntiDupeManager(SocketManager socketManager) {
        this.socketManager = socketManager;
    }

    @EventHandler(ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent e) {

        ItemStack current = e.getCurrentItem();
        if (current == null) return;

        // Quick guard: don't block ops in creative if desired — but still check
        if (e.getWhoClicked() instanceof Player p && p.getGameMode() == GameMode.CREATIVE) {
            // In creative mode players can duplicate items by default,
            // but we still optionally prevent certain actions for gemged items.
        }

        boolean hasGem;
        try {
            hasGem = PDCUtil.hasGemTag(current);
        } catch (IllegalStateException ex) {
            // PDCUtil not initialized: warn admin via player (non-fatal) and skip anti-dupe to avoid crash.
            if (e.getWhoClicked() instanceof Player player) {
                player.sendMessage("§c[Warning] Gems anti-dupe limited: PDC util not initialized.");
            }
            return;
        }

        if (!hasGem) return;

        InventoryAction action = e.getAction();

        // block common duplication actions:
        boolean isDupRisk = e.getClick().isShiftClick()
                || action == InventoryAction.COLLECT_TO_CURSOR
                || action == InventoryAction.PLACE_ALL
                || action == InventoryAction.PLACE_ONE
                || action == InventoryAction.PLACE_SOME;

        if (isDupRisk) {
            e.setCancelled(true);
            return;
        }

        // Additional check: if player is moving item to cursor via creative pickup
        if (action == InventoryAction.PICKUP_ALL || action == InventoryAction.PICKUP_ONE || action == InventoryAction.PICKUP_SOME) {
            // Optionally block some pickup actions if we detect duplication patterns
            // (for now, more conservative: allow pickup but prevent shift & collect)
            return;
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onInventoryDrag(InventoryDragEvent e) {
        // If a dragged slot involves a gem item, cancel to avoid duplication via drag tricks
        for (int slot : e.getRawSlots()) {
            ItemStack item = e.getOldCursor();
            if (item == null) continue;

            boolean hasGem;
            try {
                hasGem = PDCUtil.hasGemTag(item);
            } catch (IllegalStateException ex) {
                return;
            }

            if (hasGem) {
                e.setCancelled(true);
                return;
            }
        }
    }
}
