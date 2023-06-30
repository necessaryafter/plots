package network.hyran.plots.paper;

import co.aikar.commands.BukkitLocales;
import co.aikar.commands.MessageType;
import co.aikar.commands.PaperCommandManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Locale;

public final class PlotsPaperPlugin extends JavaPlugin {

    private void registerCommands() {
        final PaperCommandManager paperCommandManager = new PaperCommandManager(this);
        final BukkitLocales bukkitLocales = paperCommandManager.getLocales();

        bukkitLocales.setDefaultLocale(new Locale("pt", "BR"));

        paperCommandManager.setFormat(MessageType.ERROR, ChatColor.RED);
        paperCommandManager.setFormat(MessageType.HELP, ChatColor.YELLOW);
        paperCommandManager.setFormat(MessageType.INFO, ChatColor.YELLOW);
        paperCommandManager.setFormat(MessageType.SYNTAX, ChatColor.RED);
    }

}
