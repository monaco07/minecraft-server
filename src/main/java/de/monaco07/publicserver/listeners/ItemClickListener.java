package de.monaco07.publicserver.listeners;

import de.monaco07.publicserver.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ItemClickListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event){

        if(event.getItem() == null) return;

            ItemStack itemStack = event.getItem();

            if(itemStack.getType() == Material.COMPASS){
                event.getPlayer().sendMessage("Du hast den Kompass geklickt");
                Inventory inv = Bukkit.createInventory(null, 3*9, ChatColor.DARK_RED + "§4NAVIGATOR");

                inv.setItem(13, new ItemBuilder(Material.GRASS_BLOCK).setDisplayname(ChatColor.GREEN + "CITYBUILD").build());
                inv.setItem(4, new ItemBuilder(Material.MAGMA_CREAM).setDisplayname(ChatColor.LIGHT_PURPLE + "SPAWN").build());
                event.getPlayer().openInventory(inv);
            }

        }


    }

