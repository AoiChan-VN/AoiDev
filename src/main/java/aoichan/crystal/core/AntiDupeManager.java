package aoichan.crystal.core;

import aoichan.crystal.utils.PDCUtil;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;

public class AntiDupeManager implements Listener {

    private final SocketManager socketManager;

    public AntiDupeManager(SocketManager socketManager) {
        this.socketManager = socketManager;
    }

    @EventHandler(ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent e) {

        ItemStack current = e.getCurrentItem();
        if (current == null) return;

        boolean hasGem;
        try {
            hasGem = PDCUtil.hasGemTag(current);
        } catch (IllegalStateException ex) {
            if (e.getWhoClicked() instanceof Player player) {
                player.sendMessage("§c[Warning] PDCUtil not initialized; anti-dupe limited.");
            }
            return;
        }

        if (!hasGem) return;

        InventoryAction action = e.getAction();

        boolean isDupRisk = e.getClick().isShiftClick()
                || action == InventoryAction.COLLECT_TO_CURSOR
                || action == InventoryAction.PLACE_ALL
                || action == InventoryAction.PLACE_ONE
                || action == InventoryAction.PLACE_SOME;

        if (isDupRisk) {
            e.setCancelled(true);
            return;
        }

        // allow safe pickups
    }

    @EventHandler(ignoreCancelled = true)
    public void onInventoryDrag(InventoryDragEvent e) {
        ItemStack cursor = e.getOldCursor();
        if (cursor == null) return;

        boolean hasGem;
        try {
            hasGem = PDCUtil.hasGemTag(cursor);
        } catch (IllegalStateException ex) {
            return;
        }
        if (hasGem) e.setCancelled(true);
    }
    }
