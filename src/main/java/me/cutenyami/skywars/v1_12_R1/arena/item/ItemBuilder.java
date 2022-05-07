package me.cutenyami.skywars.v1_12_R1.arena.item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class ItemBuilder extends ItemStack {

    public ItemBuilder(Material type) {
        super(type);
    }

    public ItemBuilder(Material type, int amount) {
        super(type, amount);
    }

    public ItemBuilder setDisplayName(String displayName) {
        ItemMeta meta = getItemMeta();
        meta.setDisplayName(displayName);
        setItemMeta(meta);
        return this;
    }

    public ItemBuilder setUnbreakable(boolean unbreakable) {
        ItemMeta meta = getItemMeta();
        meta.setUnbreakable(unbreakable);
        setItemMeta(meta);
        return this;
    }

    public ItemBuilder setSize(int size) {
        setAmount(size);
        return this;
    }

    @SuppressWarnings("deprecation")
    public ItemBuilder setSkull(String player) {
        SkullMeta meta = (SkullMeta) getItemMeta();
        meta.setOwner(player);
        setItemMeta(meta);
        return this;
    }

    public ItemBuilder setLore(String... lines) {
        ItemMeta meta = getItemMeta();
        meta.setLore(Arrays.asList(lines));
        setItemMeta(meta);
        return this;
    }

    public ItemBuilder setGlowing(boolean glowing) {
        ItemMeta meta = getItemMeta();
        if (glowing) {
            meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        } else {
            meta.removeEnchant(Enchantment.ARROW_DAMAGE);
            meta.removeItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        setItemMeta(meta);
        return this;
    }

    public ItemBuilder addItemFlags(ItemFlag... flags) {
        ItemMeta meta = getItemMeta();
        meta.addItemFlags(flags);
        setItemMeta(meta);
        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchantment, int power) {
        ItemMeta meta = getItemMeta();
        meta.addEnchant(enchantment, power, true);
        setItemMeta(meta);
        return this;
    }
}