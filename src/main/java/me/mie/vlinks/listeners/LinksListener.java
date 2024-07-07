package me.mie.vlinks.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class LinksListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        // did the player click our inv: check title? menu manager?
        if (event.getView().getTitle().equals(ChatColor.AQUA + "Custom GUI")){

            // cancels any actions done in inv
            event.setCancelled(true);

            // ignores right clicks
            if (event.isRightClick()) return;

            Player p = (Player) event.getWhoClicked();

            // runs the corresponding command to which item was interacted with
            switch (event.getCurrentItem().getType()) {
                case POPPY:
                    Bukkit.dispatchCommand(p, "links youtube");
                    break;
                case ALLIUM:
                    Bukkit.dispatchCommand(p, "links instagram");
                    break;
                case CORNFLOWER:
                    Bukkit.dispatchCommand(p, "links discord");
                    break;
                case WITHER_ROSE:
                    Bukkit.dispatchCommand(p, "links github");
                    break;
                case DIRT:
                    Bukkit.dispatchCommand(p, "help");
                    break;
            }
        }
    }
}
