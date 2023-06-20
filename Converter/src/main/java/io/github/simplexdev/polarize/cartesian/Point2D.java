package io.github.simplexdev.polarize.cartesian;

import io.github.simplexdev.polarize.api.spatial.IPoint2D;
import static io.github.simplexdev.polarize.api.units.Point.*;

public class Point2D implements IPoint2D {

    private final X x;
    private final Z z;

    public Point2D(X x, Z z) {
        this.x = x;
        this.z = z;
    }

    @Override
    public X getX() {
        return this.x;
    }

    @Override
    public Z getZ() {
        return this.z;
    }
}
