package com.airswiss.antisyntaxbukkit.antisyntaxbukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AntiSyntaxCommand implements CommandExecutor {
    public AntiSyntaxBukkit pl;

    public AntiSyntaxCommand(AntiSyntaxBukkit pl) {
        this.pl=pl;
    }

    String c(String c) {
        c = c.replace("&", "§");
        return c;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Only in game !");
        }
        if(command.getName().equalsIgnoreCase("AntiSyntaxBukkit")) {
            if(sender.hasPermission("AntiSyntaxBukkit.Reload")) {
                pl.reloadConfig();
                pl.saveConfig();
                sender.sendMessage(this.c("&f[&6AntiSyntaxBukkit&f] &7Plugin reloaded !"));
                return true;
            } else {
                sender.sendMessage(this.c(pl.getConfig().getString("No-Perm")));
            }
        }
        return true;
    }
}
