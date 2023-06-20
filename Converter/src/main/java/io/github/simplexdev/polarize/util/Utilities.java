package io.github.simplexdev.polarize.util;

public class Utilities {
    /**
     * The value of pi divided by 4.
     * This represents 45 degrees in radians.
     */
    public static final double RADIAN_45 = Math.PI / 4;
    /**
     * The value of pi divided by 2.
     * This represents 90 degrees in radians.
     */
    public static final double RADIAN_90 = Math.PI / 2;
    /**
     * The value of pi.
     * This represents 180 degrees in radians.
     */
    public static final double RADIAN_180 = Math.PI;
    /**
     * The value of pi multiplied by 1.5.
     * This represents 270 degrees in radians.
     */
    public static final double RADIAN_270 = Math.PI * 1.5;
    /**
     * The value of pi multiplied by 2.
     * This represents 360 degrees in radians.
     */
    public static final double RADIAN_360 = Math.PI * 2;

    private Utilities() {
        throw new AssertionError();
    }

    /**
     * Calculates the magnitude of a vector in 2D Cartesian coordinate system.
     *
     * @param x the x-coordinate of the vector
     * @param z the z-coordinate of the vector
     * @return the magnitude of the vector
     */
    public static double magnitudeOf(double x, double z) {
        return Math.sqrt(x * x + z * z);
    }

    /**
     * Calculates the magnitude of a vector in 3D Cartesian coordinate system.
     *
     * @param x the x-coordinate of the vector
     * @param y the y-coordinate of the vector
     * @param z the z-coordinate of the vector
     * @return the magnitude of the vector
     */
    public static double magnitudeOf(double x, double y, double z) {
        return Math.sqrt(x * x + y * y + z * z);
    }
}
