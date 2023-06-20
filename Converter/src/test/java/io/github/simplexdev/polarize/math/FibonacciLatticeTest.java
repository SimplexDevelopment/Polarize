package io.github.simplexdev.polarize.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.simplexdev.polarize.api.spatial.IPoint3D;
import io.github.simplexdev.polarize.cartesian.Point3D;
import io.github.simplexdev.polarize.log.PolarizeLogger;
import io.github.simplexdev.polarize.math.function.FibonacciLattice;
import org.junit.jupiter.api.Test;

class FibonacciLatticeTest
{
    /**
     * Method under test: {@link FibonacciLattice#populate(IPoint3D, int, double)}
     */
    @Test
    void testDisplayPoints()
    {
        FibonacciLattice.populate(new Point3D(10,15,5), 10, 0.1)
                .forEach(point -> PolarizeLogger.info("X: " + point.getX() + " Y: " + point.getY() + " Z: " + point.getZ()));
    }
}

