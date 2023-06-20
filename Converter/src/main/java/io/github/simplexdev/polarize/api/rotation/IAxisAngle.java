package io.github.simplexdev.polarize.api.rotation;

import io.github.simplexdev.polarize.api.units.Theta;

public interface IAxisAngle {
    double getX();

    double getY();

    double getZ();

    Theta getAngle();

    IAxisAngle negate();

    IAxisAngle normalize();

    IAxisAngle inverse();
}
