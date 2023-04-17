package io.github.simplexdev.polarize.polar;

import io.github.simplexdev.polarize.api.units.Phi;
import io.github.simplexdev.polarize.api.units.Radius;
import io.github.simplexdev.polarize.api.units.Theta;

public class SphericalUnit {
    private final Radius radius;
    private final Theta theta;
    private final Phi phi;

    public SphericalUnit(double radius, double theta, double phi) {
        this.radius = () -> radius;
        this.theta = () -> theta;
        this.phi = () -> phi;
    }

    public Radius getRadius() {
        return this.radius;
    }

    public Theta getTheta() {
        return this.theta;
    }

    public Phi getPhi() {
        return this.phi;
    }

    public double radius() {
        return this.radius.length();
    }

    public double theta() {
        return this.theta.getZenith();
    }

    public double phi() {
        return this.phi.getAzimuth();
    }
}
