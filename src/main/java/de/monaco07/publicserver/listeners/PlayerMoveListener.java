package de.monaco07.publicserver.listeners;

import de.monaco07.publicserver.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {
    public void onPlayerMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if(player.getWorld() == Bukkit.getWorld("craftattack")){
            if(player.getInventory().getChestplate() == new ItemBuilder(Material.ELYTRA).setUnbreakable(true).setDisplayname("StartElytra").build()){
                if(!player.isGliding()){
                    if(player.getLocation().getY() <= 142){
                        player.getInventory().setChestplate(null);
                        // PLAYER INVENTAR LADEN

                    }
                }
            }
        }
    }
}
