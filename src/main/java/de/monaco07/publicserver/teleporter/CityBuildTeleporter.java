package de.monaco07.publicserver.teleporter;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class CityBuildTeleporter {
    public static void teleport(Player player){
        // Teleportiert
        World world = Bukkit.getServer().getWorld("citybuilt_1");
        Location spawnLocation = new Location(world, 24, 63, -72);
        player.teleport(spawnLocation);


        // Inventiert config von citybuild + craftattack

        player.getInventory().clear();


        // Gamemodetiert
        player.setGameMode(GameMode.SURVIVAL);

        // Essen + Leben
        player.setFoodLevel(20);
        player.setHealth(20);
        // Potions
    }
}

