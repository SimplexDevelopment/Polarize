package io.github.simplexdev.polarize.polar;

import io.github.simplexdev.polarize.api.units.Phi;
import io.github.simplexdev.polarize.api.units.Radius;
import io.github.simplexdev.polarize.api.units.Theta;
import io.github.simplexdev.polarize.cartesian.CartesianUnit;
import io.github.simplexdev.polarize.util.Polarizer;

/**
 * A class that represents a spherical unit.
 */
public class SphericalUnit {
    private final Radius radius;
    private final Theta theta;
    private final Phi phi;

    /**
     * Creates a new SphericalUnit with the given radius, theta, and phi.
     *
     * @param radius The radius of the unit.
     * @param theta  The theta of the unit.
     * @param phi    The phi of the unit.
     */
    public SphericalUnit(double radius, double theta, double phi) {
        this.radius = () -> radius;
        this.theta = () -> theta;
        this.phi = () -> phi;
    }

    /**
     * Returns the radius object of the unit.
     * <p>
     * This is an object which represents the variable r, which
     * represents the radius of the unit sphere in 3d space.
     *
     * @return The radius object of the unit.
     * @see Radius
     */
    public Radius getRadius() {
        return this.radius;
    }

    /**
     * Returns the theta object of the unit.
     * <p>
     * This is an object which represents the variable theta, which
     * represents the angle of the unit sphere in 3d space.
     *
     * @return The theta object of the unit.
     * @see Theta
     */
    public Theta getTheta() {
        return this.theta;
    }

    /**
     * Returns the phi object of the unit.
     * <p>
     * This is an object which represents the variable phi, which
     * represents the angle of the unit sphere in 3d space.
     *
     * @return The phi object of the unit.
     * @see Phi
     */
    public Phi getPhi() {
        return this.phi;
    }

    /**
     * Returns the radius of the unit.
     * This is formatted as a double for quick access.
     *
     * @return The radius of the unit.
     */
    public double radius() {
        return this.radius.length();
    }

    /**
     * Returns the theta of the unit.
     * This is formatted as a double for quick access.
     *
     * @return The theta of the unit.
     */
    public double theta() {
        return this.theta.getZenith();
    }

    /**
     * Returns the phi of the unit.
     * This is formatted as a double for quick access.
     *
     * @return The phi of the unit.
     */
    public double phi() {
        return this.phi.getAzimuth();
    }

    /**
     * Returns the adjacent side of the unit.
     * <p>
     * This is calculated from a translation to Cartesian units,
     * and returning the X value.
     *
     * @return The adjacent side of the unit.
     */
    public double adjacent() {
        CartesianUnit unit = Polarizer.toCartesianUnit(this);
        return unit.getPoint3D().getX();
    }

    /**
     * Returns the opposite side of the unit.
     * <p>
     * This is calculated from a translation to Cartesian units,
     * and returning the Z value.
     *
     * @return The opposite side of the unit.
     */
    public double opposite() {
        CartesianUnit unit = Polarizer.toCartesianUnit(this);
        return unit.getPoint3D().getZ();
    }
}
