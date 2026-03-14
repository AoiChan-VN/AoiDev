package aoichan.crystal.infrastructure.pdc;

import aoichan.crystal.bootstrap.AoiMain;
import org.bukkit.NamespacedKey;

public class PDCKeys {

    // [!] Code: Gem JSON storage
    public static final NamespacedKey GEMS =
            new NamespacedKey(AoiMain.get(), "crystal_gems");

    // [!] Code: Socket amount
    public static final NamespacedKey SOCKETS =
            new NamespacedKey(AoiMain.get(), "crystal_sockets");

    // [!] Code: Gem name id
    public static final NamespacedKey GEM_ID =
        new NamespacedKey(AoiMain.get(), "gem_id");

    // [!] Code: Gem level
    public static final NamespacedKey GEM_LEVEL =
        new NamespacedKey(AoiMain.get(), "gem_level");

    // [!] Code:
    public static final NamespacedKey CHARM_ID =
        new NamespacedKey(AoiMain.get(), "charm_id");
} 
