package de.monaco07.publicserver.listeners;

import de.monaco07.publicserver.loader.LobbyTeleporter;
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
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equalsIgnoreCase(  "§4NAVIGATOR")) { // CHATCOLOR nicht vergessen


            if (event.getCurrentItem() == null) {
                return;
            }

            //See what item they clicked on by getting the material of the item
            if (event.getCurrentItem().getType() == Material.SNOWBALL) {
                LobbyTeleporter.teleport(player);
            }
            else if (event.getCurrentItem().getType() == Material.GRASS_BLOCK) {
               player.sendMessage("Citybuild gibts noch nicht");
            }
            else if (event.getCurrentItem().getType() == Material.MYCELIUM) {
                World world = Bukkit.getServer().getWorld("craftattack");
                Location spawnLocation = new Location(world, 0, 150, 0);
                player.teleport(spawnLocation);


                // Hier muss die Dateien von craftattack rüstung ( items geladen werden
                player.getInventory().clear();

                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(ChatColor.YELLOW + "Du befindest dich jetzt in CraftAttack");
            }
            else if (event.getCurrentItem().getType() == Material.RED_BED) {
                player.sendMessage("BedWars gibts noch nicht");
            }
            else if (event.getCurrentItem().getType() == Material.ENDER_EYE) {
                player.sendMessage("SkyWars gibts noch nicht");
            }




            else {
                System.out.println("Error, wohin wurde geklickt, item nicht angemeldet");
            }

            //make it so that players cannot move items in the inventory
            event.setCancelled(true);

        }

    }
}


