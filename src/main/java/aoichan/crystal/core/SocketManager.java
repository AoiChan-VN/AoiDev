package aoichan.crystal.core;

import aoichan.crystal.AoiMain;
import aoichan.crystal.utils.PDCUtil;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class SocketManager {

    private final AoiMain plugin;

    public SocketManager(AoiMain plugin) {
        this.plugin = plugin;
    }

    public void attachGem(ItemStack item, String gemId) {
        String unique = gemId + ":" + UUID.randomUUID();
        PDCUtil.setGemTag(item, unique);
    }

    public boolean hasGem(ItemStack item) {
        return PDCUtil.hasGemTag(item);
    }
}
