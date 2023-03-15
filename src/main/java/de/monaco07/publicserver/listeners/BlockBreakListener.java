package de.monaco07.publicserver.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.HashMap;

public class BlockBreakListener implements Listener {
    private HashMap<Location, Material> buildingBlocks = new HashMap<>();
    private int minX = -32;
    private int minY = 0;
    private int minZ = -32;
    private int maxX = 32;
    private int maxY = 256;
    private int maxZ = 32;

    public BlockBreakListener() {
        World world = Bukkit.getWorld("craftattack");
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    Location loc = new Location(world, x, y, z);
                    Block block = world.getBlockAt(loc);
                    buildingBlocks.put(loc, block.getType());
                }
            }
        }
    }


    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getPlayer().getWorld() == Bukkit.getWorld("craftattack")) {
            Block block = event.getBlock();
            Location loc = block.getLocation();

            // Überprüfen, ob der abgebaute Block zu dem Gebäude gehört
            if (loc.getBlockX() >= minX && loc.getBlockX() <= maxX
                    && loc.getBlockY() >= minY && loc.getBlockY() <= maxY
                    && loc.getBlockZ() >= minZ && loc.getBlockZ() <= maxZ) {

                // Den Blocktyp auf den ursprünglichen Typ setzen
                Material originalType = buildingBlocks.get(loc);
                if (originalType != null) {
                    block.setType(originalType);
                    event.setCancelled(true);
                }
            }
        }
    }
}
