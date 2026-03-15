package com.aoi.crystalengine.data;

import java.util.HashMap;
import java.util.Map;

/*
#【!】Code:
Data cache cho engine
*/

public class DataRegistry {

    private final Map<String, Object> data = new HashMap<>();

    public void put(String key, Object value) {

        data.put(key, value);
    }

    public Object get(String key) {

        return data.get(key);
    }

} 
