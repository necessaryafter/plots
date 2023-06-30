package network.hyran.plots.api.repository;

import lombok.NonNull;
import network.hyran.plots.api.Plot;
import network.hyran.plots.api.user.PlotUser;

import java.util.Collection;
import java.util.UUID;

public interface PlotRepository {

    void insertPlot(@NonNull PlotUser user, @NonNull Plot plot);
    void deletePlot(@NonNull Plot plot);

    Collection<Plot> findPlotsByUser(@NonNull String name);
    Plot findPlot(@NonNull UUID plotId);


}
