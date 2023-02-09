package de.monaco07.publicserver.listeners;

import de.monaco07.publicserver.utils.ItemBuilder;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.GREEN.toString() + ChatColor.UNDERLINE + player.getName() + " hat den Server betreten");

        World world = Bukkit.getServer().getWorld("lobby");
        Location spawnLocation = new Location(world, 0, 1, 0);
        player.teleport(spawnLocation);
        ItemStack itemStack = new ItemBuilder(Material.COMPASS).setDisplayname("navigatortest123").build();


        player.getInventory().setItem(0, itemStack);

    }

}
