package aoichan.crystal.gui;

import aoichan.crystal.AoiMain;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class GemsGUI {

    public static Inventory create() {
        Inventory inv = Bukkit.createInventory(null, 27, "§8Gems Ultimate");

        AoiMain.get().getAPI().getAllGems().forEach(id -> {
            inv.addItem(AoiMain.get().getAPI().createGemItem(id));
        });

        return inv;
    }
}
