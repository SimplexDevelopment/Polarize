package io.github.simplexdev.polarize.util;

import io.github.simplexdev.polarize.api.IPoint2D;
import io.github.simplexdev.polarize.api.IPoint3D;
import io.github.simplexdev.polarize.api.IQuaternion;
import io.github.simplexdev.polarize.math.Point2D;
import io.github.simplexdev.polarize.math.Point3D;
import io.github.simplexdev.polarize.math.Quaternion;
import io.github.simplexdev.polarize.polar.Delta;
import io.github.simplexdev.polarize.polar.SphericalUnit;

public class Rotator {
    private Rotator() {
        throw new AssertionError();
    }
    
    public static IPoint3D rotateX(IPoint3D point, SphericalUnit unit) {
        double x = point.getX();
        double y = point.getY() * Math.cos(unit.theta()) - point.getZ() * Math.sin(unit.theta());
        double z = point.getY() * Math.sin(unit.theta()) + point.getZ() * Math.cos(unit.theta());

        return new Point3D(x, y, z);
    }

    public static IPoint3D rotateY(IPoint3D point, SphericalUnit unit) {
        double x = point.getX() * Math.cos(unit.phi()) - point.getZ() * Math.sin(unit.phi());
        double y = point.getY();
        double z = point.getX() * Math.sin(unit.phi()) + point.getZ() * Math.cos(unit.phi());

        return new Point3D(x, y, z);
    }

    public static IPoint3D rotateZ(IPoint3D point, SphericalUnit unit) {
        double x = point.getX() * Math.cos(unit.theta()) - point.getY() * Math.sin(unit.theta());
        double y = point.getX() * Math.sin(unit.theta()) + point.getY() * Math.cos(unit.theta());
        double z = point.getZ();

        return new Point3D(x, y, z);
    }

    public static IPoint3D fullRotation(IPoint3D point, Delta delta, SphericalUnit unit) {
        double r = unit.radius() * Math.cos(unit.theta() + delta.theta()) * Math.cos(unit.phi() + delta.phi());
        double theta = Math.atan2(point.getX(), point.getZ()) + delta.theta();
        double phi = Math.atan2(Utilities.magnitudeOf(point.getX(), point.getZ()), point.getY()) + delta.phi();

        double xRot = r * Math.sin(theta) * Math.cos(phi);
        double yRot = r * Math.cos(theta);
        double zRot = r * Math.sin(theta) * Math.sin(phi);

        return new Point3D(xRot, yRot, zRot);
    }

    public static IPoint2D rotateX(IPoint2D point, SphericalUnit unit) {
        double x = point.getZ() * Math.cos(unit.theta()) - point.getX() * Math.sin(unit.theta());
        double z = point.getZ() * Math.sin(unit.theta()) + point.getX() * Math.cos(unit.theta());
        return new Point2D(x, z);
    }

    public static IPoint2D rotateZ(IPoint2D point, SphericalUnit unit) {
        double x = point.getX() * Math.cos(unit.theta()) - point.getZ() * Math.sin(unit.theta());
        double z = point.getX() * Math.sin(unit.theta()) + point.getZ() * Math.cos(unit.theta());
        return new Point2D(x, z);
    }

    public static IPoint2D fullRotation(IPoint2D point, SphericalUnit unit) {
        double x = point.getX() * Math.cos(unit.theta()) - point.getZ() * Math.sin(unit.theta());
        double z = point.getX() * Math.sin(unit.theta()) + point.getZ() * Math.cos(unit.theta());
        return new Point2D(x, z);
    }

    public static IPoint3D rotate(IPoint3D point, IQuaternion quaternion) {
        IQuaternion pQuat = new Quaternion(0.0, point.getX(), point.getY(), point.getZ());

        IQuaternion conjugate = quaternion.conjugate();

        IQuaternion w = conjugate.multiply(pQuat).multiply(quaternion);

        return new Point3D(w.getX(), w.getY(), w.getZ());
    }

    public static IPoint2D rotate(IPoint2D point, IQuaternion quaternion) {
        IQuaternion pQuat = new Quaternion(0.0, point.getX(), 0.0, point.getZ());

        IQuaternion conjugate = quaternion.conjugate();

        IQuaternion w = conjugate.multiply(pQuat).multiply(quaternion);

        return new Point2D(w.getX(), w.getZ());
    }
}
