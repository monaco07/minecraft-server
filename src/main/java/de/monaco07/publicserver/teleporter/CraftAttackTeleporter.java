package de.monaco07.publicserver.teleporter;

import de.monaco07.publicserver.loader.WorldLoader;
import de.monaco07.publicserver.utils.ItemBuilder;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CraftAttackTeleporter {
    public static void teleport(Player player){
        if(Bukkit.getServer().getWorld("craftattack") == null){
            WorldLoader.loadWorld("craftattack");
        }



        World world = Bukkit.getServer().getWorld("craftattack");
        Location spawnLocation = new Location(world, 0, 150, 0);
        player.teleport(spawnLocation);



        // Config Laden ?
        player.getInventory().clear();


        // Gamemodemiert
        player.setGameMode(GameMode.SURVIVAL);


        player.sendMessage(ChatColor.YELLOW + "Du spielst nun CraftAttack");
    }
}
