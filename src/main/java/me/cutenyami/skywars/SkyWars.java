package me.cutenyami.skywars;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkyWars extends JavaPlugin {

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public String getNMSVersion(){
        String v = Bukkit.getServer().getClass().getPackage().getName();
        return v.substring(v.lastIndexOf('.') + 1);
    }
}
