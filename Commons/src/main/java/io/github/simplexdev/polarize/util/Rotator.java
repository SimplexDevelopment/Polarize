package io.github.simplexdev.polarize.util;

import io.github.simplexdev.polarize.api.IPoint2D;
import io.github.simplexdev.polarize.api.IPoint3D;
import io.github.simplexdev.polarize.api.IQuaternion;
import io.github.simplexdev.polarize.math.Point2D;
import io.github.simplexdev.polarize.math.Point3D;
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
        double x = point.getX();
        double y = point.getY() * Math.cos(unit.theta()) - point.getZ() * Math.sin(unit.theta());
        double z = point.getY() * Math.sin(unit.theta()) + point.getZ() * Math.cos(unit.theta());

        return new Point3D(x, y, z);
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
        double x = point.getX() * Math.cos(unit.phi()) - point.getZ() * Math.sin(unit.phi());
        double y = point.getY();
        double z = point.getX() * Math.sin(unit.phi()) + point.getZ() * Math.cos(unit.phi());

        return new Point3D(x, y, z);
    }

    /**
     * Rotates a point in 3d space using spherical units.
     * The returned result is a point in 3d space represented by {@link IPoint3D}.
     * This will rotate the point around the z-axis.
     *
     * @param point the point to rotate.
     * @param unit the spherical unit to rotate the point with.
     * @return the rotated point.
     */
    public static IPoint3D rotateZ(IPoint3D point, SphericalUnit unit) {
        double x = point.getX() * Math.cos(unit.theta()) - point.getY() * Math.sin(unit.theta());
        double y = point.getX() * Math.sin(unit.theta()) + point.getY() * Math.cos(unit.theta());
        double z = point.getZ();

        return new Point3D(x, y, z);
    }

    /**
     * Rotates a point in 3d space using spherical units.
     * The returned result is a point in 3d space represented by {@link IPoint3D}.
     * This will rotate the point around the x-axis, y-axis, and z-axis.
     *
     * @param point the point to rotate.
     * @param delta the delta values to rotate the point with.
     * @param unit the spherical unit to rotate the point with.
     * @return the rotated point.
     */
    public static IPoint3D fullRotation(IPoint3D point, Delta delta, SphericalUnit unit) {
        double r = unit.radius() * Math.cos(unit.theta() + delta.theta()) * Math.cos(unit.phi() + delta.phi());
        double theta = Math.atan2(point.getX(), point.getZ()) + delta.theta();
        double phi = Math.atan2(Utilities.magnitudeOf(point.getX(), point.getZ()), point.getY()) + delta.phi();

        double xRot = r * Math.sin(theta) * Math.cos(phi);
        double yRot = r * Math.cos(theta);
        double zRot = r * Math.sin(theta) * Math.sin(phi);

        return new Point3D(xRot, yRot, zRot);
    }

    /**
     * Rotates a point in 2d space using spherical units.
     * The returned result is a point in 2d space represented by {@link IPoint2D}.
     * This will rotate the point around the x-axis.
     *
     * @param point the point to rotate.
     * @param unit the polar unit to rotate the point with.
     * @return the rotated point.
     */
    public static IPoint2D rotateX(IPoint2D point, PolarUnit unit) {
        double x = point.getZ() * Math.cos(unit.theta()) - point.getX() * Math.sin(unit.theta());
        double z = point.getZ() * Math.sin(unit.theta()) + point.getX() * Math.cos(unit.theta());
        return new Point2D(x, z);
    }

    /**
     * Rotates a point in 2d space using spherical units.
     * The returned result is a point in 2d space represented by {@link IPoint2D}.
     * This will rotate the point around the y-axis.
     *
     * @param point the point to rotate.
     * @param unit the polar unit to rotate the point with.
     * @return the rotated point.
     */
    public static IPoint2D rotateZ(IPoint2D point, PolarUnit unit) {
        double x = point.getX() * Math.cos(unit.theta()) - point.getZ() * Math.sin(unit.theta());
        double z = point.getX() * Math.sin(unit.theta()) + point.getZ() * Math.cos(unit.theta());
        return new Point2D(x, z);
    }

    /**
     * Rotates a point in 2d space using spherical units.
     * The returned result is a point in 2d space represented by {@link IPoint2D}.
     * This will rotate the point around the x-axis and z-axis.
     *
     * @param point the point to rotate.
     * @param unit the polar unit to rotate the point with.
     * @return the rotated point.
     */
    public static IPoint2D fullRotation(IPoint2D point, SphericalUnit unit) {
        double x = point.getX() * Math.cos(unit.theta()) - point.getZ() * Math.sin(unit.theta());
        double z = point.getX() * Math.sin(unit.theta()) + point.getZ() * Math.cos(unit.theta());
        return new Point2D(x, z);
    }

    /**
     * Rotates a point in 3d space using a quaternion.
     * The returned result is a point in 3d space represented by {@link IPoint3D}.
     *
     * @param point the point to rotate.
     * @param quaternion the quaternion to rotate the point with.
     * @return the rotated point.
     */
    public static IPoint3D rotate(IPoint3D point, IQuaternion quaternion) {
        IQuaternion pQuat = new Quaternion(0.0, point.getX(), point.getY(), point.getZ());

        IQuaternion conjugate = quaternion.conjugate();

        IQuaternion w = conjugate.multiply(pQuat).multiply(quaternion);

        return new Point3D(w.getX(), w.getY(), w.getZ());
    }

    /**
     * Rotates a point in 2d space using a quaternion.
     * The returned result is a point in 2d space represented by {@link IPoint2D}.
     *
     * @param point the point to rotate.
     * @param quaternion the quaternion to rotate the point with.
     * @return the rotated point.
     */
    public static IPoint2D rotate(IPoint2D point, IQuaternion quaternion) {
        IQuaternion pQuat = new Quaternion(0.0, point.getX(), 0.0, point.getZ());

        IQuaternion conjugate = quaternion.conjugate();

        IQuaternion w = conjugate.multiply(pQuat).multiply(quaternion);

        return new Point2D(w.getX(), w.getZ());
    }
}
