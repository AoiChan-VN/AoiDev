package aoichan.crystal.gameplay.stat;

import aoichan.crystal.gameplay.socket.GemData;
import aoichan.crystal.gameplay.socket.SocketEngine;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class EquipmentScanner {

    // [!] Code: Scan player equipment
    public static List<GemData> scan(Player player) {

        List<GemData> gems = new ArrayList<>();

        ItemStack[] items = {

                player.getInventory().getItemInMainHand(),
                player.getInventory().getHelmet(),
                player.getInventory().getChestplate(),
                player.getInventory().getLeggings(),
                player.getInventory().getBoots()

        };

        for (ItemStack item : items) {

            if (item == null) continue;

            List<GemData> itemGems =
                    SocketEngine.getGems(item);

            if (itemGems != null)
                gems.addAll(itemGems);
        }

        return gems;
    }
} 
