package io.github.simplexdev.polarize.cartesian;

import io.github.simplexdev.polarize.api.IQuaternion;
import io.github.simplexdev.polarize.api.IVector;
import io.github.simplexdev.polarize.math.Quaternion;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CartesianVector implements IVector {

    private final double x;
    private final double y;
    private final double z;
    private final double length;

    public CartesianVector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.length = Math.sqrt(x * x + y * y + z * z);
    }

    private CartesianVector(double x, double y, double z, double length) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.length = length;
    }

    @Override
    public IVector add(@NotNull IVector vector) {
        Objects.requireNonNull(vector);
        return new CartesianVector(
                this.x + vector.getX(),
                this.y + vector.getY(),
                this.z + vector.getZ());
    }

    @Override
    public IVector multiply(@NotNull IVector vector) {
        return new CartesianVector(
                this.x * vector.getX(),
                this.y * vector.getY(),
                this.z * vector.getZ());
    }

    @Override
    public IVector add(double value) {
        return new CartesianVector(
                this.x + value,
                this.y + value,
                this.z + value);
    }

    @Override
    public IVector multiply(double value) {
        return new CartesianVector(
                this.x * value,
                this.y * value,
                this.z * value);
    }

    @Override
    public IVector inverse() {
        return new CartesianVector(
                this.x * -1.0,
                this.y * -1.0,
                this.z * -1.0);
    }

    @Override
    public IVector normalize() {
        if (this.length == 0) {
            return new CartesianVector(0, 0, 0);
        }
        return new CartesianVector(
                this.x / this.length,
                this.y / this.length,
                this.z / this.length,
                1);
    }

    @Override
    public double dot(@NotNull IVector vector) {
        return this.x * vector.getX() + this.y * vector.getY() + this.z * vector.getZ();
    }

    @Override
    public double getAngle(@NotNull IVector vector) {
        double dot = this.dot(vector);
        return Math.acos(dot / (this.length() * vector.length()));
    }

    @Override
    public double length() {
        return this.length;
    }

    @Override
    public double lengthSquared() {
        return this.length * this.length;
    }

    @Override
    public double distance(@NotNull IVector vector) {
        Objects.requireNonNull(vector);
        return Math.sqrt(distanceSquared(vector));
    }

    @Override
    public double distanceSquared(@NotNull IVector vector) {
        Objects.requireNonNull(vector);
        double dx = this.x - vector.getX();
        double dy = this.y - vector.getY();
        double dz = this.z - vector.getZ();
        return dx * dx + dy * dy + dz * dz;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public double getZ() {
        return this.z;
    }

    @Override
    public IVector rotate(@NotNull IQuaternion quaternion) {
        IQuaternion q = quaternion.normalize();
        IQuaternion p = new Quaternion(0, this.x, this.y, this.z);
        IQuaternion pRotated = q.multiply(p).multiply(q.conjugate());

        return new CartesianVector(pRotated.getX(), pRotated.getY(), pRotated.getZ());
    }
}