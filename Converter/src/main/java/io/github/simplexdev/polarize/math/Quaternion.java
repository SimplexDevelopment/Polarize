package io.github.simplexdev.polarize.math;

import io.github.simplexdev.polarize.api.rotation.IQuaternion;

public class Quaternion implements IQuaternion {
    private final double w;
    private final double x;
    private final double y;
    private final double z;

    public Quaternion(double w, double x, double y, double z) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double getW() {
        return w;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getZ() {
        return z;
    }

    @Override
    public IQuaternion add(double scalar) {
        return new Quaternion(this.w + scalar, this.x, this.y, this.z);
    }

    @Override
    public IQuaternion add(IQuaternion q) {
        return new Quaternion(this.w + q.getW(), this.x + q.getX(), this.y + q.getY(), this.z + q.getZ());
    }

    @Override
    public IQuaternion multiply(double scalar) {
        return new Quaternion(this.w * scalar, this.x * scalar, this.y * scalar, this.z * scalar);
    }

    @Override
    public IQuaternion multiply(IQuaternion q) {
        double w1 = this.w,
                x1 = this.x,
                y1 = this.y,
                z1 = this.z;
        double w2 = q.getW(),
                x2 = q.getX(),
                y2 = q.getY(),
                z2 = q.getZ();

        double w = w1 * w2 - x1 * x2 - y1 * y2 - z1 * z2;
        double x = w1 * x2 + x1 * w2 + y1 * z2 - z1 * y2;
        double y = w1 * y2 + y1 * w2 + z1 * x2 - x1 * z2;
        double z = w1 * z2 + z1 * w2 + x1 * y2 - y1 * x2;

        return new Quaternion(w, x, y, z);
    }

    @Override
    public IQuaternion normalize() {
        double magnitude = this.getMagnitude();
        return new Quaternion(this.w / magnitude, this.x / magnitude, this.y / magnitude, this.z / magnitude);
    }

    @Override
    public IQuaternion inverse() {
        double magnitudeSquared = this.getMagnitude() * this.getMagnitude();
        return new Quaternion(this.w / magnitudeSquared, -this.x / magnitudeSquared, -this.y / magnitudeSquared, -this.z / magnitudeSquared);
    }

    @Override
    public IQuaternion conjugate() {
        return new Quaternion(this.w, -this.x, -this.y, -this.z);
    }

    @Override
    public double getMagnitude() {
        return Math.sqrt(w * w + x * x + y * y + z * z);
    }
}