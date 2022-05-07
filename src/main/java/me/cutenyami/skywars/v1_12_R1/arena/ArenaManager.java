package me.cutenyami.skywars.v1_12_R1.arena;

import me.cutenyami.skywars.v1_12_R1.arena.game.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ArenaManager {

    private final ArenaCreator creator;

    public ArenaManager(ArenaCreator creator) {
        this.creator = creator;
    }

    public boolean unloadWorld(World world) {
        return world != null && Bukkit.getServer().unloadWorld(world, false);
    }

    public void copyWorld() {
        copyFileStructure(creator.getBaseWorld().getWorldFolder(), new File(Bukkit.getWorldContainer(), creator.getBaseWorld().getWorldFolder().getName() + GameManager.runningGames()));
        new WorldCreator(creator.getBaseWorld().getWorldFolder().getName() + GameManager.runningGames()).createWorld();
    }

    private void copyFileStructure(File source, File target) {
        try {
            ArrayList<String> ignore = new ArrayList<>(Arrays.asList("uid.dat", "session.lock"));
            if (!ignore.contains(source.getName())) {
                if (source.isDirectory()) {
                    if (!target.mkdirs()) throw new IOException("Couldn't create world directory!");
                    String[] files = source.list();
                    if (files == null) return;
                    for (String file : files) {
                        File srcFile = new File(source, file);
                        File destFile = new File(target, file);
                        copyFileStructure(srcFile, destFile);
                    }
                } else {
                    InputStream inputStream = new FileInputStream(source);
                    OutputStream outputStream = new FileOutputStream(target);
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = inputStream.read(buffer)) > 0) {
                        outputStream.write(buffer, 0, length);
                    }
                    inputStream.close();
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArenaCreator getCreator() {
        return creator;
    }
}
