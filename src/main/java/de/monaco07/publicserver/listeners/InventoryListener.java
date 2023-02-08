package de.monaco07.publicserver.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class InventoryListener implements Listener {
    @EventHandler
    public void onInvClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null) return;
        if(event.getView().getTitle() == "§4NAVIGATOR"){
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            if(event.getCurrentItem().getItemMeta().hasLocalizedName()){
                switch (event.getCurrentItem().getItemMeta().getLocalizedName()){
                    case "SPAWN":
                        World world = Bukkit.getServer().getWorld("lobby");
                        Location spawnLocation = new Location(world, 0, 1, 0);
                        player.teleport(spawnLocation);
                        player.closeInventory();
                        break;
                    case "CITYBUILD":
                        player.sendMessage(ChatColor.RED+ "Die Funktion gibt es später");
                        break;
                }
            }
        }
    }
}
