package com.aoi.crystalengine.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.aoi.crystalengine.CrystalEngine;

/*
#【!】Code:
Main engine command
*/

public class EngineCommand implements CommandExecutor {

    @Override
    public boolean onCommand(
        CommandSender sender,
        Command cmd,
        String label,
        String[] args
    ) {

        if (args.length == 0) {

            sender.sendMessage("§bCrystalEngine running.");
            return true;
        }

        if (args[0].equalsIgnoreCase("reload")) {

            CrystalEngine.get()
                .getBootstrap()
                .config()
                .reload();

            sender.sendMessage("§aEngine config reloaded.");
        }

        return true;
    }

} 
