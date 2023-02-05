package de.monaco07.publicserver.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LobbyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Du bist kein Spieler und kannst dich nicht tp.");

        }
        else {
            Player player = (Player) sender;
            World world = Bukkit.getWorld("lobby");
            player.teleport(new Location(world, 0, 0, 0));
        }

        return false;
    }
}
