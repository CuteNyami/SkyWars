package me.cutenyami.skywars.v1_12_R1.arena;

import org.bukkit.World;

public class ArenaCreator {

    private final String name;
    private final World baseWorld;

    public ArenaCreator(String name, World baseWorld) {
        this.name = name;
        this.baseWorld = baseWorld;
    }

    public String getName() {
        return name;
    }

    public World getBaseWorld() {
        return baseWorld;
    }
}
