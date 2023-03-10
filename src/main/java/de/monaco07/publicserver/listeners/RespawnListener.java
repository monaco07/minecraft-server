package de.monaco07.publicserver.listeners;

import de.monaco07.publicserver.teleporter.CraftAttackTeleporter;
import de.monaco07.publicserver.teleporter.LobbyTeleporter;
import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;


public class RespawnListener implements Listener {
    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        World lobbyWorld = Bukkit.getServer().getWorld("lobby");
        World craftAttackWorld = Bukkit.getServer().getWorld("craftattack");


        if(event.getPlayer().getWorld() == craftAttackWorld) {

            CraftAttackTeleporter.teleport(event.getPlayer());

        }
        else {
            LobbyTeleporter.teleport(event.getPlayer());
        }



    }
}

