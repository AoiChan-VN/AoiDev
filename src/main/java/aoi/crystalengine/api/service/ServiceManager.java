package com.aoi.crystalengine.api.service;

import java.util.HashMap;
import java.util.Map;

/*
#【!】Code:
Service Manager giúp các plugin đăng ký hệ thống của mình.
Ví dụ:
CrystalStats register StatsService
CrystalSkill register SkillService
*/

public class ServiceManager {

    private Map<Class<?>, Object> services = new HashMap<>();

    public <T> void registerService(Class<T> clazz, T service) {

        services.put(clazz, service);
    }

    public <T> T getService(Class<T> clazz) {

        return clazz.cast(services.get(clazz));
    }

} 
