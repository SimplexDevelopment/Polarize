package io.github.simplexdev.caravan.api.curve;

import io.github.simplexdev.caravan.spatial.Point;

public interface Helix extends GenericCurve {
    double getRadius();

    double getDistance();

    default double getX(double pos) {
        return getRadius() * Math.cos(pos);
    }

    default double getY(double pos) {
        return getRadius() * Math.sin(pos);
    }

    default double getZ(double pos) {
        return getDistance() * pos;
    }

    default Point toPoint(double pos) {
        return new Point(getX(pos), getY(pos), getZ(pos));
    }
}
