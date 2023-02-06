package de.monaco07.publicserver.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnListener implements Listener {
    public void onRespawn(PlayerRespawnEvent event) {
        World world = Bukkit.getServer().getWorld("lobby");
        Location spawnLocation = new Location(world, 0, -60, 0);
        event.setRespawnLocation(spawnLocation);
    }
}

