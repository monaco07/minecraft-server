package de.monaco07.publicserver.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorldsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {




        switch (args[0]){
            case "help": {
                sender.sendMessage(help());
                break;
            }
            case "show": {

                sender.sendMessage("Hier sind alle Welten");
                for (World world : Bukkit.getWorlds()){
                    sender.sendMessage(ChatColor.BLUE + world.getName());
                }
                break;
            }
            case "create": {
                if (args.length > 2) {
                    sender.sendMessage(help());
                } else {
                    WorldCreator creator = new WorldCreator(args[1]);
                    if (args.length == 2) {
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
                Player player = (Player) sender;
                if (args.length != 1) {
                    sender.sendMessage(ChatColor.RED + "Benutze: /worlds tp <welt>");

                }
                World world = Bukkit.getWorld(args[1]);
                if (world == null) {
                    sender.sendMessage(ChatColor.RED + "Die Welt '" + args[1] + "' wurde nicht gefunden.");

                }
                player.teleport(world.getSpawnLocation());
                sender.sendMessage(ChatColor.BLUE + "Du wurdest zu Welt '" + args[1] + "' teleportiert.");
                break;

            }

            default: {
                sender.sendMessage(help());
            }
        }


        return false;
    }



    private String help(){
        return ("Benutze \n" + ChatColor.BLUE.toString() +" /worlds create <name> [seed] \n /worlds show \n /worlds tp <name>");
    }
}
