package me.mie.vlinks;

import me.mie.vlinks.commands.LinksCommand;
import me.mie.vlinks.commands.MagicalFlowerCommand;
import me.mie.vlinks.commands.StaffCommand;
import me.mie.vlinks.listeners.LinksListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("links").setExecutor(new LinksCommand());
        getServer().getPluginManager().registerEvents(new LinksListener(), this);

        getCommand("staff_handbook").setExecutor(new StaffCommand());
        getCommand("flower").setExecutor(new MagicalFlowerCommand());
    }

}
