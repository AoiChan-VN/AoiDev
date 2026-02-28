package aoichan.crystal;

import aoichan.crystal.bootstrap.ConsoleBanner;
import aoichan.crystal.gem.GemManager;
import aoichan.crystal.gem.GemRegistry;
import aoichan.crystal.hook.PlaceholderHook;
import aoichan.crystal.hook.VaultHook;
import aoichan.crystal.storage.HikariProvider;
import aoichan.crystal.storage.SQLiteStorage;
import aoichan.crystal.storage.StorageAdapter;
import aoichan.crystal.ui.UISystem;
import aoichan.crystal.security.AntiDuper;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Main extends JavaPlugin {

    private StorageAdapter storage;
    private HikariProvider hikari;
    private ExecutorService dbExecutor;

    private GemManager gemManager;
    private GemRegistry registry;
    private VaultHook vaultHook;

    @Override
    public void onEnable() {

        saveDefaultConfig();
        getDataFolder().mkdirs();

        // Dedicated DB thread pool
        dbExecutor = Executors.newFixedThreadPool(4);

        // Hikari
        hikari = new HikariProvider(
                getDataFolder(),
                getConfig().getString("storage.sqlite-file", "gems.db")
        );

        storage = new SQLiteStorage(hikari.get(), dbExecutor);

        registry = new GemRegistry();
        gemManager = new GemManager(this, storage, dbExecutor);

        // Vault Hook
        if (getServer().getPluginManager().getPlugin("Vault") != null) {
            vaultHook = new VaultHook();
            if (vaultHook.hook()) {
                getLogger().info("Vault hooked successfully.");
            }
        }

        // PlaceholderAPI Hook
        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PlaceholderHook(gemManager).register();
            getLogger().info("PlaceholderAPI hooked successfully.");
        }

        // Load gems
        gemManager.loadAll();

        ConsoleBanner.print(this);
        getLogger().info("Gems Ultimate fully initialized.");
    }

    @Override
    public void onDisable() {

        if (storage != null) storage.shutdown();
        if (hikari != null) hikari.shutdown();
        if (dbExecutor != null) dbExecutor.shutdownNow();

        getLogger().info("Gems Ultimate shutdown complete.");
    }
} 
