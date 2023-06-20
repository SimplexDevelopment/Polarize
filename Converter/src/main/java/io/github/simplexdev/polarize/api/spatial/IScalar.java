package io.github.simplexdev.polarize.api.spatial;

import io.github.simplexdev.polarize.api.rotation.IQuaternion;

/**
 * Represents a scalar value.
 * This is similar to a Vector, but with only one dimension.
 * This is intended for use against polar-specific coordinates, and is not
 * compatible with cartesian coordinates.
 *
 * @see IVector
 */
public interface IScalar {
    /**
     * Returns the origin of the scalar.
     * This is the value that the scalar is relative to.
     *
     * @return The origin of the scalar.
     */
    double getOrigin();

    /**
     * Returns the magnitude of the scalar.
     * This is effectively the length of the scalar.
     *
     * @return The magnitude of the scalar.
     */
    double getMagnitude();

    /**
     * Adds a double value to this scalar and returns the result.
     *
     * @param add The value to add to this scalar.
     * @return The result of adding the given scalar value to this scalar.
     */
    IScalar add(double add);

    /**
     * Adds this scalar with the passed one.
     *
     * @param scalar The scalar to add to this scalar.
     * @return The result of adding the given scalar value to this scalar.
     */
    IScalar add(IScalar scalar);

    /**
     * Multiplies this scalar by the passed value and returns the result.
     *
     * @param multiply The value to multiply this scalar by.
     * @return The result of multiplying this scalar by the given scalar value.
     */
    IScalar multiply(double multiply);

    /**
     * Multiplies this scalar by the passed scalar and returns the result.
     *
     * @param scalar The scalar to multiply this scalar by.
     * @return The result of multiplying this scalar by the given scalar value.
     */
    IScalar multiply(IScalar scalar);

    /**
     * Multiplies this scalar by a quaternion and returns the result.
     *
     * @param quaternion The quaternion to multiply this scalar by.
     * @return The result of multiplying this scalar by the given quaternion.
     */
    IScalar multiply(IQuaternion quaternion);

    /**
     * Returns a normalized version of this scalar.
     *
     * @return A normalized version of this scalar.
     */
    IScalar normalize();

    /**
     * Returns the inverse of this scalar.
     *
     * @return The inverse of this scalar.
     * @throws ArithmeticException If this scalar is zero.
     */
    IScalar inverse() throws ArithmeticException;

    /**
     * Returns the negation of this scalar.
     *
     * @return The negation of this scalar.
     */
    IScalar negate();
}
