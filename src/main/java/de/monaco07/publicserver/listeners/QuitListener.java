package de.monaco07.publicserver.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();

        event.setQuitMessage(ChatColor.BLUE.toString() + player + ChatColor.RED + " ist offline gegangen");
    }
}
