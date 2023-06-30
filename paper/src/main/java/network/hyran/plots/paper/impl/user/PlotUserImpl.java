package network.hyran.plots.paper.impl.user;

import lombok.Builder;
import lombok.NonNull;
import network.hyran.plots.api.Plot;
import network.hyran.plots.api.user.PlotUser;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.function.Predicate;

@Builder
public final class PlotUserImpl implements PlotUser {

    private final String playerName;

    @Builder.Default
    private final Collection<Plot> plots = new HashSet<>();

    @Override
    public String getName() {
        return playerName;
    }

    @Override
    public Collection<Plot> getPlots() {
        return plots;
    }

    @Override
    public Optional<Plot> getPlotBy(Predicate<Plot> predicate) {
        return this.plots.stream().filter(predicate).findFirst();
    }

    @Override
    public void addPlot(@NonNull Plot plot) {
        this.plots.add(plot);
    }

    @Override
    public void deletePlot(@NonNull Plot plot) {
        this.plots.remove(plot);
    }
}
