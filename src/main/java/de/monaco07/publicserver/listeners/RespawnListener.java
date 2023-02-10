package de.monaco07.publicserver.listeners;

import de.monaco07.publicserver.utils.ItemBuilder;
import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class RespawnListener implements Listener {
    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        World lobbyWorld = Bukkit.getServer().getWorld("lobby");
        World craftAttackWorld = Bukkit.getServer().getWorld("craftattack");
        if(event.getPlayer().getWorld() == lobbyWorld) {

            Location spawnLocation = new Location(lobbyWorld, 0, 1, 0);
            event.setRespawnLocation(spawnLocation);

            ItemStack itemStack = new ItemBuilder(Material.COMPASS).setDisplayname(ChatColor.DARK_RED + "Teleporter").build();

            event.getPlayer().getInventory().clear();
            event.getPlayer().getInventory().setItem(0, itemStack);
        }

        else if(event.getPlayer().getWorld() == craftAttackWorld) {

            Location spawnLocation = new Location(craftAttackWorld, 0, 1, 0);
            event.setRespawnLocation(spawnLocation);

        }



    }
}

