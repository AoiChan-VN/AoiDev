package aoichan.crystal.platform.gui.forge;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

// [!] Code: Forge GUI listener
public class ForgeListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        if (!(e.getWhoClicked() instanceof Player player))
            return;

        if (!e.getView().getTitle()
                .equals("Luyện Khí Phường"))
            return;

        if (ForgeProcess.isLocked(player)) {

            e.setCancelled(true);
            return;
        }

        int slot = e.getRawSlot();

        if (slot != ForgeGUI.FORGE_BUTTON)
            return;

        e.setCancelled(true);

        Inventory inv =
                e.getInventory();

        ForgeProcess.start(player, inv);
    }

}
