package aoichan.crystal.platform.command.sub;

import org.bukkit.command.CommandSender;

// [!] Code: SubCommand interface
public interface SubCommand {

    void execute(
            CommandSender sender,
            String[] args
    );

}
