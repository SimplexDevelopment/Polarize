package io.github.simplexdev.polarize.api.units;

/**
 * This is a functional interface representing a mathematical function Phi, which returns the azimuth value.
 * <p>
 * The interface has a single method 'getAzimuth' which returns a double value representing the azimuth.
 * <p>
 * This interface is marked with the @FunctionalInterface annotation which indicates that it should be
 * <p>
 * used as a functional interface with a single abstract method (SAM).
 *
 * @see <a href="https://en.wikipedia.org/wiki/Azimuth">Azimuth</a>
 */
@FunctionalInterface
public interface Phi {

    /**
     * This method returns a double value representing the azimuth.
     *
     * @return the azimuth value as a double
     */
    double getAzimuth();

    static Phi from(double y, Radius r) {
        return () -> Math.cos(y / r.length());
    }

    static Phi of(double azimuth) {
        return () -> azimuth;
    }
}
