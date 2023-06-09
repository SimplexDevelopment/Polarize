package io.github.simplexdev.polarize.api.spatial;

import static io.github.simplexdev.polarize.api.units.Point.X;
import static io.github.simplexdev.polarize.api.units.Point.Z;

/**
 * Represents a point in 2D space along an XZ plane.
 * We are using XZ instead of XY because Minecraft uses XZ.
 * While this library is not Minecraft specific, it is designed with Minecraft in mind.
 */
public interface IPoint2D {
    /**
     * Returns the X coordinate of the point.
     *
     * @return The X coordinate of the point.
     */
    X getX();

    /**
     * Returns the Z coordinate of the point.
     *
     * @return The Z coordinate of the point.
     */
    Z getZ();
}
