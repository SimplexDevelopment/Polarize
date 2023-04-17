package io.github.simplexdev.polarize.api.units;

/**
 * This is a functional interface representing a mathematical function Radius, which returns the length of the radius.
 * <p>
 * The interface has a single method 'length' which returns a double value representing the length of the radius.
 * <p>
 * This interface is marked with the @FunctionalInterface annotation which indicates that it should be
 * <p>
 * used as a functional interface with a single abstract method (SAM).
 *
 * @see <a href="https://en.wikipedia.org/wiki/Radius">Radius</a>
 */
@FunctionalInterface
public interface Radius
{
    /**
     * This method returns a double value representing the length of the radius.
     *
     * @return the length of the radius as a double
     */
    double length();
}
