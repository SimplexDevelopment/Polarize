package io.github.simplexdev.polarize.cartesian;

import io.github.simplexdev.polarize.api.IPoint2D;
import io.github.simplexdev.polarize.api.IPoint3D;
import io.github.simplexdev.polarize.math.Point2D;
import io.github.simplexdev.polarize.math.Point3D;

/**
 * CartesianUnit is a class that contains a 3D point and a 2D point
 * which share the same x and z values for the horizontal plane.
 */
public class CartesianUnit {
    private final IPoint3D point3d;
    private final IPoint2D point2d;

    /**
     * Creates a new CartesianUnit with the given x, y, and z values.
     *
     * @param x The x value of the 3D point and the 2D point.
     * @param y The y value of the 3D point.
     * @param z The z value of the 3D point and the 2D point.
     */
    public CartesianUnit(double x, double y, double z) {
        this.point3d = new Point3D(x, y, z);
        this.point2d = new Point2D(x, z);
    }

    /**
     * Returns the 3D point of the CartesianUnit.
     *
     * @return The 3D point of the CartesianUnit.
     */
    public IPoint3D getPoint3D() {
        return this.point3d;
    }

    /**
     * Returns the 2D point of the CartesianUnit.
     *
     * @return The 2D point of the CartesianUnit.
     */
    public IPoint2D getPoint2D() {
        return this.point2d;
    }
}
