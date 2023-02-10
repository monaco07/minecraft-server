package de.monaco07.publicserver.commands;

import de.monaco07.publicserver.loader.WorldLoader;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class WorldsCommand implements CommandExecutor {
    @Override

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length <= 0){
            sender.sendMessage(help());
        }
        else {


        switch (args[0].toLowerCase()){
            case "help": {
                sender.sendMessage(help());
                break;
            }
            case "list":
            case "show": {
                sender.sendMessage("Hier sind alle Welten");
                for (World world : Bukkit.getWorlds()){
                    sender.sendMessage(ChatColor.BLUE + world.getName());
                }
                break;
            }
            case "create": {
                if (args.length > 3) {
                    sender.sendMessage(help());
                } else {
                    WorldCreator creator = new WorldCreator(args[1]);
                    if (args.length == 3) {
                        try {
                            long seed = Long.parseLong(args[2]);
                            creator.seed(seed);
                        } catch (NumberFormatException e) {
                            sender.sendMessage(ChatColor.RED + "Fehler: Bitte geben Sie eine gültige Seed-Zahl ein.");
                            break;
                        }
                    }
                    sender.sendMessage(ChatColor.BLUE + "Die Welt wird jetzt erstellt...");
                    try {
                        Bukkit.createWorld(creator);
                        Bukkit.getWorlds().add(Bukkit.getWorld(args[1]));
                        sender.sendMessage(ChatColor.BLUE + "Die Welt wurde erfolgreich erstellt.");
                    } catch (Exception e) {
                        sender.sendMessage(ChatColor.RED + "Es gab ein Problem beim Erstellen der Welt: " + e.getMessage());
                    }
                }
                break;
            }

            case "tp":{
                if (!(sender instanceof Player)) {
                    sender.sendMessage("Du bist kein Spieler und kannst dich nicht tp.");

                }
                else {
                    Player player = (Player) sender;
                    if (args.length != 2) {
                        sender.sendMessage(ChatColor.RED + "Benutze: /worlds tp <welt>");

                    }
                    else {
                        World world = Bukkit.getWorld(args[1]);
                        if (world == null) {
                            sender.sendMessage(ChatColor.RED + "Die Welt '" + args[1] + "' wurde nicht gefunden.");

                        }
                        else if(world.getName() == "craftattack"){

                            Location spawnLocation = new Location(world, 0, 150, 0);
                            player.teleport(spawnLocation);
                        }

                        else {
                            player.teleport(world.getSpawnLocation());
                            sender.sendMessage(ChatColor.BLUE + "Du wurdest zu Welt '" + args[1] + "' teleportiert.");

                        }
                    }
                }
                break;

            }
            case "lade":
            case "load": {
                if (args.length != 2) {
                    sender.sendMessage("Verwendung: /worlds load <welt>");
                    return false;
                }

                World world = Bukkit.getWorld(args[1]);
                if (world != null) {
                    sender.sendMessage("Die Welt '" + args[1] + "' wurde schon geladen");
                    return false;

                }
                WorldLoader.loadWorld(args[1]);
                break;
            }
            case "unload":
                if (args.length != 2) {
                    sender.sendMessage("Verwendung: /worlds unload <welt>");
                    return false;
                }

                World world = Bukkit.getWorld(args[1]);
                if (world == null) {
                    sender.sendMessage("Die Welt '" + args[1] + "' konnte nicht gefunden werden.");
                    return false;
                }

                if (Bukkit.getWorlds().contains(world)) {
                    Bukkit.unloadWorld(args[1], true);
                    sender.sendMessage("Die Welt '" + args[1] + "' wurde entladen.");
                } else {
                    sender.sendMessage("Die Welt '" + args[1] + "' ist bereits entladen.");
                }
                break;

            default: {
                sender.sendMessage(help());
                break;

            }
        }
        }


        return false;
    }



    private String help(){
        return ("Benutze \n" + ChatColor.BLUE.toString() +" /worlds create <name> [seed] \n /worlds show \n /worlds tp <name> \n /worlds <load|unload> <name>");
    }
}
