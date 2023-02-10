package de.monaco07.publicserver.listeners;

import de.monaco07.publicserver.loader.LobbyTeleporter;
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

            LobbyTeleporter.teleport(event.getPlayer());
        }

        else if(event.getPlayer().getWorld() == craftAttackWorld) {

            Location spawnLocation = new Location(craftAttackWorld, 0, 150, 0);
            event.setRespawnLocation(spawnLocation);
            event.getPlayer().getInventory().clear();
            event.getPlayer().setGameMode(GameMode.SURVIVAL);

        }



    }
}

