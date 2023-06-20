package io.github.simplexdev.polarize.cartesian;

import io.github.simplexdev.polarize.api.spatial.IPoint3D;
import io.github.simplexdev.polarize.api.spatial.IVector;

public class Vertex {
    private final IPoint3D vertex;

    public Vertex(IVector vector1, IVector vector2) {
        this.vertex = vector1.cross(vector2);
    }

    public double getX() {
        return vertex.getX().get();
    }

    public double getY() {
        return vertex.getY().get();
    }

    public double getZ() {
        return vertex.getZ().get();
    }
}
