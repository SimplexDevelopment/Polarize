package io.github.simplexdev.polarize.polar;

import io.github.simplexdev.polarize.api.units.Phi;
import io.github.simplexdev.polarize.api.units.Theta;

public class Delta {
    private final Theta theta;
    private final Phi phi;

    public Delta(double theta, double phi) {
        this.theta = () -> theta;
        this.phi = () -> phi;
    }

    public Theta getTheta() {
        return theta;
    }

    public Phi getPhi() {
        return phi;
    }

    public double theta() {
        return theta.getZenith();
    }

    public double phi() {
        return phi.getAzimuth();
    }
}
