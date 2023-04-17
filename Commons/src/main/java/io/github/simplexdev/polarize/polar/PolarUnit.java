package io.github.simplexdev.polarize.polar;

import io.github.simplexdev.polarize.api.units.Radius;
import io.github.simplexdev.polarize.api.units.Theta;

/**
 * Represents a unit in polar coordinates.
 */
public class PolarUnit {
    private final Radius radius;
    private final Theta theta;

    /**
     * Creates a new PolarUnit with the given radius and angle theta.
     *
     * @param radius the radius of the unit.
     * @param theta  the angle theta of the unit.
     */
    public PolarUnit(double radius, double theta) {
        this.radius = () -> radius;
        this.theta = () -> theta;
    }

    /**
     * Returns the radius object of this unit.
     * <p>
     * This is an object which represents the variable r, which
     * represents the radius of the unit circle in 2d space.
     *
     * @return the radius object of this unit.
     */
    public Radius getRadius() {
        return radius;
    }

    /**
     * Returns the angle object theta of this unit.
     * <p>
     * This is an object which represents the variable theta, which
     * represents an angle on the unit circle in 2d space.
     *
     * @return the angle object theta of this unit.
     */
    public Theta getTheta() {
        return theta;
    }

    /**
     * Returns the radius of this unit.
     * This is formatted as a double for quick access.
     *
     * @return the radius of this unit.
     */
    public double radius() {
        return radius.length();
    }

    /**
     * Returns the angle theta of this unit.
     * This is formatted as a double for quick access.
     *
     * @return the angle theta of this unit.
     */
    public double theta() {
        return theta.getZenith();
    }

    /**
     * Returns the adjacent side of the triangle formed by this unit in 2d space.
     * <p>
     * The adjacent side is the side adjacent the angle theta.
     *
     * @return the adjacent side of the triangle formed by this unit in 2d space.
     */
    public double adjacent() {
        return radius() * Math.cos(theta());
    }

    /**
     * Returns the opposite side of the triangle formed by this unit in 2d space.
     * <p>
     * The opposite side is the side opposite the angle theta.
     *
     * @return the opposite side of the triangle formed by this unit in 2d space.
     */
    public double opposite() {
        return radius() * Math.sin(theta());
    }
}
