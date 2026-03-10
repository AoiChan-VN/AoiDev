package aoichan.crystal.gameplay.stat;

import aoichan.crystal.bootstrap.CrystalPlugin;
import aoichan.crystal.gameplay.socket.GemData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;

public class StatUpdateService {

    // [!] Code: Recalculate stats
    public static void update(Player player) {

        Bukkit.getScheduler().runTaskAsynchronously(
                CrystalPlugin.get(),
                () -> {

                    List<GemData> gems =
                            EquipmentScanner.scan(player);

                    Map<String,Integer> stats =
                            StatEngine.collect(gems);

                    PlayerStatCache.set(player, stats);
                }
        );
    }
} 
