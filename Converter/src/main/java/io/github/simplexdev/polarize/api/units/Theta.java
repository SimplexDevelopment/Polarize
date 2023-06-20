package io.github.simplexdev.polarize.api.units;

/**
 * This is a functional interface representing a mathematical angle Theta, which returns the zenith value.
 */
@FunctionalInterface
public interface Theta {
    /**
     * This method returns a double value representing the zenith angle.
     *
     * @return the zenith angle as a double.
     */
    double getZenith();

    static Theta from(double x, double z) {
        return () -> Math.atan2(x, z);
    }

    static Theta of(double zenithAngle) {
        return () -> zenithAngle;
    }
}
