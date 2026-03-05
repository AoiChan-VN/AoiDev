package aoichan.crystal.core.language;

import aoichan.crystal.AoiMain;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

// [!] Code: Multi-Language System
public class LangManager {

    private final AoiMain plugin;
    private FileConfiguration languageFile;

    public LangManager(AoiMain plugin) {
        this.plugin = plugin;
    }

    public void loadLanguage() {

        String lang = plugin.getConfig().getString("language", "vi");

        File folder = new File(plugin.getDataFolder(), "languages");
        if (!folder.exists()) folder.mkdirs();

        File file = new File(folder, "language_" + lang + ".yml");

        if (!file.exists()) {
            plugin.saveResource("languages/language_" + lang + ".yml", false);
        }

        languageFile = YamlConfiguration.loadConfiguration(file);
    }

    public String get(String path) {
        if (languageFile == null) return "Language not loaded.";
        return languageFile.getString(path, path);
    }
} 
