package io.github.simplexdev.polarize.math;

import io.github.simplexdev.polarize.api.IPoint2D;

public class Point2D implements IPoint2D {

    private final double x;
    private final double z;

    public Point2D(double x, double z) {
        this.x = x;
        this.z = z;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getZ() {
        return this.z;
    }
}
