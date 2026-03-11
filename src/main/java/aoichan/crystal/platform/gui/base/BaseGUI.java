package aoichan.crystal.platform.gui.base;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.entity.Player;

// [!] Code: Base GUI class
public abstract class BaseGUI {

    protected Inventory inventory;

    public void open(Player player) {
        player.openInventory(inventory);
    }

    protected Inventory create(

            int size,
            String title

    ) {

        inventory =
                Bukkit.createInventory(
                        null,
                        size,
                        title
                );

        return inventory;
    }

} 
