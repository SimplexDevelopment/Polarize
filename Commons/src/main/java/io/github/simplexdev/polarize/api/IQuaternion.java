package io.github.simplexdev.polarize.api;

/**
 * Represents the rotation of an object in 3D space.
 */
public interface IQuaternion {
    /**
     * Adds a fixed length to this quaternion.
     *
     * @param add The amount to add.
     * @return The result of the addition.
     */
    IQuaternion add(double add);

    /**
     * Adds this quaternion to another quaternion.
     *
     * @param quaternion The quaternion to add.
     * @return The result of the addition.
     */
    IQuaternion add(IQuaternion quaternion);

    /**
     * Multiplies this quaternion by a fixed length.
     *
     * @param multiply The scalar to multiply by.
     * @return The result of the multiplication.
     */
    IQuaternion multiply(double multiply);

    /**
     * Multiplies this quaternion by another quaternion.
     *
     * @param quaternion The quaternion to multiply by.
     * @return The result of the multiplication.
     */
    IQuaternion multiply(IQuaternion quaternion);

    /**
     * Returns a normalized quaternion that has the same orientation as this quaternion.
     * <p>
     * A normalized quaternion has a magnitude of 1 and represents the same
     * orientation as the original quaternion. An ArithmeticException is thrown
     * if the magnitude of the quaternion is zero, as it is impossible to
     * normalize a quaternion with a magnitude of zero.
     *
     * @return A normalized quaternion that has the same orientation as this quaternion.
     * @throws ArithmeticException If this quaternion has a magnitude of zero.
     */
    IQuaternion normalize();

    /**
     * Returns the inverse of this quaternion.
     * <p>
     * In mathematics, the inverse of a quaternion is a value that,
     * when multiplied by the original quaternion, results in the identity quaternion
     * (i.e., a quaternion with a scalar part of 1 and a vector part of 0).
     * <p>
     * The inverse of a quaternion is defined as the conjugate of the quaternion
     * divided by its magnitude.
     *
     * @return the inverse of this quaternion
     * @throws ArithmeticException if the magnitude of this quaternion is zero.
     */
    IQuaternion inverse() throws ArithmeticException;

    /**
     * Returns the conjugate of this quaternion.
     * <p>
     * In mathematics, the conjugate of a complex number or quaternion is a value
     * obtained by changing the sign of its imaginary part.
     * <p>
     * Specifically, for a complex number a + bi, the conjugate is a - bi,
     * where a and b are real numbers and i is the imaginary unit.
     * <p>
     * For a quaternion a + bi + cj + dk, the conjugate is a - bi - cj - dk,
     * where a, b, c, and d are real numbers and i, j, and k are imaginary units.
     *
     * @return the conjugate of this quaternion
     */
    IQuaternion conjugate();

    /**
     * Returns the magnitude of this quaternion.
     * <p>
     * The magnitude of a quaternion is a measure of its size or length
     * and is calculated as the square root of the sum of the squares of its four components.
     *
     * @return the magnitude of this quaternion
     */
    double getMagnitude();

    double getW();

    double getX();

    double getY();

    double getZ();
}
