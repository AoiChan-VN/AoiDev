package aoichan.crystal.infrastructure.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {

    private static FileConfiguration config;

    public static void load(JavaPlugin plugin) {

        // 【!】Code: tạo config mặc định
        plugin.saveDefaultConfig();

        config = plugin.getConfig();

    }

    public static void reload(JavaPlugin plugin) {

        // 【!】Code: reload config runtime
        plugin.reloadConfig();

        config = plugin.getConfig();

    }

    public static FileConfiguration get() {
        return config;
    }

}
