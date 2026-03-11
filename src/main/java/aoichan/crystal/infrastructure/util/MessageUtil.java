package aoichan.crystal.infrastructure.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

// [!] Code: Message util
public class MessageUtil {

    public static void send(Player p, String msg) {

        p.sendMessage(
                "§7[Crystal] §f" + msg
        );

    }

    public static void broadcast(String msg) {

        Bukkit.broadcastMessage(
                "§6" + msg
        );

    }

}
