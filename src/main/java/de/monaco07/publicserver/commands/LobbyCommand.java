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
        if (sender instanceof Player) {
            Player player = (Player) sender;
            World world = Bukkit.getWorld("lobby");
            player.teleport(new Location(world, 0.5, 1, 0.5));
            return true;
        } else {
            sender.sendMessage("Nur Spieler können diesen Befehl verwenden.");
            return false;
        }
    }
}