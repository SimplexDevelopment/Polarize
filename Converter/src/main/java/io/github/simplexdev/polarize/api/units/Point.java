package io.github.simplexdev.polarize.api.units;


import io.github.simplexdev.polarize.api.spatial.IPoint2D;
import io.github.simplexdev.polarize.api.spatial.IPoint3D;
import io.github.simplexdev.polarize.cartesian.Point2D;
import io.github.simplexdev.polarize.cartesian.Point3D;
import io.github.simplexdev.polarize.math.function.Integral;

import java.io.Serializable;
import java.util.function.DoubleUnaryOperator;

@FunctionalInterface
public interface Point extends Serializable {

    /**
     * Creates a 2d point from a given X and Z value.
     *
     * @param x The X value.
     * @param z The Z value.
     * @return The 2d point.
     */
    static IPoint2D fromXZ(X x, Z z) {
        return new Point2D(x, z);
    }

    /**
     * Creates a 3d point from a given X, Y, and Z value.
     *
     * @param x The X value.
     * @param y The Y value.
     * @param z The Z value.
     * @return The 3d point.
     */
    static IPoint3D fromXYZ(X x, Y y, Z z) {
        return new Point3D(x, y, z);
    }

    /**
     * Creates a 2d point from the given double values.
     *
     * @param x The X value.
     * @param z The Z value.
     * @return The 2d point.
     */
    static IPoint2D fromDouble(double x, double z) {
        return new Point2D(() -> x, () -> z);
    }

    /**
     * Creates a 3d point from the given double values.
     *
     * @param x The X value.
     * @param y The Y value.
     * @param z The Z value.
     * @return The 3d point.
     */
    static IPoint3D fromDouble(double x, double y, double z) {
        return new Point3D(() -> x, () -> y, () -> z);
    }

    @Override
    String toString();

    /**
     * Returns the numerical representation of the point.
     *
     * @return The value of the point.
     */
    double get();

    /**
     * Returns the distance between this point and the given point.
     *
     * @param point The point to compare to.
     * @return The distance between the two points.
     */
    default double distance(double point) {
        return Math.abs(this.get() - point);
    }

    /**
     * Returns the distance between this point and the given point.
     *
     * @param point The point to compare to.
     * @return The distance between the two points.
     */
    default double distance(Point point) {
        return this.distance(point.get());
    }

    /**
     * Adds the given point to this point.
     *
     * @param point The point to add.
     * @return The sum of the two points.
     */
    default double add(double point) {
        return this.get() + point;
    }

    /**
     * Adds the given point to this point.
     *
     * @param point The point to add.
     * @return The sum of the two points.
     */
    default double add(Point point) {
        return this.add(point.get());
    }

    /**
     * Subtracts the given point from this point.
     *
     * @param point The point to subtract.
     * @return The difference of the two points.
     */
    default double subtract(double point) {
        return this.get() - point;
    }

    /**
     * Subtracts the given point from this point.
     *
     * @param point The point to subtract.
     * @return The difference of the two points.
     */
    default double subtract(Point point) {
        return this.subtract(point.get());
    }

    /**
     * Multiplies this point by the given point.
     *
     * @param point The point to multiply by.
     * @return The product of the two points.
     */
    default double multiply(double point) {
        return this.get() * point;
    }

    /**
     * Multiplies this point by the given point.
     *
     * @param point The point to multiply by.
     * @return The product of the two points.
     */
    default double multiply(Point point) {
        return this.multiply(point.get());
    }

    /**
     * Divides this point by the given point.
     *
     * @param point The point to divide by.
     * @return The quotient of the two points.
     */
    default double divide(double point) {
        return this.get() / point;
    }

    /**
     * Divides this point by the given point.
     *
     * @param point The point to divide by.
     * @return The quotient of the two points.
     */
    default double divide(Point point) {
        return this.divide(point.get());
    }

    /**
     * Returns this point raised to the power of the given point.
     *
     * @param point The point to raise this point to.
     * @return The power of the two points.
     */
    default double power(double point) {
        return Math.pow(this.get(), point);
    }

    /**
     * Returns this point raised to the power of the given point.
     *
     * @param point The point to raise this point to.
     * @return The power of the two points.
     */
    default double power(Point point) {
        return this.power(point.get());
    }

    /**
     * Returns the integral of the given function from this point to the given point.
     *
     * @param point        The point to integrate to.
     * @param subIntervals The number of sub-intervals to use.
     * @param function     The function to integrate.
     * @return The integral of the function.
     */
    default double integ(double point, double subIntervals, DoubleUnaryOperator function) {
        return Integral.integrate(this.get(), point, subIntervals, function);
    }

    /**
     * Returns the integral of the given function from this point to the given point.
     *
     * @param point        The point to integrate to.
     * @param subIntervals The number of sub-intervals to use.
     * @param function     The function to integrate.
     * @return The integral of the function.
     */
    default double integ(Point point, double subIntervals, DoubleUnaryOperator function) {
        return this.integ(point.get(), subIntervals, function);
    }

    /**
     * Represents any value of X along the <u>X coordinate plane</u>.
     */
    @FunctionalInterface
    interface X extends Point {
        @Override
        double get();
    }

    /**
     * Represents any value of Y along the <u>Y coordinate plane</u>.
     */
    @FunctionalInterface
    interface Y extends Point {

        @Override
        double get();
    }

    /**
     * Represents any value of Z along the <u>Z coordinate plane</u>.
     */
    @FunctionalInterface
    interface Z extends Point {

        @Override
        double get();
    }
}
