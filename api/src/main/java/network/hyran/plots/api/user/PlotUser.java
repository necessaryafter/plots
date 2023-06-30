package network.hyran.plots.api.user;

import lombok.NonNull;
import network.hyran.plots.api.Plot;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public interface PlotUser {

    String getName();

    Collection<Plot> getPlots();

    Optional<Plot> getPlotBy(Predicate<Plot> predicate);

    void addPlot(@NonNull Plot plot);

    void deletePlot(@NonNull Plot plot);

}
