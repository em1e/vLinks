package me.mie.vlinks.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class LinksCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("links")){
            // if command is run in console
            if (!(sender instanceof Player)){
                sender.sendMessage(ChatColor.LIGHT_PURPLE + "YOUTUBE: " + ChatColor.WHITE + "https://www.youtube.com/");
                sender.sendMessage(ChatColor.LIGHT_PURPLE + "INSTAGRAM: " + ChatColor.WHITE + "https://www.instagram.com/");
                sender.sendMessage(ChatColor.LIGHT_PURPLE + "DISCORD: " + ChatColor.WHITE + "https://discord.gg/violets");
                sender.sendMessage(ChatColor.LIGHT_PURPLE + "GITHUB: " + ChatColor.WHITE + "https://github.com/");
                return true;
            }

            Player p = (Player) sender;

            if (args.length == 0) {
                // if /links is run by itself, no arguments, then open GUI
                Inventory menu = Bukkit.createInventory(p, 9, ChatColor.AQUA + "Custom GUI");

                // create items
                ItemStack youtube = new ItemStack(Material.POPPY);
                ItemStack instagram = new ItemStack(Material.ALLIUM);
                ItemStack discord = new ItemStack(Material.CORNFLOWER);
                ItemStack github = new ItemStack(Material.WITHER_ROSE);
                ItemStack help = new ItemStack(Material.DIRT);

                // youtube meta
                ItemMeta ytMeta = youtube.getItemMeta();
                ytMeta.setDisplayName(ChatColor.RED + "" + ChatColor.DARK_GRAY + "YouTube");
                List<String> ytLore = new ArrayList<>();
                ytLore.add(ChatColor.GRAY + "A cool place to watch videos!");
                ytMeta.setLore(ytLore);
                youtube.setItemMeta(ytMeta);

                // instagram meta
                ItemMeta igMeta = youtube.getItemMeta();
                igMeta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.DARK_GRAY + "Instagram");
                List<String> igLore = new ArrayList<>();
                igLore.add(ChatColor.GRAY + "Place to post pictures and artsy things");
                igMeta.setLore(igLore);
                instagram.setItemMeta(igMeta);

                // Discord meta
                ItemMeta dcMeta = youtube.getItemMeta();
                dcMeta.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.DARK_GRAY + "Discord");
                List<String> dcLore = new ArrayList<>();
                dcLore.add(ChatColor.GRAY + "Place to chat with cool people!");
                dcLore.add(" ");
                dcLore.add(ChatColor.AQUA + "" + ChatColor.BOLD + "Why not join our server while you're at it?");
                dcMeta.setLore(dcLore);
                discord.setItemMeta(dcMeta);

                // Github meta
                ItemMeta ghMeta = github.getItemMeta();
                ghMeta.setDisplayName(ChatColor.DARK_GRAY + "" + ChatColor.DARK_GRAY + "Github");
                List<String> ghLore = new ArrayList<>();
                ghLore.add(ChatColor.GRAY + "A place to store code");
                ghLore.add(" ");
                ghLore.add(ChatColor.AQUA + "" + ChatColor.DARK_GRAY + "Click here to follow me for more plugins!");
                ghMeta.setLore(ghLore);
                github.setItemMeta(ghMeta);

                // help meta
                ItemMeta hMeta = help.getItemMeta();
                hMeta.setDisplayName(ChatColor.DARK_GRAY + "" + ChatColor.DARK_GRAY + "Help");
                List<String> hLore = new ArrayList<>();
                hLore.add(ChatColor.GRAY + "Click here to get help");
                hMeta.setLore(hLore);
                help.setItemMeta(hMeta);

                // diff ways to set items into an inv:
                // inv.addItem(), inv.setContents(), inv.setItem()

                menu.setItem(2, youtube);
                menu.setItem(3, instagram);
                menu.setItem(4, github);
                menu.setItem(5, discord);
                menu.setItem(6, help);

                // opens the custom gui for the player
                p.openInventory(menu);
                return true;
            } else if (args.length == 1){
                // arguments given with command
                if (args[0].equalsIgnoreCase("youtube")) { // add hover effect
                    p.sendMessage(ChatColor.LIGHT_PURPLE + "YOUTUBE: " + ChatColor.WHITE + "https://www.youtube.com/");
                    return true;
                }
                if (args[0].equalsIgnoreCase("instagram")) {
                    p.sendMessage(ChatColor.LIGHT_PURPLE + "INSTAGRAM: " + ChatColor.WHITE + "https://www.instagram.com/");
                    return true;
                }
                if (args[0].equalsIgnoreCase("discord")) {
                    p.sendMessage(ChatColor.LIGHT_PURPLE + "DISCORD: " + ChatColor.WHITE + "https://discord.gg/violets");
                    return true;
                }
                if (args[0].equalsIgnoreCase("github")) {
                    p.sendMessage(ChatColor.LIGHT_PURPLE + "GITHUB: " + ChatColor.WHITE + "https://github.com/");
                    return true;
                }
                if (args[0].equalsIgnoreCase("help")) {
                    Bukkit.dispatchCommand(sender, "help");
                    return true;
                }
            }
        }
        return true;
    }
}
