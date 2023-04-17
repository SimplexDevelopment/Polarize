package io.github.simplexdev.polarize.api;

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
    double getX();

    /**
     * Returns the Y coordinate of this point.
     *
     * @return The Y coordinate of this point.
     */
    double getY();

    /**
     * Returns the Z coordinate of this point.
     *
     * @return The Z coordinate of this point.
     */
    double getZ();
}
