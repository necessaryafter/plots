package network.hyran.plots.paper.listener;

import lombok.RequiredArgsConstructor;
import network.hyran.plots.api.provider.PlotUserProvider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

@RequiredArgsConstructor
public final class ConnectionTrafficListener implements Listener {

    private final PlotUserProvider userProvider;

    @EventHandler(priority = EventPriority.MONITOR)
    private void handleConnectionAccepted(AsyncPlayerPreLoginEvent event) {
        if(event.getLoginResult() != AsyncPlayerPreLoginEvent.Result.ALLOWED) return;

        this.userProvider.load(event.getName());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    private void handleConnectionClosed(PlayerQuitEvent event) {
        this.userProvider.save(event.getPlayer().getName());
    }

}
