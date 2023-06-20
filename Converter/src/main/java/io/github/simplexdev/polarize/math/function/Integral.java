package io.github.simplexdev.polarize.math.function;

import io.github.simplexdev.polarize.api.spatial.IPoint3D;
import io.github.simplexdev.polarize.cartesian.Point3D;

import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public interface Integral {
    static double integrate(double lower, double upper, double subIntervals, DoubleUnaryOperator function) {
        double dx = (upper - lower) / subIntervals;
        double sum = 0.5 * (function.applyAsDouble(lower) + function.applyAsDouble(upper));
        for (double i = 1; i < subIntervals; i++) {
            double s = lower + i * dx;
            sum += function.applyAsDouble(s);
        }
        return dx * sum;
    }

    static double integrate(IPoint3D origin, IPoint3D destination, double subIntervals, TriFunction<Double, Double, Double, Double> function) {
        double x1 = origin.getX().get(), x2 = destination.getX().get();
        double y1 = origin.getY().get(), y2 = destination.getY().get();
        double z1 = origin.getZ().get(), z2 = destination.getZ().get();

        double dx = (x2 - x1) / subIntervals;
        double dy = (y2 - y1) / subIntervals;
        double dz = (z2 - z1) / subIntervals;

        double integral = 0.0;

        for (double i = 0.0; i <= subIntervals; i++) {
            double x = x1 + i * dx;
            for (double j = 0.0; j <= subIntervals; j++) {
                double y = y1 + j * dy;
                for (double k = 0.0; k <= subIntervals; k++) {
                    double z = z1 + k * dz;
                    double weight = 1.0;
                    if (i == 0.0 || i == subIntervals) weight *= 0.5;
                    if (j == 0.0 || j == subIntervals) weight *= 0.5;
                    if (k == 0.0 || k == subIntervals) weight *= 0.5;
                    integral += weight * function.apply(x, y, z);
                }
            }
        }

        integral *= dx * dy * dz;

        return integral;
    }
}
