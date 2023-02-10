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
            Inventory inv = Bukkit.createInventory(null, 4*9, "§4NAVIGATOR");

            inv.setItem(4, new ItemBuilder(Material.SNOWBALL).setDisplayname(ChatColor.BOLD.toString() + ChatColor.YELLOW + "SPAWN").build());
            inv.setItem(19, new ItemBuilder(Material.GRASS_BLOCK).setDisplayname(ChatColor.GREEN + "CityBuild").build());
            inv.setItem(21, new ItemBuilder(Material.MYCELIUM).setDisplayname(ChatColor.GREEN + "CraftAttack").build());
            inv.setItem(23, new ItemBuilder(Material.RED_BED).setDisplayname(ChatColor.GREEN + "BedWars").build());
            inv.setItem(25, new ItemBuilder(Material.ENDER_EYE).setDisplayname(ChatColor.GREEN + "SkyWars").build());
            event.getPlayer().openInventory(inv);
            }

    }
}

