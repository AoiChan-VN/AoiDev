package com.aoi.crystalengine.module;

import java.util.HashMap;
import java.util.Map;

/*
#【!】Code:
Quản lý toàn bộ modules
*/

public class ModuleManager {

    private final Map<String, EngineModule> modules = new HashMap<>();

    public void register(EngineModule module) {

        modules.put(module.getName(), module);
        module.enable();
    }

    public EngineModule get(String name) {

        return modules.get(name);
    }

} 
