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
            case "create":{

                if(args.length > 2){
                    sender.sendMessage(help());
                }

                else if(args.length == 1 || args.length == 2){
                    WorldCreator creator = new WorldCreator(args[1]);
                    if(args.length == 2){
                        creator.seed(Long.parseLong(args[2]));
                    }
                    sender.sendMessage(ChatColor.BLUE + "Die Welt wird jetzt erstellt");
                    Bukkit.createWorld(creator);
                    sender.sendMessage(ChatColor.BLUE + "Die Welt wurde erstellt");

                }
                break;
            }

            case "tp":{
                if (sender instanceof Player) {
                    Player player = (Player) sender;

                    if (args.length == 1) {
                        if (sender instanceof Player) {
                            sender.sendMessage("tpt dich zu welt " + args[1]);
                            if (Bukkit.getWorld(args[1]) != null) {
                                player.teleport(Bukkit.getWorld(args[1]).getSpawnLocation());
                            }
                        } else {
                            sender.sendMessage("Du bist kein Spieler und kannst dicht tpt werden");
                        }

                    } else {
                        sender.sendMessage("Benutze \n" + ChatColor.BLUE + "/worlds tp <world>");
                    }
                    break;
                }
            }

            default: {
                sender.sendMessage(help());
            }
        }


        return false;
    }



    private String help(){
        return ("Benutze \n" + ChatColor.BLUE.toString() +"/worlds create <name> [seed] \n /worlds show \n /worlds tp <name>");
    }
}
