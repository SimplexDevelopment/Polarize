package io.github.simplexdev.polarize.util;

import io.github.simplexdev.polarize.api.rotation.IAxisAngle;
import io.github.simplexdev.polarize.api.rotation.IQuaternion;
import io.github.simplexdev.polarize.api.spatial.IPoint2D;
import io.github.simplexdev.polarize.api.spatial.IPoint3D;
import io.github.simplexdev.polarize.api.spatial.IScalar;
import io.github.simplexdev.polarize.api.spatial.IVector;
import io.github.simplexdev.polarize.api.units.Phi;
import io.github.simplexdev.polarize.api.units.Radius;
import io.github.simplexdev.polarize.api.units.Theta;
import io.github.simplexdev.polarize.cartesian.CartesianUnit;
import io.github.simplexdev.polarize.math.AxisAngle;
import io.github.simplexdev.polarize.math.Quaternion;
import io.github.simplexdev.polarize.polar.PolarUnit;
import io.github.simplexdev.polarize.polar.SphericalUnit;

/**
 * This class provides static methods for converting between different polar coordinate systems and their Cartesian equivalents.
 * It includes methods for converting to and from polar coordinates in 2D and 3D, as well as to and from spherical coordinates.
 */
public class Polarizer {
    private Polarizer() {
        throw new AssertionError();
    }

    /**
     * Converts a {@link PolarUnit} to a {@link CartesianUnit}.
     * This method takes a PolarUnit and converts it to a corresponding CartesianUnit by computing its x and z values.
     * The x and z values are computed using the radius and theta angles of the input PolarUnit, and assuming that the y
     * coordinate of the resulting CartesianUnit is zero.
     *
     * @param unit The input PolarUnit to convert to a CartesianUnit.
     * @return A new CartesianUnit instance generated from the input PolarUnit.
     * @see <a href="https://en.wikipedia.org/wiki/Polar_coordinate_system">Polar coordinate system</a>
     * @see <a href="https://en.wikipedia.org/wiki/Cartesian_coordinate_system">Cartesian coordinate system</a>
     */
    public static CartesianUnit toCartesianUnit(PolarUnit unit) {
        double x = unit.radius() * Math.sin(unit.theta());
        double z = unit.radius() * Math.cos(unit.theta());
        return new CartesianUnit(x, 0, z);
    }

    /**
     * Converts a {@link IScalar} and a {@link Theta} instance to a {@link CartesianUnit}.
     * This method takes a scalar magnitude and a {@link Theta} instance and computes the corresponding x and z values
     * for the resulting CartesianUnit, with a y coordinate of zero. The x and z values are computed using the scalar
     * magnitude and the zenith angle of the input Theta instance.
     *
     * @param scalar The scalar magnitude of the input.
     * @param theta  The input Theta instance containing the zenith angle.
     * @return A new CartesianUnit instance generated from the input scalar and theta values.
     * @see <a href="https://en.wikipedia.org/wiki/Spherical_coordinate_system">Spherical coordinate system</a>
     * @see <a href="https://en.wikipedia.org/wiki/Cartesian_coordinate_system">Cartesian coordinate system</a>
     */
    public static CartesianUnit toCartesianUnit(IScalar scalar, Theta theta) {
        double x = scalar.getMagnitude() * Math.sin(theta.getZenith());
        double z = scalar.getMagnitude() * Math.cos(theta.getZenith());
        return new CartesianUnit(x, 0, z);
    }

    /**
     * Converts a radius and a theta value to a {@link CartesianUnit}.
     * This method takes a radius value and a theta value and computes the corresponding x and z values for the resulting
     * CartesianUnit, with a y coordinate of zero. The x and z values are computed using the radius value and the input theta
     * value.
     *
     * @param radius The radius value of the input.
     * @param theta  The input theta value containing the zenith angle in radians.
     * @return A new CartesianUnit instance generated from the input radius and theta values.
     * @see <a href="https://en.wikipedia.org/wiki/Spherical_coordinate_system">Spherical coordinate system</a>
     * @see <a href="https://en.wikipedia.org/wiki/Cartesian_coordinate_system">Cartesian coordinate system</a>
     */
    public static CartesianUnit toCartesianUnit(double radius, double theta) {
        double x = radius * Math.sin(theta);
        double z = radius * Math.cos(theta);
        return new CartesianUnit(x, 0, z);
    }

    /**
     * Converts a {@link SphericalUnit} to a {@link CartesianUnit}.
     * This method takes a {@link SphericalUnit} object and computes the corresponding x, y, and z values for the resulting
     * CartesianUnit using the input's radius, theta, and phi values. The x, y, and z values are computed using the sine and
     * cosine trigonometric functions of the input's theta and phi values.
     *
     * @param unit The {@link SphericalUnit} instance to be converted to Cartesian coordinates.
     * @return A new {@link CartesianUnit} instance generated from the input {@link SphericalUnit} object.
     * @see <a href="https://en.wikipedia.org/wiki/Spherical_coordinate_system">Spherical coordinate system</a>
     * @see <a href="https://en.wikipedia.org/wiki/Cartesian_coordinate_system">Cartesian coordinate system</a>
     */
    public static CartesianUnit toCartesianUnit(SphericalUnit unit) {
        double x = unit.radius() * Math.sin(unit.theta()) * Math.cos(unit.phi());
        double y = unit.radius() * Math.cos(unit.theta());
        double z = unit.radius() * Math.sin(unit.theta()) * Math.sin(unit.phi());
        return new CartesianUnit(x, y, z);
    }

    /**
     * Converts a scalar with theta and phi coordinates to a CartesianUnit.
     *
     * @param scalar the scalar value of the vector
     * @param theta  the theta coordinate of the vector
     * @param phi    the phi coordinate of the vector
     * @return the CartesianUnit representation of the vector
     */
    public static CartesianUnit toCartesianUnit(IScalar scalar, Theta theta, Phi phi) {
        double x = scalar.getMagnitude() * Math.sin(theta.getZenith()) * Math.cos(phi.getAzimuth());
        double y = scalar.getMagnitude() * Math.cos(theta.getZenith());
        double z = scalar.getMagnitude() * Math.sin(theta.getZenith()) * Math.sin(phi.getAzimuth());
        return new CartesianUnit(x, y, z);
    }

    /**
     * Converts a spherical coordinate (radius, theta, phi) to Cartesian coordinates (x, y, z).
     * <p>
     * This method uses the following formula:
     * <pre>
     *         {@code radius = sqrt(x^2 + y^2 + z^2)}
     *         {@code theta = acos(y / radius)}
     *         {@code phi = atan2(z, x)}
     *         {@code x = radius * sin(theta) * cos(phi)}
     *         {@code y = radius * cos(theta)}
     *         {@code z = radius * sin(theta) * sin(phi)}
     * </pre>
     *
     * @param radius the radius of the spherical coordinate
     * @param theta  the theta angle in radians of the spherical coordinate
     * @param phi    the phi angle in radians of the spherical coordinate
     * @return the corresponding CartesianUnit
     */
    public static CartesianUnit toCartesianUnit(double radius, double theta, double phi) {
        double x = radius * Math.sin(theta) * Math.cos(phi);
        double y = radius * Math.cos(theta);
        double z = radius * Math.sin(theta) * Math.sin(phi);
        return new CartesianUnit(x, y, z);
    }

    /**
     * Converts a {@link CartesianUnit} to a {@link PolarUnit}.
     * This method uses the same formula as {@link #toPolarUnit(double, double)}.
     *
     * @param unit the CartesianUnit to be converted
     * @return a PolarUnit representing the same point as the input CartesianUnit
     */
    public static PolarUnit toPolarUnit(CartesianUnit unit) {
        double radius = Math.sqrt(unit.getPoint2D().getX().get() * unit.getPoint2D().getX().get() + unit.getPoint2D().getZ().get() * unit.getPoint2D().getZ().get());
        double theta = Math.atan2(unit.getPoint2D().getX().get(), unit.getPoint2D().getZ().get());
        return new PolarUnit(radius, theta);
    }

    /**
     * Converts the given {@link CartesianUnit} to a {@link PolarUnit}.
     * This method uses the same formula as {@link #toPolarUnit(double, double)},
     * with the exception that the radius is computed using the given {@link IVector}
     * instead of the {@link IPoint2D}'s x and z coordinates.
     *
     * @param unit   the {@link CartesianUnit} to convert
     * @param vector the {@link IVector} representing the radius of the resulting {@link PolarUnit}
     * @return a {@link PolarUnit} representing the same point as the given {@link CartesianUnit}
     */
    public static PolarUnit toPolarUnit(CartesianUnit unit, IVector vector) {
        double radius = vector.length();
        double theta = Math.atan2(unit.getPoint2D().getX().get(), unit.getPoint2D().getZ().get());
        return new PolarUnit(radius, theta);
    }

    /**
     * Returns a {@link PolarUnit} representing the polar coordinates of the given 2D point in relation to the given vector.
     * <p>
     * This method uses the same formula as {@link #toPolarUnit(double, double)}.
     *
     * @param point  the point to convert to polar coordinates
     * @param vector the vector used as a reference for the polar coordinates
     * @return a PolarUnit representing the polar coordinates of the given point
     */
    public static PolarUnit toPolarUnit(IPoint2D point, IVector vector) {
        double radius = vector.length();
        double theta = Math.atan2(point.getX().get(), point.getZ().get());
        return new PolarUnit(radius, theta);
    }

    /**
     * Converts a 2D point in Cartesian coordinates to a polar unit.
     * <p>
     * The conversion is based on the following formula:
     * <pre>
     *          {@code radius = sqrt(x^2 + z^2)}
     *          {@code theta = atan2(x, z)}
     *             where:
     *         x = {@link IPoint2D#getX()}
     *         z = {@link IPoint2D#getZ()}
     * </pre>
     *
     * @param x the x-coordinate of the point
     * @param z the z-coordinate of the point
     * @return a {@link PolarUnit} representing the polar coordinates of the point
     */
    public static PolarUnit toPolarUnit(double x, double z) {
        double radius = Math.sqrt(x * x + z * z);
        double theta = Math.atan2(x, z);
        return new PolarUnit(radius, theta);
    }

    /**
     * Converts a {@link CartesianUnit} to a {@link SphericalUnit}.
     * <p>
     * The radius is calculated by creating a new vector based on the CartesianUnit's
     * x, y, and z coordinates, then using {@link IVector#length()} to acquire the {@link IScalar}.
     * <p>
     * The angles are then calculated from {@link IScalar#getMagnitude()}.
     * <p>
     * This method uses the same formula as {@link #toSphericalUnit(double, double, double)}.
     *
     * @param unit the CartesianUnit to be converted.
     * @return the SphericalUnit representing the same point as the input CartesianUnit.
     */
    public static SphericalUnit toSphericalUnit(CartesianUnit unit) {
        double radius = Math.sqrt(unit.getPoint3D().getX().get()
                * unit.getPoint3D().getX().get()
                + unit.getPoint3D().getY().get()
                * unit.getPoint3D().getY().get()
                + unit.getPoint3D().getZ().get()
                * unit.getPoint3D().getZ().get());
        double theta = Math.acos(unit.getPoint3D().getY().get()
                / radius);
        double phi = Math.atan2(unit.getPoint3D().getX().get(),
                unit.getPoint3D().getZ().get());
        return new SphericalUnit(radius, theta, phi);
    }

    /**
     * Converts the specified {@link IPoint3D} to a {@link SphericalUnit} using the specified {@link IVector}.
     * <p>
     * This method uses the same formula as {@link #toSphericalUnit(double, double, double)}
     *
     * @param point  the point to convert to a spherical unit
     * @param vector the vector to use for the conversion
     * @return a new {@link SphericalUnit} representing the point in spherical coordinates
     */
    public static SphericalUnit toSphericalUnit(IPoint3D point, IVector vector) {
        double radius = vector.length();
        double theta = Math.acos(point.getY().get() / radius);
        double phi = Math.atan2(point.getX().get(), point.getZ().get());
        return new SphericalUnit(radius, theta, phi);
    }

    /**
     * Converts the given Cartesian coordinates (x, y, z) to spherical coordinates (radius, theta, phi).
     * <p>
     * The conversion is based on the following formula:
     * <pre>
     *         {@code radius = sqrt(x^2 + y^2 + z^2)}
     *         {@code theta = acos(y / radius)}
     *         {@code phi = atan2(x, z)}
     *             where:
     *         {@code radius} is the {@link Radius} (scalar) of the spherical coordinate
     *         {@code theta} is the {@link Theta} angle (zenith) in radians of the spherical coordinate
     *         {@code phi} is the {@link Phi} angle (azimuth) in radians of the spherical coordinate
     * </pre>
     * <p>
     * The resulting spherical coordinates are returned as a new {@link SphericalUnit}.
     * <p>
     * The returned {@link SphericalUnit} is guaranteed to reflect the same coordinates as the input.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param z the z-coordinate
     * @return a new {@link SphericalUnit} representing the converted spherical coordinates
     */
    public static SphericalUnit toSphericalUnit(double x, double y, double z) {
        double radius = Math.sqrt(x * x + y * y + z * z);
        double theta = Math.acos(y / radius);
        double phi = Math.atan2(x, z);
        return new SphericalUnit(radius, theta, phi);
    }

    /**
     * Converts the given {@link IQuaternion} to an {@link IAxisAngle}.
     * <p>
     * The conversion is based on the following formula:
     * <pre>
     *          {@code r = (x * sin(angle/2), y * sin(angle/2), z * sin(angle/2), cos(angle/2))}
     *              where:
     *         sin = {@link Math#sin(double)},
     *         cos = {@link Math#cos(double)},
     *         x = {@link IQuaternion#getX()},
     *         y = {@link IQuaternion#getY()},
     *         z = {@link IQuaternion#getZ()}
     *         angle = {@link IQuaternion#getW()}
     *         r = {@link IAxisAngle}
     * </pre>
     *
     * @param quaternion the {@link IQuaternion} to convert
     * @return a new {@link IAxisAngle} representing the converted {@link IQuaternion}
     */
    public static IAxisAngle toAxisAngle(IQuaternion quaternion) {
        double angle = 2 * Math.acos(quaternion.getW());
        double s = Math.sqrt(1 - quaternion.getW() * quaternion.getW());

        double x, y, z;

        if (s < 0.001) {
            x = quaternion.getX();
            y = quaternion.getY();
            z = quaternion.getZ();
        } else {
            x = quaternion.getX() / s;
            y = quaternion.getY() / s;
            z = quaternion.getZ() / s;
        }
        return new AxisAngle(x, y, z, () -> angle);
    }

    /**
     * Converts the given {@link IAxisAngle} to a {@link IQuaternion}.
     * <p>
     * The conversion is based on the following formula:
     * <pre>
     *          {@code q = (x * sin(angle / 2), y * sin(angle / 2), z * sin(angle / 2), cos(angle / 2))}
     *              where:
     *         sin = {@link Math#sin(double)}
     *         cos = {@link Math#cos(double)}
     *         angle = {@link Theta#getZenith()}
     *         x = {@link IAxisAngle#getX()}
     *         y = {@link IAxisAngle#getY()}
     *         z = {@link IAxisAngle#getZ()}
     *         q = the resulting quaternion.
     * </pre>
     *
     * @param axisAngle the {@link IAxisAngle} to convert
     * @return a {@link IQuaternion} representing the same rotation as the given {@link IAxisAngle}
     */
    public IQuaternion toQuaternion(IAxisAngle axisAngle) {
        double angle = axisAngle.getAngle().getZenith();
        double x = axisAngle.getX();
        double y = axisAngle.getY();
        double z = axisAngle.getZ();
        double w = Math.cos(angle / 2);
        double s = Math.sin(angle / 2);
        return new Quaternion(x * s, y * s, z * s, w);
    }
}
