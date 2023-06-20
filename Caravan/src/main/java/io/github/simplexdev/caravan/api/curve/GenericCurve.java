package io.github.simplexdev.caravan.api.curve;

import io.github.simplexdev.caravan.spatial.Point;

import java.util.LinkedHashSet;

public interface GenericCurve {
    LinkedHashSet<Point> linkedPoints();

    default void addPoint(Point point) {
        linkedPoints().add(point);
    }

    default void removePoint(Point point) {
        linkedPoints().remove(point);
    }

    default void clearPoints() {
        linkedPoints().clear();
    }

    default boolean containsPoint(Point point) {
        return linkedPoints().contains(point);
    }

    default void addPoints(Point... points) {
        for (Point point : points) {
            addPoint(point);
        }
    }
}
