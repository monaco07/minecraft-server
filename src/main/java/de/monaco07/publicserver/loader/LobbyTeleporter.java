package de.monaco07.publicserver.loader;

import de.monaco07.publicserver.utils.ItemBuilder;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class LobbyTeleporter {
    public static void teleport(Player player){

        World world = Bukkit.getServer().getWorld("lobby");
        Location spawnLocation = new Location(world, 0.5, 1, 0.5);
        player.teleport(spawnLocation);
        ItemStack itemStack = new ItemBuilder(Material.COMPASS).setDisplayname(ChatColor.DARK_RED+ "Teleporter").build();

        player.getInventory().clear();
        player.getInventory().setItem(0, itemStack);
        player.setGameMode(GameMode.ADVENTURE);

    }
}
