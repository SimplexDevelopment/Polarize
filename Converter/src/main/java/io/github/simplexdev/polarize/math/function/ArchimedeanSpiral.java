package io.github.simplexdev.polarize.math.function;

import io.github.simplexdev.polarize.api.spatial.IPoint2D;
import io.github.simplexdev.polarize.api.units.Point;
import io.github.simplexdev.polarize.api.units.Theta;
import io.github.simplexdev.polarize.cartesian.Point2D;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashSet;
import java.util.Set;

public class ArchimedeanSpiral {
    private final double origin;
    private final double step;
    private final double radius;
    private final Theta theta;

    public ArchimedeanSpiral(double origin, double step, @NotNull Theta theta) {
        this.origin = origin;
        this.step = step;
        this.theta = theta;

        this.radius = origin + (this.step * theta.getZenith());
    }

    public Set<IPoint2D> getPoints(IPoint2D start) {
        Set<IPoint2D> hashSet = new LinkedHashSet<>();
        hashSet.add(start);
        for (double i = origin; i < theta.getZenith(); i += step) {
            double x = radius * Math.cos(i);
            double z = radius * Math.sin(i);
            hashSet.add(Point.fromDouble(x + start.getX().get(), z + start.getZ().get()));
        }
        return hashSet;
    }
}
