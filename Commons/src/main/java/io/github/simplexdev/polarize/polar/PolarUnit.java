package io.github.simplexdev.polarize.polar;

import io.github.simplexdev.polarize.api.units.Radius;
import io.github.simplexdev.polarize.api.units.Theta;

public class PolarUnit {
    private final Radius radius;
    private final Theta theta;

    public PolarUnit(double radius, double theta) {
        this.radius = () -> radius;
        this.theta = () -> theta;
    }

    public Radius getRadius() {
        return radius;
    }

    public Theta getTheta() {
        return theta;
    }

    public double radius() {
        return radius.length();
    }

    public double theta() {
        return theta.getZenith();
    }
}
