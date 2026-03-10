package aoichan.crystal.core.gem;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

// [!] Code: Central gem registry
public class GemRegistry {

    private static final Map<String, Gem> gems = new HashMap<>();

    public static void register(Gem gem) {

        gems.put(
                gem.getId(),
                gem
        );
    }

    public static Gem get(String id) {

        return gems.get(id);
    }

    public static Collection<Gem> getAll() {

        return gems.values();
    }

    public static void clear() {

        gems.clear();
    }
} 
