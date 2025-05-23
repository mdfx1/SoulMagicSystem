package me.sandrp.soulMagicSystem.customFood.soulBlood;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class SoulBlood {
    private static final String ITEM_ID = "soul_blood";
    private static NamespacedKey key;

    public static ItemStack createItem() {
        ItemStack item = new ItemStack(Material.POTION);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§fSoul Blood");
        meta.setLore(List.of("§9Potion"));

        meta.setCustomModelData(1);
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, ITEM_ID);

        item.setItemMeta(meta);
        return item;
    }

    public static boolean isSoulBlood(ItemStack item) {
        if (item == null || !item.hasItemMeta()) return false;
        return item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING);
    }

    public static void register(JavaPlugin plugin) {
        key = new NamespacedKey(plugin, ITEM_ID);;
    }
}
