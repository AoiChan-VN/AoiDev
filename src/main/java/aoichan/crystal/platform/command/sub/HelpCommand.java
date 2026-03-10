package aoichan.crystal.platform.command.sub;

import org.bukkit.command.CommandSender;

public class HelpCommand implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {

        sender.sendMessage("§5Crystal Ultimate");
        sender.sendMessage("§7/crystal forge");
        sender.sendMessage("§7/crystal give <player> <gem> <level>");
        sender.sendMessage("§7/crystal socket <amount>");
        sender.sendMessage("§7/crystal reload");
    }
} 
