package io.github.simplexdev.polarize.math.function;

import io.github.simplexdev.polarize.api.spatial.IPoint3D;
import io.github.simplexdev.polarize.api.units.Point;
import io.github.simplexdev.polarize.cartesian.Point3D;

import java.util.LinkedHashSet;
import java.util.Set;

public final class FibonacciLattice {

    public static Set<IPoint3D> populate(IPoint3D origin, int radius, double step) {
        Set<IPoint3D> points = new LinkedHashSet<>();
        final double goldenRatio = (1 + Math.sqrt(5)) / 2;

        for (double i = 0; i <= radius; i += step) {
            double theta = 2 * Math.PI * i / goldenRatio;
            double phi = Math.acos(1 - 2 * (i + 0.5) / radius);
            double x = Math.cos(theta) * Math.sin(phi);
            double y = Math.cos(phi);
            double z = Math.sin(theta) * Math.sin(phi);

            points.add(origin.add(Point.fromDouble(x, y, z)));
        }

        return points;
    }
}
