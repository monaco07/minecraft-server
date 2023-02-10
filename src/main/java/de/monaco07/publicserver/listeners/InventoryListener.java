package de.monaco07.publicserver.listeners;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class InventoryListener implements Listener {

    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase(  "§4NAVIGATOR")) { //dont forget to include ChatColor formatting

            //Make sure the player clicked on an item and not on the inventory
            if (event.getCurrentItem() == null) {
                return;
            }

            //See what item they clicked on by getting the material of the item
            if (event.getCurrentItem().getType() == Material.SNOWBALL) {

                World world = Bukkit.getServer().getWorld("lobby");
                Location spawnLocation = new Location(world, 0, 1, 0);
                event.getWhoClicked().teleport(spawnLocation);
                event.getWhoClicked().sendMessage(ChatColor.YELLOW + "Du wurdest zum Spawn teleportiert");
            }
            else if (event.getCurrentItem().getType() == Material.GRASS_BLOCK) {
                event.getWhoClicked().sendMessage("Citybuild gibts noch nicht");
            }
            else if (event.getCurrentItem().getType() == Material.MYCELIUM) {
                World world = Bukkit.getServer().getWorld("craftattack");
                Location spawnLocation = new Location(world, 0, 150, 0);
                event.getWhoClicked().teleport(spawnLocation);
                event.getWhoClicked().sendMessage(ChatColor.YELLOW + "Du befindest dich jetzt in CraftAttack");
            }
            else if (event.getCurrentItem().getType() == Material.RED_BED) {
                event.getWhoClicked().sendMessage("BedWars gibts noch nicht");
            }
            else if (event.getCurrentItem().getType() == Material.ENDER_EYE) {
                event.getWhoClicked().sendMessage("SkyWars gibts noch nicht");
            }




            else {
                System.out.println("Error, wohin wurde geklickt, item nicht angemeldet");
            }

            //make it so that players cannot move items in the inventory
            event.setCancelled(true);

        }

    }
}


