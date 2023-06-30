package network.hyran.plots.paper.provider;

import lombok.RequiredArgsConstructor;
import network.hyran.plots.api.Plot;
import network.hyran.plots.api.cache.PlotUserCache;
import network.hyran.plots.api.location.PlotLocation;
import network.hyran.plots.api.provider.PlotProvider;
import network.hyran.plots.api.repository.PlotRepository;
import network.hyran.plots.api.user.PlotUser;
import network.hyran.plots.paper.impl.PlotImpl;
import network.hyran.plots.paper.impl.location.PlotLocationImpl;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public final class PlotProviderImpl implements PlotProvider {

    private final PlotUserCache cache;
    private final PlotRepository repository;

    @Override
    public Plot create(PlotUser user) {
        final Player player = Bukkit.getPlayerExact(user.getName());
        if (player == null) return null;

        final Location playerLocation = player.getLocation();
        final PlotLocation plotLocation = new PlotLocationImpl(
                playerLocation.getWorld().getName(),
                playerLocation.getX(),
                playerLocation.getY(),
                playerLocation.getZ(),
                playerLocation.getYaw(),
                playerLocation.getPitch());

        final Plot plot = PlotImpl.builder()
                .playerName(user.getName())
                .location(plotLocation)
                .build();

        user.addPlot(plot);

        this.repository.insertPlot(user, plot);
        this.cache.insertPlotUser(user);

        return plot;
    }

    @Override
    public Plot load(UUID plotId) {
        return repository.findPlot(plotId);
    }

    @Override
    public void save(Plot plot) {
        final Optional<PlotUser> optional = this.cache.getPlotUser(plot.getPlotOwner());
        optional.ifPresent(user -> repository.insertPlot(user, plot));
    }
}
