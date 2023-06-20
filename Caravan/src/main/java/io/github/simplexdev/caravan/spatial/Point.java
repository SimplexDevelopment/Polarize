package io.github.simplexdev.caravan.spatial;

public class Point {
    private final double x;
    private final double y;
    private final double z;

    private double xOffset;
    private double yOffset;
    private double zOffset;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.xOffset = 0;
        this.yOffset = 0;
        this.zOffset = 0;
    }

    public Point(double x, double y, double z, double xOffset, double yOffset, double zOffset) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.zOffset = zOffset;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getXOffset() {
        return xOffset;
    }

    public void setXOffset(double xOffset) {
        this.xOffset = xOffset;
    }

    public double getYOffset() {
        return yOffset;
    }

    public void setYOffset(double yOffset) {
        this.yOffset = yOffset;
    }

    public double getZOffset() {
        return zOffset;
    }

    public void setZOffset(double zOffset) {
        this.zOffset = zOffset;
    }
}
