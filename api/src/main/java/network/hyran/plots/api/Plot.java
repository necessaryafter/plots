package network.hyran.plots.api;

import network.hyran.plots.api.location.PlotLocation;

import java.util.Collection;
import java.util.UUID;

public interface Plot {

    UUID getPlotId();

    String getPlotOwner();

    Collection<String> getTrusted();

    PlotLocation getPlotLocation();

}
