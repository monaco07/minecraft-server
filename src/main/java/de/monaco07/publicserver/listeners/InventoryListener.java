package de.monaco07.publicserver.listeners;

import de.monaco07.publicserver.teleporter.CityBuildTeleporter;
import de.monaco07.publicserver.teleporter.CraftAttackTeleporter;
import de.monaco07.publicserver.teleporter.LobbyTeleporter;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


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
                CityBuildTeleporter.teleport(player);
            }
            else if (event.getCurrentItem().getType() == Material.MYCELIUM) {

                CraftAttackTeleporter.teleport(player);

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


