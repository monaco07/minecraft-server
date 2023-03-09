package de.monaco07.publicserver.teleporter;

import de.monaco07.publicserver.utils.ItemBuilder;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PVPTeleporter {
    public static void teleport(Player player){


        player.setGameMode(GameMode.SURVIVAL);

        player.getActivePotionEffects().clear();

        player.setFoodLevel(20);
        player.setHealth(20);

        player.getInventory().clear();
        player.getInventory().setItem(0, new ItemBuilder(Material.NETHERITE_SWORD).setUnbreakable(true).build());
        player.getInventory().setItem(1, new ItemBuilder(Material.NETHERITE_AXE).setUnbreakable(true).build());

        player.getInventory().setItem(39, new ItemBuilder(Material.DIAMOND_HELMET).setUnbreakable(true).build());
        player.getInventory().setItem(38, new ItemBuilder(Material.DIAMOND_CHESTPLATE).setUnbreakable(true).build());
        player.getInventory().setItem(37, new ItemBuilder(Material.DIAMOND_LEGGINGS).setUnbreakable(true).build());
        player.getInventory().setItem(36, new ItemBuilder(Material.DIAMOND_BOOTS).setUnbreakable(true).build());

        player.getInventory().setItem(40, new ItemBuilder(Material.SHIELD).setUnbreakable(true).build());

        World world = Bukkit.getServer().getWorld("lobby");
        Location spawnLocation = new Location(world, 3000, 0, 3000);
        player.teleport(spawnLocation);


    }
}
