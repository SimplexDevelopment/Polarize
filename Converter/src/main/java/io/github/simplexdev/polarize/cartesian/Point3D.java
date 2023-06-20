package io.github.simplexdev.polarize.cartesian;

import io.github.simplexdev.polarize.api.spatial.IPoint3D;
import io.github.simplexdev.polarize.api.spatial.IVector;
import io.github.simplexdev.polarize.api.units.Point;
import io.github.simplexdev.polarize.log.PolarizeLogger;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashSet;
import java.util.Set;

public class Point3D implements IPoint3D {
    private final Point.X x;
    private final Point.Y y;
    private final Point.Z z;

    public Point3D(Point.X x, Point.Y y, Point.Z z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Point.X getX() {
        return x;
    }

    @Override
    public Point.Y getY() {
        return y;
    }

    @Override
    public Point.Z getZ() {
        return z;
    }

    @Override
    public IVector getDistance(@NotNull IPoint3D point) {
        return new CartesianVector(point.getX().subtract(x),
                point.getY().subtract(y),
                point.getZ().subtract(z));
    }

    @Override
    public IPoint3D multiply(IPoint3D point) {
        return new Point3D(() -> x.multiply(point.getX()),
                () -> y.multiply(point.getY()),
                () -> z.multiply(point.getZ()));
    }

    @Override
    public IPoint3D move(IVector vector) {
        return add(vector.getDestination());
    }

    @Override
    public IPoint3D getDifferential(@NotNull IPoint3D point) {
        return new Point3D(() -> point.getX().subtract(x),
                () -> point.getY().subtract(y),
                () -> point.getZ().subtract(z));
    }

    @Override
    public IPoint3D add(IPoint3D point) {
        return new Point3D(() -> point.getX().add(x),
                () -> point.getY().add(y),
                () -> point.getZ().add(z));
    }

    @Override
    public Set<IPoint3D> drawLine(IPoint3D point, double numPoints) {
        IPoint3D diff = getDifferential(point);
        Set<IPoint3D> point3DSet = new LinkedHashSet<>();
        for (double i = 0.0; i <= numPoints; i++) {
            double multiplier = i / numPoints;
            PolarizeLogger.info("i: " + i);
            PolarizeLogger.info("multiplier: " + multiplier);
            IPoint3D adjusted = Point.fromDouble(diff.getX().multiply(() -> multiplier),
                    diff.getY().multiply(multiplier),
                    diff.getZ().multiply(multiplier));
            PolarizeLogger.info("adjusted: " + "X: " + adjusted.getX()
                    + " Y: " + adjusted.getY()
                    + " Z: " + adjusted.getZ());
            IPoint3D added = this.add(adjusted);
            PolarizeLogger.info("added: " + "X: " + added.getX()
                    + " Y: " + added.getY()
                    + " Z: " + added.getZ());
            point3DSet.add(added);
        }
        return point3DSet;
    }

    public void drawLineTestMethod() {
        IPoint3D origin = Point.fromDouble(2, 6, 5);
        IPoint3D destination = Point.fromDouble(10, 6, -15);
        origin.drawLine(destination, 25).forEach(point3D ->
                PolarizeLogger.info("X: " + point3D.getX()
                        + " Y: " + point3D.getY()
                        + " Z: " + point3D.getZ()));
    }
}
