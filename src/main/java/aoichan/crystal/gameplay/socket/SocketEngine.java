package aoichan.crystal.gameplay.socket;

import aoichan.crystal.infrastructure.pdc.GemStorage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Type;
import java.util.List;

public class SocketEngine {

    private static final Gson gson = new Gson();

    // [!] Code: Read gems from item
    public static List<GemData> getGems(ItemStack item) {

        String json = GemStorage.get(item);

        Type type =
                new TypeToken<List<GemData>>(){}.getType();

        return gson.fromJson(json, type);
    }
} 
