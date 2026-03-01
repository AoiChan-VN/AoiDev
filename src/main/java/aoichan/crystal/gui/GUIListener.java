package aoichan.crystal.gui;

import aoichan.crystal.AoiMain;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.entity.Player;

public class GUIListener implements Listener {

    private final AoiMain plugin;

    public GUIListener(AoiMain plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        InventoryView view = e.getView();
        if (view.getTitle().equals("§8Gems Ultimate")) {
            e.setCancelled(true);
            // handle future click logic (socketging, preview, etc)
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        // stop animations / cleanup if implemented
    }
}
