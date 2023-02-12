package de.monaco07.publicserver.listeners;

import de.monaco07.publicserver.teleporter.LobbyTeleporter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            World world = Bukkit.getWorld("lobby");

            if (player.getWorld() == world) {
                EntityDamageEvent.DamageCause cause = event.getCause();
                if (cause != EntityDamageEvent.DamageCause.VOID) {
                    player.setHealth(20);
                } else {
                    player.sendMessage(ChatColor.DARK_RED.toString() + ChatColor.UNDERLINE + player.getName() + " konnte nicht in der Lobby zu bleiben");
                    LobbyTeleporter.teleport(player);


                }
            }
        }
    }
}
