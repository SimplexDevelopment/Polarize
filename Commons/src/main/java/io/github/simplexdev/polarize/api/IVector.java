package io.github.simplexdev.polarize.api;

import org.jetbrains.annotations.NotNull;

/**
 * This interface represents a vector in 3D space.
 * A vector is a line with a direction and a length.
 * A vector can be represented by a point in space.
 * However, there is a much better suited Point2D and Point3D interface
 * for this purpose.
 */
public interface IVector {
    /**
     * This method adds the X Y Z mods of the vector passed in
     * to the X Y Z mods of this vector. The length is recalculated.
     *
     * @param vector The vector to add to this vector.
     * @return A new vector with the X Y Z mods added.
     */
    IVector add(@NotNull IVector vector);

    /**
     * This method multiplies the X Y Z mods of the vector passed in
     * to the X Y Z mods of this vector. The length is recalculated.
     *
     * @param vector The vector to multiply to this vector.
     * @return A new vector with the X Y Z mods multiplied.
     */
    IVector multiply(@NotNull IVector vector);

    /**
     * This method returns a new vector with the X Y Z mods added
     * by the value. The length is recalculated. This is a static input based
     * on the value passed in which will add to each mod of the vector.
     *
     * @param value The value to add to the X Y Z mods.
     * @return A new vector with the X Y Z mods added by the value.
     */
    IVector add(double value);

    /**
     * This method returns a new vector with the X Y Z mods multiplied
     * by the value. The length is recalculated. This is a static input based
     * on the value passed in which will multiply each mod of the vector.
     *
     * @param value The value to multiply the X Y Z mods by.
     * @return A new vector with the X Y Z mods multiplied by the value.
     */
    IVector multiply(double value);

    /**
     * This method returns a copy of this vector with the X Y Z mods inverted.
     * The length is recalculated. The X Y Z mods are multiplied by -1.
     *
     * @return A copy of this vector with the X Y Z mods inverted.
     */
    IVector inverse();

    /**
     * This method returns a copy of this vector with a length of 1.
     * X Y Z mods all remain unchanged.
     *
     * @return A copy of this vector with a length of 1.
     */
    IVector normalize();

    /**
     * This method returns the dot product of this vector and the
     * vector passed in. The dot product of two vectors is
     * the sum of the corresponding product components.
     *
     * @param vector The vector to dot product with.
     * @return The dot product of this vector and the vector passed in.
     */
    double dot(@NotNull IVector vector);

    /**
     * This method returns the angle between this vector and the vector
     * passed in. The angle is in radians. The angle is the angle between
     * the two vectors, which is calculated from the dot product.
     *
     * @param vector The vector to get the angle between.
     * @return The angle between this vector and the vector passed in.
     */
    double getAngle(@NotNull IVector vector);

    /**
     * This method returns the length of this vector.
     * The length is the distance between the origin and the desired point.
     * The length is calculated from the X Y Z mods as
     * sqrt(x * x + y * y + z * z).
     *
     * @return The length of this vector.
     */
    double length();

    /**
     * This method returns the length of this vector squared.
     * The length is determined by sqrt(x * x + y * y + z * z).
     *
     * @return The length of this vector squared.
     * @see #length()
     */
    double lengthSquared();

    /**
     * This method returns the distance between this vector and the vector
     * passed in. The distance is the length of the vector between the two
     * vectors. The distance is calculated from the X Y Z mods as
     * sqrt(distanceSquared(vector));
     *
     * @param vector The vector to get the distance between.
     * @return The distance between this vector and the vector passed in.
     * @see #distanceSquared(IVector)
     */
    double distance(@NotNull IVector vector);

    /**
     * This method returns the distance between this vector and the vector
     * passed in squared. The distance is the length of the vector between the two
     * vectors. The distance is calculated from the X Y Z mods as
     * (x - x1) * (x - x1) + (y - y1) * (y - y1) + (z - z1) * (z - z1).
     *
     * @param vector The vector to get the distance between.
     * @return The distance between this vector and the vector passed in squared.
     */
    double distanceSquared(@NotNull IVector vector);

    /**
     * @return The X mod of this vector.
     */
    double getX();

    /**
     * @return The Y mod of this vector.
     */
    double getY();

    /**
     * @return The Z mod of this vector.
     */
    double getZ();

    /**
     * This method returns a new vector with the X Y Z mods rotated
     * by the quaternion passed in. The length is recalculated.
     *
     * @param quaternion The quaternion to rotate the vector by.
     * @return A new vector with the X Y Z mods rotated by the quaternion passed in.
     */
    IVector rotate(@NotNull IQuaternion quaternion);
}
