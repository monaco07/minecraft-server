package de.monaco07.publicserver.loader;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;

public class WorldLoader {

    public static void loadWorld(String worldName, World.Environment worldType) {

        new WorldCreator(worldName).environment(worldType).createWorld();

        World world = Bukkit.getWorld(worldName);
        if (world == null) {
            Bukkit.getLogger().warning("The world " + worldName + " does not exist and will not be loaded.");
        }

    }
}
