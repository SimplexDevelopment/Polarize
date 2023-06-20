package io.github.simplexdev.polarize.util;

import io.github.simplexdev.polarize.api.rotation.IQuaternion;
import io.github.simplexdev.polarize.api.spatial.IPoint2D;
import io.github.simplexdev.polarize.api.spatial.IPoint3D;
import io.github.simplexdev.polarize.api.units.Point;
import io.github.simplexdev.polarize.cartesian.Point2D;
import io.github.simplexdev.polarize.cartesian.Point3D;
import io.github.simplexdev.polarize.math.Quaternion;
import io.github.simplexdev.polarize.polar.Delta;
import io.github.simplexdev.polarize.polar.PolarUnit;
import io.github.simplexdev.polarize.polar.SphericalUnit;

/**
 * A utility class for rotating points in 2d and 3d space.
 * This class supports rotations for Cartesian, Spherical, and Polar coordinates.
 * <p>
 * Typically, rotations in polar / spherical units are done with delta values.
 * The rotations in Cartesian units are done with a quaternion.
 */
public class Rotator {
    /**
     * This class should not be instantiated.
     */
    private Rotator() {
        throw new AssertionError();
    }

    /**
     * Rotates a point in 3d space using spherical units.
     * The returned result is a point in 3d space represented by {@link IPoint3D}.
     * This will rotate the point around the x-axis.
     *
     * @param point the point to rotate.
     * @param unit  the spherical unit to rotate the point with.
     * @return the rotated point.
     */
    public static IPoint3D rotateX(IPoint3D point, SphericalUnit unit) {
        double x = point.getX().get();
        double y = point.getY().multiply(Math.cos(unit.theta()))
                - point.getZ().multiply(Math.sin(unit.theta()));
        double z = point.getY().multiply(Math.sin(unit.theta()))
                + point.getZ().multiply(Math.cos(unit.theta()));

        return Point.fromDouble(x, y, z);
    }

    /**
     * Rotates a point in 3d space using spherical units.
     * The returned result is a point in 3d space represented by {@link IPoint3D}.
     * This will rotate the point around the y-axis.
     *
     * @param point the point to rotate.
     * @param unit  the spherical unit to rotate the point with.
     * @return the rotated point.
     */
    public static IPoint3D rotateY(IPoint3D point, SphericalUnit unit) {
        double x = point.getX().multiply(Math.cos(unit.phi()))
                - point.getZ().multiply(Math.sin(unit.phi()));
        double y = point.getY().get();
        double z = point.getX().multiply(Math.sin(unit.phi()))
                + point.getZ().multiply(Math.cos(unit.phi()));

        return Point.fromDouble(x, y, z);
    }

    /**
     * Rotates a point in 3d space using spherical units.
     * The returned result is a point in 3d space represented by {@link IPoint3D}.
     * This will rotate the point around the z-axis.
     *
     * @param point the point to rotate.
     * @param unit  the spherical unit to rotate the point with.
     * @return the rotated point.
     */
    public static IPoint3D rotateZ(IPoint3D point, SphericalUnit unit) {
        double x = point.getX().multiply(Math.cos(unit.theta()))
                - point.getY().multiply(Math.sin(unit.theta()));
        double y = point.getX().multiply(Math.sin(unit.theta()))
                + point.getY().multiply(Math.cos(unit.theta()));
        double z = point.getZ().get();

        return Point.fromDouble(x, y, z);
    }

    /**
     * Rotates a point in 3d space using spherical units.
     * The returned result is a point in 3d space represented by {@link IPoint3D}.
     * This will rotate the point around the x-axis, y-axis, and z-axis.
     *
     * @param point the point to rotate.
     * @param delta the delta values to rotate the point with.
     * @param unit  the spherical unit to rotate the point with.
     * @return the rotated point.
     */
    public static IPoint3D fullRotation(IPoint3D point, Delta delta, SphericalUnit unit) {
        double r = unit.radius() * Math.cos(unit.theta() + delta.theta()) * Math.cos(unit.phi() + delta.phi());
        double theta = Math.atan2(point.getX().get(), point.getZ().get()) + delta.theta();
        double phi = Math.atan2(Utilities.magnitudeOf(point.getX().get(), point.getZ().get()), point.getY().get()) + delta.phi();

        double xRot = r * Math.sin(theta) * Math.cos(phi);
        double yRot = r * Math.cos(theta);
        double zRot = r * Math.sin(theta) * Math.sin(phi);

        return Point.fromDouble(xRot, yRot, zRot);
    }

    /**
     * Rotates a point in 2d space using spherical units.
     * The returned result is a point in 2d space represented by {@link IPoint2D}.
     * This will rotate the point around the x-axis.
     *
     * @param point the point to rotate.
     * @param unit  the polar unit to rotate the point with.
     * @return the rotated point.
     */
    public static IPoint2D rotateX(IPoint2D point, PolarUnit unit) {
        double x = point.getZ().multiply(Math.cos(unit.theta()))
                - point.getX().multiply(Math.sin(unit.theta()));
        double z = point.getZ().multiply(Math.sin(unit.theta()))
                + point.getX().multiply(Math.cos(unit.theta()));
        return Point.fromDouble(x, z);
    }

    /**
     * Rotates a point in 2d space using spherical units.
     * The returned result is a point in 2d space represented by {@link IPoint2D}.
     * This will rotate the point around the y-axis.
     *
     * @param point the point to rotate.
     * @param unit  the polar unit to rotate the point with.
     * @return the rotated point.
     */
    public static IPoint2D rotateZ(IPoint2D point, PolarUnit unit) {
        double x = point.getX().multiply(Math.cos(unit.theta()))
                - point.getZ().multiply(Math.sin(unit.theta()));
        double z = point.getX().multiply(Math.sin(unit.theta()))
                + point.getZ().multiply(Math.cos(unit.theta()));
        return Point.fromDouble(x, z);
    }

    /**
     * Rotates a point in 2d space using spherical units.
     * The returned result is a point in 2d space represented by {@link IPoint2D}.
     * This will rotate the point around the x-axis and z-axis.
     *
     * @param point the point to rotate.
     * @param unit  the polar unit to rotate the point with.
     * @return the rotated point.
     */
    public static IPoint2D fullRotation(IPoint2D point, SphericalUnit unit) {
        double x = point.getX().multiply(Math.cos(unit.theta()))
                - point.getZ().multiply(Math.sin(unit.theta()));
        double z = point.getX().multiply(Math.sin(unit.theta()))
                + point.getZ().multiply(Math.cos(unit.theta()));
        return Point.fromDouble(x, z);
    }

    /**
     * Rotates a point in 3d space using a quaternion.
     * The returned result is a point in 3d space represented by {@link IPoint3D}.
     *
     * @param point      the point to rotate.
     * @param quaternion the quaternion to rotate the point with.
     * @return the rotated point.
     */
    public static IPoint3D rotate(IPoint3D point, IQuaternion quaternion) {
        IQuaternion pQuat = new Quaternion(0.0, point.getX().get(), point.getY().get(), point.getZ().get());

        IQuaternion conjugate = quaternion.conjugate();

        IQuaternion w = conjugate.multiply(pQuat).multiply(quaternion);

        return Point.fromDouble(w.getX(), w.getY(), w.getZ());
    }

    /**
     * Rotates a point in 2d space using a quaternion.
     * The returned result is a point in 2d space represented by {@link IPoint2D}.
     *
     * @param point      the point to rotate.
     * @param quaternion the quaternion to rotate the point with.
     * @return the rotated point.
     */
    public static IPoint2D rotate(IPoint2D point, IQuaternion quaternion) {
        IQuaternion pQuat = new Quaternion(0.0, point.getX().get(), 0.0, point.getZ().get());

        IQuaternion conjugate = quaternion.conjugate();

        IQuaternion w = conjugate.multiply(pQuat).multiply(quaternion);

        return Point.fromDouble(w.getX(), w.getZ());
    }
}
