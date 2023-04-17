package io.github.simplexdev.polarize.polar;

import io.github.simplexdev.polarize.api.IQuaternion;
import io.github.simplexdev.polarize.api.IScalar;

public class Scalar implements IScalar {
    private final double magnitude;
    private final double origin;

    public Scalar(double magnitude, double origin) {
        this.magnitude = magnitude;
        this.origin = origin;
    }

    @Override
    public double getMagnitude() {
        return this.magnitude;
    }

    @Override
    public double getOrigin() {
        return this.origin;
    }

    @Override
    public IScalar add(double add) {
        double sumValue = getMagnitude() + add;
        return new Scalar(sumValue, getOrigin());
    }

    @Override
    public IScalar add(IScalar scalar) {
        double sumValue = getMagnitude() + scalar.getMagnitude();
        return new Scalar(sumValue, getOrigin());
    }


    @Override
    public IScalar multiply(double multiply) {
        double productValue = getMagnitude() * multiply;
        return new Scalar(productValue, getOrigin());
    }

    @Override
    public IScalar multiply(IScalar scalar) {
        double productValue = getMagnitude() * scalar.getMagnitude();
        return new Scalar(productValue, getOrigin());
    }

    @Override
    public IScalar multiply(IQuaternion quaternion) {
        double productValue = getMagnitude() * quaternion.getW();
        return new Scalar(productValue, getOrigin());
    }

    @Override
    public IScalar normalize() {
        double magnitude = getMagnitude();
        if (magnitude == 0.0) {
            return new Scalar(0.0, getOrigin());
        }
        double normalizedMagnitude = 1.0 / magnitude;
        double normalizedValue = getMagnitude() * normalizedMagnitude;
        return new Scalar(normalizedValue, getOrigin());
    }

    @Override
    public IScalar inverse() throws ArithmeticException {
        if (getMagnitude() == 0.0) {
            throw new ArithmeticException("Cannot compute inverse of scalar with magnitude 0.");
        }
        double reciprocalValue = 1.0 / getMagnitude();
        return new Scalar(reciprocalValue, getOrigin());
    }

    @Override
    public IScalar negate() {
        double negatedValue = -getMagnitude();
        return new Scalar(negatedValue, getOrigin());
    }
}
