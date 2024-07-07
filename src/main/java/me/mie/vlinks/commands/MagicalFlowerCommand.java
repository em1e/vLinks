package me.mie.vlinks.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MagicalFlowerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("flower")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                ItemStack item = new ItemStack(Material.BLUE_ORCHID);
                ItemMeta meta = item.getItemMeta();

                meta.setDisplayName(org.bukkit.ChatColor.DARK_AQUA + "Magical Flower");
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.GRAY + "Will kill your enemies with love and kindness!");
                lore.add(" ");
                lore.add(ChatColor.RED + "" + ChatColor.BOLD + "Are you sure about this?");
                meta.setLore(lore);

                meta.addEnchant(Enchantment.DAMAGE_ALL, 255, true);
                meta.addEnchant(Enchantment.DURABILITY, 10, true);
                item.setItemMeta(meta);
                p.getInventory().addItem(item);
            }
            return true;
        }
        return false;
    }
}
