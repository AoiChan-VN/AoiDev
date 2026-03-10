package aoichan.crystal.platform.command.sub;

import aoichan.crystal.infrastructure.pdc.SocketStorage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SocketCommand implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(sender instanceof Player player)) {

            sender.sendMessage("Player only.");
            return;
        }

        if (args.length < 2) {

            player.sendMessage("/crystal socket <amount>");
            return;
        }

        int amount = Integer.parseInt(args[1]);

        ItemStack item = player.getInventory().getItemInMainHand();

        if (item == null) {

            player.sendMessage("No item in hand.");
            return;
        }

        // [!] Code: Set socket
        SocketStorage.setSockets(item, amount);

        player.sendMessage("§aSockets set to " + amount);
    }
} 
