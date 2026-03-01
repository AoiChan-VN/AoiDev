package aoichan.crystal.core;

import aoichan.crystal.AoiMain;
import aoichan.crystal.utils.PDCUtil;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class SocketManager {

    private final AoiMain plugin;
    private final int maxSlots;

    public SocketManager(AoiMain plugin) {
        this.plugin = plugin;
        this.maxSlots = plugin.getConfig().getInt("socket.max-slots", 3);
    }

    public boolean attachGem(ItemStack item, String gemId) {
        if (item == null) return false;

        List<String> gems = PDCUtil.getSocketList(item);
        if (gems.size() >= maxSlots) return false;

        gems.add(gemId);
        PDCUtil.setSocketList(item, gems);
        return true;
    }

    public List<String> getGems(ItemStack item) {
        if (item == null) return new ArrayList<>();
        return PDCUtil.getSocketList(item);
    }
}
