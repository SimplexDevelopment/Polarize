package io.github.simplexdev.polarize.api.spatial;

import java.util.Set;
import static io.github.simplexdev.polarize.api.units.Point.*;

/**
 * Represents a point in 3D space.
 * It's important to note that Y is our vertical plane, and XZ is our horizontal plane.
 * This is because Minecraft's coordinate system is based on the XZ plane.
 * While this library is not Minecraft-specific, it is designed with Minecraft in mind.
 */
public interface IPoint3D {
    /**
     * Returns the X coordinate of this point.
     *
     * @return The X coordinate of this point.
     */
    X getX();

    /**
     * Returns the Y coordinate of this point.
     *
     * @return The Y coordinate of this point.
     */
    Y getY();

    /**
     * Returns the Z coordinate of this point.
     *
     * @return The Z coordinate of this point.
     */
    Z getZ();

    /**
     * Returns the distance between this point and another point.
     *
     * @param point The point to calculate the distance to.
     * @return The distance between this point and the other point.
     */
    IVector getDistance(IPoint3D point);

    /**
     * Returns the difference between this point and another point.
     *
     * @param point The point to calculate the difference to.
     * @return The difference between this point and the other point.
     */
    IPoint3D getDifferential(IPoint3D point);

    /**
     * Returns the sum of this point and another point.
     *
     * @param point The point to add to this point.
     * @return The sum of this point and the other point.
     */
    IPoint3D add(IPoint3D point);

    /**
     * Returns the product of this point and another point.
     * This will effectively scale the point by the other point.
     * For example, if this point is (1, 1, 1) and the other point is (2, 2, 2),
     * the resulting point will be (2, 2, 2).
     *
     * @param point The point to multiply this point by.
     * @return The product of this point and the other point.
     */
    IPoint3D multiply(IPoint3D point);

    /**
     * Translates this point according to the vector provided.
     * This will effectively move the point to the desired destination defined by the vector.
     *
     * @param vector The vector to add to this point.
     * @return The sum of this point and the vector.
     */
    IPoint3D move(IVector vector);

    /**
     * Returns the midpoint between this point and another point.
     *
     * @param point     The point to calculate the midpoint to.
     * @param numPoints The number of points to draw between this point and the other point.
     * @return The midpoint between this point and the other point.
     */
    Set<IPoint3D> drawLine(IPoint3D point, double numPoints);
}
