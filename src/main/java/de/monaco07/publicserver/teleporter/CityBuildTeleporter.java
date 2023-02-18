package de.monaco07.publicserver.teleporter;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class CityBuildTeleporter {
    public static void teleport(Player player){




        // Inventiert config von citybuild + craftattack

        player.getInventory().clear();


        // Gamemodetiert
        player.setGameMode(GameMode.SURVIVAL);

        // Essen + Leben
        player.setFoodLevel(20);
        player.setHealth(20);
        // Potions
        player.removePotionEffect(PotionEffectType.SPEED);


        // Teleportiert
        World world = Bukkit.getServer().getWorld("citybuilt_1");
        Location spawnLocation = new Location(world, 25, 63, -74);
        player.teleport(spawnLocation);
    }
}

