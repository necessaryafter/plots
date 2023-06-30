package network.hyran.plots.paper.impl.location;

import lombok.RequiredArgsConstructor;
import network.hyran.plots.api.location.PlotLocation;

@RequiredArgsConstructor
public final class PlotLocationImpl implements PlotLocation {

    private final String worldName;
    private final double x, y, z;
    private final float yaw, pitch;

    @Override
    public String getWorldName() {
        return worldName;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getZ() {
        return z;
    }

    @Override
    public float getYaw() {
        return yaw;
    }

    @Override
    public float getPitch() {
        return pitch;
    }


}
