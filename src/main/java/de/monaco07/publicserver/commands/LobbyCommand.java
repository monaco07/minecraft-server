package de.monaco07.publicserver.commands;

import de.monaco07.publicserver.loader.LobbyTeleporter;
import de.monaco07.publicserver.utils.ItemBuilder;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class LobbyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            LobbyTeleporter.teleport(player);

            return true;
        } else {
            sender.sendMessage("Nur Spieler können diesen Befehl verwenden.");
            return false;
        }
    }
}