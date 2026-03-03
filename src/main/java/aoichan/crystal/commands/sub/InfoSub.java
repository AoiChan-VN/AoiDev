package aoichan.crystal.commands.sub;

import aoichan.crystal.AoiMain;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;

public class InfoSub implements SubCommand {

    private final AoiMain plugin;

    public InfoSub(AoiMain plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getPermission() {
        return "gems.info";
    }

    @Override
    public boolean isPlayerOnly() {
        return false;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        Player target;

        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Specify player.");
                return;
            }
            target = (Player) sender;
        } else {
            target = Bukkit.getPlayerExact(args[0]);
            if (target == null) {
                sender.sendMessage("Player not found.");
                return;
            }
        }

        Map<String, Integer> gems =
                plugin.getGemsManager().getAllGems(target.getUniqueId());

        sender.sendMessage("=== Gems of " + target.getName() + " ===");
        for (Map.Entry<String, Integer> entry : gems.entrySet()) {
            sender.sendMessage(entry.getKey() + ": " + entry.getValue());
        }
    }
} 
