package aoichan.crystal.infrastructure.util;

import aoichan.crystal.bootstrap.CrystalPlugin;

public class LogUtil {

    public static void info(String message) {

        CrystalPlugin.get().getLogger().info(message);

    }

    public static void warn(String message) {

        CrystalPlugin.get().getLogger().warning(message);

    }

}
