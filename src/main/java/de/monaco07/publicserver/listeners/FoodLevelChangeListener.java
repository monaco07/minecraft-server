package de.monaco07.publicserver.listeners;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;


public class FoodLevelChangeListener implements Listener {
    @EventHandler
    public void onHunger(FoodLevelChangeEvent event){
        if (!(event.getFoodLevel() < event.getEntity().getFoodLevel())) return;

        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            World world = Bukkit.getWorld("lobby");
            if (player.getWorld() == world){
                event.setFoodLevel(20);
            }

        }
    }
}
