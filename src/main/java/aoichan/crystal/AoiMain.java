package aoichan.crystal;

import aoichan.crystal.api.GemsAPI;
import aoichan.crystal.commands.GemsCommand;
import aoichan.crystal.core.*;
import aoichan.crystal.gui.GUIListener;
import aoichan.crystal.storage.*;

import org.bukkit.plugin.java.JavaPlugin;

public final class AoiMain extends JavaPlugin {

    private static AoiMain instance;

    private DatabasePool databasePool;
    private StorageProvider storage;
    private GemsManager gemsManager;
    private SocketManager socketManager;
    private GemsAPI api;

    public static AoiMain get() { return instance; }

    @Override
    public void onEnable() {

        instance = this;

        saveDefaultConfig();
        saveResource("gems.yml", false);

        if (getConfig().getBoolean("banner.enabled", true))
            ConsoleBanner.show(this);

        setupStorage();
        setupManagers();
        registerCommands();
        registerEvents();
    }

    private void setupStorage() {

        databasePool = new DatabasePool(this);

        String type = getConfig().getString("storage.type", "SQLITE");

        if (type.equalsIgnoreCase("MYSQL"))
            storage = new MySQLStorage(databasePool, this);
        else
            storage = new SQLiteStorage(databasePool);

        storage.initTables();
    }

    private void setupManagers() {
        gemsManager = new GemsManager(this);
        socketManager = new SocketManager(this);
        api = new GemsAPI(gemsManager, socketManager);
    }

    private void registerCommands() {
        if (getCommand("gems") != null)
            getCommand("gems").setExecutor(new GemsCommand(this));
    }

    private void registerEvents() {
        getServer().getPluginManager()
                .registerEvents(new AntiDupeManager(socketManager), this);
        getServer().getPluginManager()
                .registerEvents(new GUIListener(this), this);
    }

    public GemsManager getGemsManager() { return gemsManager; }
    public GemsAPI getAPI() { return api; }

    @Override
    public void onDisable() {
        if (databasePool != null) databasePool.shutdown();
    }
}
