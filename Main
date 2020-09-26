package com.airswiss.antisyntaxbukkit.antisyntaxbukkit;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

import java.io.File;

public final class AntiSyntaxBukkit extends JavaPlugin implements Listener, CommandExecutor {

    public File AntiSyntaxBukkitFile;
    public FileConfiguration AntiSyntaxBukkitConfig;

    public void registerEvents() {

        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }

    public void registerCommands() {
        
        getCommand("AntiSyntaxBukkit").setExecutor(new AntiSyntaxCommand(this));
    }

    public void getFiles(){
        AntiSyntaxBukkitFile = new File(getDataFolder(),"config.yml");
        AntiSyntaxBukkitConfig = getConfig();
        this.getConfig().options().copyDefaults(true);
    }

    @Override
    public void onEnable() {
        registerCommands();
        registerEvents();
        getFiles();
        return;
    }

    String c (String c) {
        c = c.replace("&", "§");
        return c;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().split(" ")[0].contains(":")) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(this.c(getConfig().getString("Blocked-Mesasage")));
        }
    }
}
