package de.monaco07.publicserver.teleporter;

import de.monaco07.publicserver.utils.ItemBuilder;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LobbyTeleporter {
    public static void teleport(Player player){
        // Teleportiert
        World world = Bukkit.getServer().getWorld("lobby");
        Location spawnLocation = new Location(world, 0.5, 1, 0.5);
        player.teleport(spawnLocation);


        // Inventiert
        ItemStack itemStack = new ItemBuilder(Material.COMPASS).setDisplayname(ChatColor.DARK_RED+ "Teleporter").build();
        player.getInventory().clear();
        player.getInventory().setItem(0, itemStack);

        // Gamemodetiert
        player.setGameMode(GameMode.ADVENTURE);

        // Essen + Leben
        player.setFoodLevel(20);
        player.setHealth(20);
        // Potions
        PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 60 * 60 * 24, 1);
        player.addPotionEffect(speed);

    }
}
