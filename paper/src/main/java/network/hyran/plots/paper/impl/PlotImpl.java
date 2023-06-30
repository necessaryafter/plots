package network.hyran.plots.paper.impl;

import lombok.Builder;
import network.hyran.plots.api.Plot;
import network.hyran.plots.api.location.PlotLocation;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.UUID;

@Builder
public final class PlotImpl implements Plot {

    private final String playerName;
    private final PlotLocation location;

    @Builder.Default
    private final Collection<String> trusted = new HashSet<>();

    @Builder.Default
    private final UUID plotId = UUID.randomUUID();

    @Override
    public UUID getPlotId() {
        return plotId;
    }

    @Override
    public String getPlotOwner() {
        return playerName;
    }

    @Override
    public Collection<String> getTrusted() {
        return trusted;
    }

    @Override
    public PlotLocation getPlotLocation() {
        return location;
    }
}
