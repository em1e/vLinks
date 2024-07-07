package me.mie.vlinks.commands;

import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.chat.hover.content.Text;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class StaffCommand implements CommandExecutor {

    Map<String, Long> cooldown = new HashMap<String, Long>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("staff_handbook")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.GREEN + "https://wiki.violetsmc.com/books/staff-handbook");
                return true;
            }
            Player p = (Player) sender;
            if (cooldown.containsKey(p.getName())) {
                if (cooldown.get(p.getName()) > System.currentTimeMillis()) {
                    long timeleft = (cooldown.get(p.getName()) - System.currentTimeMillis()) / 1000;
                    p.sendMessage(ChatColor.GOLD + "Retry in " + timeleft + "seconds.");
                    return true;
                }
            }
            cooldown.put(p.getName(), System.currentTimeMillis() + (3 * 1000));


            if (!p.hasPermission("staff.use")) {
                p.sendMessage(ChatColor.RED + "Permission denied.");
                return true;
            }
            if (args.length == 0) {
                TextComponent msg = new TextComponent("Click here");
                msg.setColor(ChatColor.DARK_GREEN);
                msg.setBold(true);

                msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://wiki.violetsmc.com/books/staff-handbook"));
                msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                        new Text("Link to the staff handbook")));
                // TextComponent ending = new TextComponent("msg pt 2!");
                // ending.setColor(net.md_5.bungee.api.ChatColor.GREEN);
                // msg.addExtra(ending);
                p.spigot().sendMessage(msg);
                return true;
            }
        }
        return false;
    }
}
