package aoichan.crystal.core;

import org.bukkit.plugin.Plugin;

public class ConsoleBanner {

    public static void show(Plugin plugin) {

        plugin.getLogger().info("====================================");
        plugin.getLogger().info("   Gems Ultimate Production Mode   ");
        plugin.getLogger().info("   Version: " + plugin.getDescription().getVersion());
        plugin.getLogger().info("   Author: AoiDev");
        plugin.getLogger().info("====================================");
    }
}
