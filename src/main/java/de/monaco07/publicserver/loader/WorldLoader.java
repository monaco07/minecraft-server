package de.monaco07.publicserver.loader;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;

public class WorldLoader {

    public static void loadWorld(String worldName) {

        new WorldCreator(worldName).environment(World.Environment.NORMAL).createWorld();

        World world = Bukkit.getWorld(worldName);
        if (world == null) {
            Bukkit.getLogger().warning("The world " + worldName + " does not exist and will not be loaded.");
        }


    }
}
