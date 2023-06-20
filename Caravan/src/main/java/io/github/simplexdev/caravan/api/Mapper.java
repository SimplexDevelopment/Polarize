package io.github.simplexdev.caravan.api;

import io.github.simplexdev.caravan.api.curve.GenericCurve;
import io.github.simplexdev.caravan.spatial.Point;

import java.util.Set;

public interface Mapper {
    <T extends GenericCurve> Set<Point> generateCurve(T curve);


}
