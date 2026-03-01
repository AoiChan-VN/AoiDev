package aoichan.crystal.gui;

import aoichan.crystal.AoiMain;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitTask;

import java.util.Map;
import java.util.WeakHashMap;

public class GUIAnimator {

    private static final Map<Inventory, BukkitTask> TASKS = new WeakHashMap<>();

    public static void animate(AoiMain plugin, Inventory inv) {
        if (inv == null) return;
        stop(inv);
        BukkitTask task = Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
            int slot = 0;
            @Override
            public void run() {
                if (slot >= inv.getSize()) slot = 0;
                inv.setItem(slot, inv.getItem(slot)); // placeholder: flicker logic
                slot++;
            }
        }, 0L, 4L);
        TASKS.put(inv, task);
    }

    public static void stop(Inventory inv) {
        BukkitTask t = TASKS.remove(inv);
        if (t != null) t.cancel();
    }
}
