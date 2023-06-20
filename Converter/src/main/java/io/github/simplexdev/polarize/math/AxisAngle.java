package io.github.simplexdev.polarize.math;

import io.github.simplexdev.polarize.api.rotation.IAxisAngle;
import io.github.simplexdev.polarize.api.units.Theta;

public class AxisAngle implements IAxisAngle {
    private final double x;
    private final double y;
    private final double z;
    private final Theta angle;

    public AxisAngle(double x, double y, double z, Theta angle) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.angle = angle;
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
    public Theta getAngle() {
        return this.angle;
    }

    @Override
    public IAxisAngle negate() {
        return new AxisAngle(-this.x, -this.y, -this.z, () -> -(this.angle.getZenith()));
    }

    @Override
    public IAxisAngle normalize() {
        double magnitude = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
        return new AxisAngle(this.x / magnitude, this.y / magnitude, this.z / magnitude, this.angle);
    }

    @Override
    public IAxisAngle inverse() {
        return new AxisAngle(-this.x, -this.y, -this.z, this.angle);
    }
}
