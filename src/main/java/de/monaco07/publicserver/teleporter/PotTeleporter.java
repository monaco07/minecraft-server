package de.monaco07.publicserver.teleporter;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PotTeleporter {
    public static void teleport(Player player){
        player.getInventory().clear();

        player.setGameMode(GameMode.SURVIVAL);

        player.getActivePotionEffects().clear();

        player.setFoodLevel(20);
        player.setHealth(20);



        World world = Bukkit.getServer().getWorld("lobby");
        Location spawnLocation = new Location(world, 2000, 0, 2000);
        player.teleport(spawnLocation);
    }
}
