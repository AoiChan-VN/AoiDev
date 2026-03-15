package com.aoi.crystalengine.packet;

import org.bukkit.Bukkit;

/*
#【!】Code:
Bridge để hook packet nếu server có ProtocolLib.
*/

public class PacketBridge {

    public boolean isProtocolLibPresent() {

        return Bukkit.getPluginManager()
            .getPlugin("ProtocolLib") != null;
    }

} 
