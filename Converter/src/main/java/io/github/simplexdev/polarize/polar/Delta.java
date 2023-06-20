package io.github.simplexdev.polarize.polar;

import io.github.simplexdev.polarize.api.units.Phi;
import io.github.simplexdev.polarize.api.units.Theta;

/**
 * Represents a modifier that can be used in rotations of polar and spherical units.
 * <p>
 * Typically, these are used in full rotations along the unit circle / unit sphere,
 * but can be used in any degree of rotation.
 */
public class Delta {
    private final Theta theta;
    private final Phi phi;

    /**
     * Creates a new Delta with the given theta and phi modifiers.
     *
     * @param theta the theta modifier.
     * @param phi   the phi modifier.
     */
    public Delta(double theta, double phi) {
        this.theta = () -> theta;
        this.phi = () -> phi;
    }

    /**
     * Returns an object that represents the theta modifier.
     *
     * @return an object that represents the theta modifier.
     * @see Theta
     */
    public Theta getTheta() {
        return theta;
    }

    /**
     * Returns an object that represents the phi modifier.
     *
     * @return an object that represents the phi modifier.
     * @see Phi
     */
    public Phi getPhi() {
        return phi;
    }

    /**
     * Returns the theta modifier.
     * This is a double value for easier access.
     *
     * @return the theta modifier.
     */
    public double theta() {
        return theta.getZenith();
    }

    /**
     * Returns the phi modifier.
     * This is a double value for easier access.
     *
     * @return the phi modifier.
     */
    public double phi() {
        return phi.getAzimuth();
    }
}
