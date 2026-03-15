package com.aoi.crystalengine;

import org.bukkit.plugin.java.JavaPlugin;

import com.aoi.crystalengine.player.PlayerManager;
import com.aoi.crystalengine.storage.DataStorage;
import com.aoi.crystalengine.api.service.ServiceManager;
import com.aoi.crystalengine.util.Log;

/*
#【!】Code:
Main plugin class.
Đây là lõi khởi động của toàn bộ hệ thống Crystal.
Các plugin khác sẽ hook vào Engine thông qua API.
*/

public class CrystalEngine extends JavaPlugin {

    private static CrystalEngine instance;

    private PlayerManager playerManager;
    private DataStorage dataStorage;
    private ServiceManager serviceManager;

    @Override
    public void onEnable() {

        instance = this;

        Log.info("Booting CrystalEngine...");

        // init systems
        serviceManager = new ServiceManager();
        dataStorage = new DataStorage();
        playerManager = new PlayerManager();

        Log.success("CrystalEngine enabled successfully.");
    }

    @Override
    public void onDisable() {

        Log.info("CrystalEngine shutting down...");
    }

    public static CrystalEngine get() {
        return instance;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public DataStorage getDataStorage() {
        return dataStorage;
    }

    public ServiceManager getServiceManager() {
        return serviceManager;
    }
}

