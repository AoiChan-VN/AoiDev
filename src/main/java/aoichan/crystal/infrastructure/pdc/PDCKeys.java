package aoichan.crystal.infrastructure.pdc;

import aoichan.crystal.bootstrap.CrystalPlugin;
import org.bukkit.NamespacedKey;

public class PDCKeys {

    // [!] Code: Gem JSON storage
    public static final NamespacedKey GEMS =
            new NamespacedKey(CrystalPlugin.get(), "crystal_gems");

    // [!] Code: Socket amount
    public static final NamespacedKey SOCKETS =
            new NamespacedKey(CrystalPlugin.get(), "crystal_sockets");

} 
