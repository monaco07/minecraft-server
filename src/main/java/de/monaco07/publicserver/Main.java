package de.monaco07.publicserver;

import de.monaco07.publicserver.commands.LobbyCommand;
import de.monaco07.publicserver.commands.TimerCommand;
import de.monaco07.publicserver.commands.WorldsCommand;
import de.monaco07.publicserver.listeners.*;
import de.monaco07.publicserver.timer.Timer;
import de.monaco07.publicserver.loader.WorldLoader;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main instance;
    private Timer timer;

    @Override
    public void onLoad(){
        instance = this;
    }

    @Override
    public void onEnable() {

        WorldLoader.loadWorld("lobby");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "Server wurde erfolgreich gestartet");

        // Plugin startup logic


        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new RespawnListener(), this);
        pluginManager.registerEvents(new QuitListener(), this);
        pluginManager.registerEvents(new ItemClickListener(), this);
        pluginManager.registerEvents(new InventoryListener(), this);

        getCommand("timer").setExecutor(new TimerCommand());
        getCommand("worlds").setExecutor(new WorldsCommand());
        getCommand("l").setExecutor(new LobbyCommand());
        getCommand("lobby").setExecutor(new LobbyCommand());
        getCommand("h").setExecutor(new LobbyCommand());
        getCommand("hub").setExecutor(new LobbyCommand());




        timer = new Timer(false, 0);



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return instance;
    }

    public Timer getTimer() {
        return timer;
    }

    }

