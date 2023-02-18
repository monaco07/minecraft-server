package de.monaco07.publicserver.teleporter;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class SumoTeleporter {
    public static void teleport(Player player){
        player.getInventory().clear();

        player.setGameMode(GameMode.SURVIVAL);

        player.getActivePotionEffects().clear();

        player.setFoodLevel(20);
        player.setHealth(20);


        World world = Bukkit.getServer().getWorld("lobby");
        Location spawnLocation = new Location(world, 1500, 0, 1500);
        player.teleport(spawnLocation);
    }
}
