package de.monaco07.publicserver.commands;

import de.monaco07.publicserver.teleporter.PVPTeleporter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KitCommand implements CommandExecutor {

    private void listKits(Player player){
        player.sendMessage("Hier sind alle Kits:");
        player.sendMessage("Benutze /kit <KitName>");
        player.sendMessage("PVP:");
        player.sendMessage("Axe");
        player.sendMessage("etc. noch hinzufügen..");

    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        else{
            Player player = (Player) sender;


            if(args[0].equalsIgnoreCase("pvp")){
                PVPTeleporter.teleport(player);
                return true;
            }
            else {
                listKits(player);
            }





        }


            return false;
    }
}
