package network.hyran.plots.api.location;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public interface PlotLocation {

    String getWorldName();

    double getX();
    double getY();
    double getZ();

    float getYaw();
    float getPitch();

    default Location getBukkitLocation() {
        return new Location(
                Bukkit.getWorld(getWorldName()),
                getX(), getY(), getZ(), getYaw(), getPitch()
        );
    }

}
