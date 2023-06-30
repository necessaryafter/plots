package network.hyran.plots.api.provider;

import network.hyran.plots.api.Plot;
import network.hyran.plots.api.user.PlotUser;

import java.util.UUID;

public interface PlotProvider {

    Plot create(PlotUser user);

    Plot load(UUID plotId);

    void save(Plot plot);

}
