package io.github.simplexdev.paper;

import io.github.simplexdev.polarize.api.IPoint2D;
import io.github.simplexdev.polarize.api.IPoint3D;
import io.github.simplexdev.polarize.api.IScalar;
import io.github.simplexdev.polarize.api.IVector;
import io.github.simplexdev.polarize.cartesian.CartesianVector;
import io.github.simplexdev.polarize.math.Point2D;
import io.github.simplexdev.polarize.math.Point3D;
import io.github.simplexdev.polarize.polar.Scalar;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class DataConverter {

    public static Vector toBukkitVector(IVector vector) {
        return new Vector(vector.getX(), vector.getY(), vector.getZ());
    }

    public static IVector toPolarizeVector(Vector vector) {
        return new CartesianVector(vector.getX(), vector.getY(), vector.getZ());
    }

    public static Location toBukkitLocation(World world, IPoint3D point) {
        return new Location(world, point.getX(), point.getY(), point.getZ());
    }

    public static Location toBukkitLocation(World world, double y, IPoint2D point) {
        return new Location(world, point.getX(), y, point.getZ());
    }

    public static IPoint3D to3DPoint(Location location) {
        return new Point3D(location.getX(), location.getY(), location.getZ());
    }

    public static IPoint2D to2DPoint(Location location) {
        return new Point2D(location.getX(), location.getZ());
    }

    public static IScalar getScalar(Location location, Vector vector) {
        return new Scalar(vector.length(), Math.sqrt(
                location.getX() * location.getX()
                        + location.getZ() * location.getZ()));
    }

    public static IScalar getScalar(Location location) {
        return new Scalar(location.getDirection().length(),
                Math.sqrt(location.getX() * location.getX()
                        + location.getZ() * location.getZ()));
    }

    public static Vector fromScalar(IScalar scalar, Location location) {
        double magnitude = scalar.getMagnitude();

        double x = location.getX(),
                y = location.getY(),
                z = location.getZ();

        double length = magnitude / Math.sqrt(x * x + y * y + z * z);

        double xMod = x * length,
                yMod = y * length,
                zMod = z * length;

        return new Vector(xMod, yMod, zMod);
    }

    public static IScalar toScalar(Vector vector, double origin) {
        double magnitude = Math.sqrt(vector.getX() * vector.getX() + vector.getY() * vector.getY() + vector.getZ() * vector.getZ());

        double magnitudeDiff = magnitude - vector.length();
        double originMod = origin - magnitudeDiff;

        return new Scalar(magnitude, originMod);
    }
}
