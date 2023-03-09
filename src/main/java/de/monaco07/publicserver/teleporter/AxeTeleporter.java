package de.monaco07.publicserver.teleporter;

import de.monaco07.publicserver.utils.ItemBuilder;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class AxeTeleporter {
    public static void teleport(Player player){


        player.setGameMode(GameMode.SURVIVAL);

        player.getActivePotionEffects().clear();

        player.setFoodLevel(20);
        player.setHealth(20);

        player.getInventory().clear();

        ItemStack sword = new ItemBuilder(Material.NETHERITE_SWORD).addEnchantment(Enchantment.DAMAGE_ALL, 5).addEnchantment(Enchantment.SWEEPING_EDGE, 3).addEnchantment(Enchantment.FIRE_ASPECT, 2).setUnbreakable(true).build();



        player.getInventory().setItem(0, sword);

        World world = Bukkit.getServer().getWorld("lobby");
        Location spawnLocation = new Location(world, 500, 0, 500);
        player.teleport(spawnLocation);
    }
}
