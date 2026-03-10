package aoichan.crystal.platform.gui;

import aoichan.crystal.infrastructure.config.GUIConfig;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class GUIManager {

    private final GUIConfig config = new GUIConfig();

    // [!] Code: Create forge GUI
    public Inventory createForgeGUI() {

        return Bukkit.createInventory(
                null,
                config.size(),
                config.title()
        );
    }

    public GUIConfig getConfig() {
        return config;
    }
} 
