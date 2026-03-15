package com.aoi.crystalengine.player;

import java.util.UUID;

/*
#【!】Code:
Wrapper Player data
Sau này Stats / Skills / Cultivation đều attach vào đây
*/

public class CrystalPlayer {

    private UUID uuid;

    public CrystalPlayer(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUUID() {
        return uuid;
    }

} 
