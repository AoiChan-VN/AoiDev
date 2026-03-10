package aoichan.crystal.api.forge;

import org.bukkit.inventory.ItemStack;

public class ForgeSession {

    // [!] Code: Item to upgrade
    private ItemStack item;

    // [!] Code: Gem item
    private ItemStack gem;

    public ForgeSession(ItemStack item, ItemStack gem) {
        this.item = item;
        this.gem = gem;
    }

    public ItemStack getItem() {
        return item;
    }

    public ItemStack getGem() {
        return gem;
    }
} 
