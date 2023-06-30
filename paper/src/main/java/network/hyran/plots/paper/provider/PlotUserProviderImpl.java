package network.hyran.plots.paper.provider;

import lombok.RequiredArgsConstructor;
import network.hyran.plots.api.Plot;
import network.hyran.plots.api.cache.PlotUserCache;
import network.hyran.plots.api.provider.PlotUserProvider;
import network.hyran.plots.api.repository.PlotRepository;
import network.hyran.plots.api.user.PlotUser;
import network.hyran.plots.paper.impl.user.PlotUserImpl;

import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
public final class PlotUserProviderImpl implements PlotUserProvider {

    private final PlotUserCache cache;
    private final PlotRepository repository;

    @Override
    public void load(String playerName) {
        final Optional<PlotUser> optional = cache.getPlotUser(playerName);
        if(optional.isPresent()) {
            optional.get();
            return;
        }

        final Collection<Plot> collection = repository.findPlotsByUser(playerName);
        final PlotUser plotUser = PlotUserImpl.builder()
                .plots(collection)
                .build();

        this.cache.insertPlotUser(plotUser);
    }

    @Override
    public void save(String playerName) {
        final Optional<PlotUser> optional = cache.getPlotUser(playerName);
        optional.ifPresent(user -> user.getPlots().forEach(plot -> repository.insertPlot(user, plot)));
    }
}
