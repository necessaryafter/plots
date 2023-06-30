package network.hyran.plots.api.cache;

import lombok.NonNull;
import network.hyran.plots.api.user.PlotUser;

import java.util.Optional;

public interface PlotUserCache {

    void insertPlotUser(@NonNull PlotUser user);

    void deletePlotUser(@NonNull String playerName);

    Optional<PlotUser> getPlotUser(@NonNull String playerName);

}
