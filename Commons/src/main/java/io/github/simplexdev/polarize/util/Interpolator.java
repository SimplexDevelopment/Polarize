package io.github.simplexdev.polarize.util;

import io.github.simplexdev.polarize.api.IScalar;
import io.github.simplexdev.polarize.api.IVector;
import io.github.simplexdev.polarize.cartesian.CartesianUnit;
import io.github.simplexdev.polarize.polar.PolarUnit;
import io.github.simplexdev.polarize.polar.SphericalUnit;

import java.util.HashSet;
import java.util.Set;

/**
 * A utility class for generating sets of coordinate units based on different coordinate systems.
 * <p>
 * This class provides several methods for generating sets of coordinate units based on different
 * coordinate systems like Cartesian, Polar and Spherical. These methods take input vectors and scalars,
 * and generate corresponding coordinate units by iterating through angles in specific steps.
 * <p>
 * The generated sets of coordinate units can be used for interpolation and other mathematical operations
 * involving coordinates in different coordinate systems.
 *
 * @see CartesianUnit
 * @see PolarUnit
 * @see SphericalUnit
 * @see IVector
 * @see IScalar
 */
public class Interpolator {
    private Interpolator() {
        throw new AssertionError();
    }

    /**
     * Generates a set of CartesianUnits using the given IVector and step value.
     * This method generates the CartesianUnits by iterating through angles i and j in steps of the given value,
     * up to 45 degrees, and then computing their respective x, y and z values using the magnitude
     * and azimuth and polar angles of the input vector.
     *
     * @param vector the input vector used to generate the CartesianUnits
     * @param step   the step value used for the angles 'i' and 'j'
     * @return a set of CartesianUnits generated from the input vector and step value
     * @see <a href="https://en.wikipedia.org/wiki/Cartesian_coordinate_system">Cartesian coordinate system</a>
     * @see <a href="https://en.wikipedia.org/wiki/Unit_vector">Unit vector</a>
     * @see IVector
     */
    public static Set<CartesianUnit> cartesian45(IVector vector, double step) {
        Set<CartesianUnit> unitSet = new HashSet<>();

        for (int i = 0; i <= Utilities.RADIAN_45; i += step) {
            for (int j = 0; j <= Utilities.RADIAN_45; j += step) {
                CartesianUnit unit = new CartesianUnit(vector.length() * Math.sin(i) * Math.cos(j), vector.length() * Math.cos(i), vector.length() * Math.sin(i) * Math.sin(j));
                unitSet.add(unit);
            }
        }

        return unitSet;
    }

    /**
     * Generates a set of CartesianUnits using the given IVector and step value.
     * This method generates the CartesianUnits by iterating through angles i and j in steps of the given value,
     * up to 90 degrees, and then computing their respective x, y and z values using the magnitude
     * and azimuth and polar angles of the input vector.
     *
     * @param vector the input vector used to generate the CartesianUnits
     * @param step   the step value used for the angles 'i' and 'j'
     * @return a set of CartesianUnits generated from the input vector and step value
     * @see <a href="https://en.wikipedia.org/wiki/Cartesian_coordinate_system">Cartesian coordinate system</a>
     * @see <a href="https://en.wikipedia.org/wiki/Unit_vector">Unit vector</a>
     * @see IVector
     */
    public static Set<CartesianUnit> cartesian90(IVector vector, double step) {
        Set<CartesianUnit> unitSet = new HashSet<>();

        for (int i = 0; i <= Utilities.RADIAN_90; i += step) {
            for (int j = 0; j <= Utilities.RADIAN_90; j += step) {
                CartesianUnit unit = new CartesianUnit(vector.length() * Math.sin(i) * Math.cos(j), vector.length() * Math.cos(i), vector.length() * Math.sin(i) * Math.sin(j));
                unitSet.add(unit);
            }
        }

        return unitSet;
    }

    /**
     * Generates a set of CartesianUnits using the given IVector and step value.
     * This method generates the CartesianUnits by iterating through angles i and j in steps of the given value,
     * up to 180 degrees, and then computing their respective x, y and z values using the magnitude
     * and azimuth and polar angles of the input vector.
     *
     * @param vector the input vector used to generate the CartesianUnits
     * @param step   the step value used for the angles 'i' and 'j'
     * @return a set of CartesianUnits generated from the input vector and step value
     * @see <a href="https://en.wikipedia.org/wiki/Cartesian_coordinate_system">Cartesian coordinate system</a>
     * @see <a href="https://en.wikipedia.org/wiki/Unit_vector">Unit vector</a>
     * @see IVector
     */
    public static Set<CartesianUnit> cartesian180(IVector vector, double step) {
        Set<CartesianUnit> unitSet = new HashSet<>();

        for (int i = 0; i <= Utilities.RADIAN_180; i += step) {
            for (int j = 0; j <= Utilities.RADIAN_180; j += step) {
                CartesianUnit unit = new CartesianUnit(vector.length() * Math.sin(i) * Math.cos(j), vector.length() * Math.cos(i), vector.length() * Math.sin(i) * Math.sin(j));
                unitSet.add(unit);
            }
        }

        return unitSet;
    }

    /**
     * Generates a set of CartesianUnits using the given IVector and step value.
     * This method generates the CartesianUnits by iterating through angles i and j in steps of the given value,
     * up to 270 degrees, and then computing their respective x, y and z values using the magnitude
     * and azimuth and polar angles of the input vector.
     *
     * @param vector the input vector used to generate the CartesianUnits
     * @param step   the step value used for the angles 'i' and 'j'
     * @return a set of CartesianUnits generated from the input vector and step value
     * @see <a href="https://en.wikipedia.org/wiki/Cartesian_coordinate_system">Cartesian coordinate system</a>
     * @see <a href="https://en.wikipedia.org/wiki/Unit_vector">Unit vector</a>
     * @see IVector
     */
    public static Set<CartesianUnit> cartesian270(IVector vector, double step) {
        Set<CartesianUnit> unitSet = new HashSet<>();

        for (int i = 0; i <= Utilities.RADIAN_270; i += step) {
            for (int j = 0; j <= Utilities.RADIAN_270; j += step) {
                CartesianUnit unit = new CartesianUnit(vector.length() * Math.sin(i) * Math.cos(j), vector.length() * Math.cos(i), vector.length() * Math.sin(i) * Math.sin(j));
                unitSet.add(unit);
            }
        }

        return unitSet;
    }

    /**
     * Generates a set of CartesianUnits using the given IVector and step value.
     * This method generates the CartesianUnits by iterating through angles i and j in steps of the given value,
     * up to 360 degrees, and then computing their respective x, y and z values using the magnitude
     * and azimuth and polar angles of the input vector.
     *
     * @param vector the input vector used to generate the CartesianUnits
     * @param step   the step value used for the angles 'i' and 'j'
     * @return a set of CartesianUnits generated from the input vector and step value
     * @see <a href="https://en.wikipedia.org/wiki/Cartesian_coordinate_system">Cartesian coordinate system</a>
     * @see <a href="https://en.wikipedia.org/wiki/Unit_vector">Unit vector</a>
     * @see IVector
     */
    public static Set<CartesianUnit> cartesian360(IVector vector, double step) {
        Set<CartesianUnit> unitSet = new HashSet<>();

        for (int i = 0; i <= Utilities.RADIAN_360; i += step) {
            for (int j = 0; j <= Utilities.RADIAN_360; j += step) {
                CartesianUnit unit = new CartesianUnit(vector.length() * Math.sin(i) * Math.cos(j), vector.length() * Math.cos(i), vector.length() * Math.sin(i) * Math.sin(j));
                unitSet.add(unit);
            }
        }

        return unitSet;
    }

    /**
     * Generates a set of PolarUnits using the given IScalar and step value.
     * <p>
     * This method generates the PolarUnits by iterating through angles in steps of the given value,
     * up to a maximum of 45 degrees, and then computing their respective magnitude and angle values
     * using the magnitude of the input scalar.
     *
     * @param scalar The input scalar used to generate the PolarUnits.
     * @param step   The step value used to increment angles while generating the PolarUnits.
     * @return A set of PolarUnits generated from the input scalar and step value.
     * @see <a href="https://en.wikipedia.org/wiki/Polar_coordinate_system">Polar coordinate system</a>
     * @see <a href="https://en.wikipedia.org/wiki/Magnitude_(mathematics)">Magnitude</a>
     * @see IScalar
     */
    public static Set<PolarUnit> polarSet45(IScalar scalar, double step) {
        Set<PolarUnit> unitSet = new HashSet<>();

        for (int i = 0; i <= Utilities.RADIAN_45; i += step) {
            PolarUnit unit = new PolarUnit(scalar.getMagnitude(), i);
            unitSet.add(unit);
        }

        return unitSet;
    }

    /**
     * Generates a set of PolarUnits using the given IScalar and step value.
     * <p>
     * This method generates the PolarUnits by iterating through angles in steps of the given value,
     * up to a maximum of 90 degrees, and then computing their respective magnitude and angle values
     * using the magnitude of the input scalar.
     *
     * @param scalar The input scalar used to generate the PolarUnits.
     * @param step   The step value used to increment angles while generating the PolarUnits.
     * @return A set of PolarUnits generated from the input scalar and step value.
     * @see <a href="https://en.wikipedia.org/wiki/Polar_coordinate_system">Polar coordinate system</a>
     * @see <a href="https://en.wikipedia.org/wiki/Magnitude_(mathematics)">Magnitude</a>
     * @see IScalar
     */
    public static Set<PolarUnit> polarSet90(IScalar scalar, double step) {
        Set<PolarUnit> unitSet = new HashSet<>();

        for (int i = 0; i <= Utilities.RADIAN_90; i += step) {
            PolarUnit unit = new PolarUnit(scalar.getMagnitude(), i);
            unitSet.add(unit);
        }

        return unitSet;
    }

    /**
     * Generates a set of PolarUnits using the given IScalar and step value.
     * <p>
     * This method generates the PolarUnits by iterating through angles in steps of the given value,
     * up to a maximum of 180 degrees, and then computing their respective magnitude and angle values
     * using the magnitude of the input scalar.
     *
     * @param scalar The input scalar used to generate the PolarUnits.
     * @param step   The step value used to increment angles while generating the PolarUnits.
     * @return A set of PolarUnits generated from the input scalar and step value.
     * @see <a href="https://en.wikipedia.org/wiki/Polar_coordinate_system">Polar coordinate system</a>
     * @see <a href="https://en.wikipedia.org/wiki/Magnitude_(mathematics)">Magnitude</a>
     * @see IScalar
     */
    public static Set<PolarUnit> polarSet180(IScalar scalar, double step) {
        Set<PolarUnit> unitSet = new HashSet<>();

        for (int i = 0; i <= Utilities.RADIAN_180; i += step) {
            PolarUnit unit = new PolarUnit(scalar.getMagnitude(), i);
            unitSet.add(unit);
        }

        return unitSet;
    }

    /**
     * Generates a set of PolarUnits using the given IScalar and step value.
     * <p>
     * This method generates the PolarUnits by iterating through angles in steps of the given value,
     * up to a maximum of 270 degrees, and then computing their respective magnitude and angle values
     * using the magnitude of the input scalar.
     *
     * @param scalar The input scalar used to generate the PolarUnits.
     * @param step   The step value used to increment angles while generating the PolarUnits.
     * @return A set of PolarUnits generated from the input scalar and step value.
     * @see <a href="https://en.wikipedia.org/wiki/Polar_coordinate_system">Polar coordinate system</a>
     * @see <a href="https://en.wikipedia.org/wiki/Magnitude_(mathematics)">Magnitude</a>
     * @see IScalar
     */
    public static Set<PolarUnit> polarSet270(IScalar scalar, double step) {
        Set<PolarUnit> unitSet = new HashSet<>();

        for (int i = 0; i <= Utilities.RADIAN_270; i += step) {
            PolarUnit unit = new PolarUnit(scalar.getMagnitude(), i);
            unitSet.add(unit);
        }

        return unitSet;
    }

    /**
     * Generates a set of PolarUnits using the given IScalar and step value.
     * <p>
     * This method generates the PolarUnits by iterating through angles in steps of the given value,
     * up to a maximum of 45 degrees, and then computing their respective magnitude and angle values
     * using the magnitude of the input scalar.
     *
     * @param scalar The input scalar used to generate the PolarUnits.
     * @param step   The step value used to increment angles while generating the PolarUnits.
     * @return A set of PolarUnits generated from the input scalar and step value.
     * @see <a href="https://en.wikipedia.org/wiki/Polar_coordinate_system">Polar coordinate system</a>
     * @see <a href="https://en.wikipedia.org/wiki/Magnitude_(mathematics)">Magnitude</a>
     * @see IScalar
     */
    public static Set<PolarUnit> polarSet360(IScalar scalar, double step) {
        Set<PolarUnit> unitSet = new HashSet<>();

        for (int i = 0; i < Utilities.RADIAN_360; i += step) {
            PolarUnit unit = new PolarUnit(scalar.getMagnitude(), i);
            unitSet.add(unit);
        }

        return unitSet;
    }

    /**
     * Generates a set of SphericalUnits using the given IScalar and step value.
     * This method generates the SphericalUnits by iterating through angles i and j in steps of the given value,
     * up to a maximum of 45 degrees, and then computing their respective magnitude, zenith and azimuth
     * values using the magnitude of the input scalar.
     *
     * @param scalar The input scalar used to generate the SphericalUnits.
     * @param step   The step value used to increment angles i and j while generating the SphericalUnits.
     * @return A set of SphericalUnits generated from the input scalar and step value.
     * @see <a href="https://en.wikipedia.org/wiki/Spherical_coordinate_system">Spherical coordinate system</a>
     * @see <a href="https://en.wikipedia.org/wiki/Inclination">Inclination</a>
     * @see <a href="https://en.wikipedia.org/wiki/Azimuth">Azimuth</a>
     * @see IScalar
     */
    public static Set<SphericalUnit> sphericalUnit45(IScalar scalar, double step) {
        Set<SphericalUnit> unitSet = new HashSet<>();

        for (int i = 0; i <= Utilities.RADIAN_45; i += step) {
            for (int j = 0; j <= Utilities.RADIAN_45; j += step) {
                SphericalUnit unit = new SphericalUnit(i, j, scalar.getMagnitude());
                unitSet.add(unit);
            }
        }

        return unitSet;
    }

    /**
     * Generates a set of SphericalUnits using the given IScalar and step value.
     * This method generates the SphericalUnits by iterating through angles i and j in steps of the given value,
     * up to a maximum of 90 degrees, and then computing their respective magnitude, zenith and azimuth
     * values using the magnitude of the input scalar.
     *
     * @param scalar The input scalar used to generate the SphericalUnits.
     * @param step   The step value used to increment angles i and j while generating the SphericalUnits.
     * @return A set of SphericalUnits generated from the input scalar and step value.
     * @see <a href="https://en.wikipedia.org/wiki/Spherical_coordinate_system">Spherical coordinate system</a>
     * @see <a href="https://en.wikipedia.org/wiki/Inclination">Inclination</a>
     * @see <a href="https://en.wikipedia.org/wiki/Azimuth">Azimuth</a>
     * @see IScalar
     */
    public static Set<SphericalUnit> sphericalUnit90(IScalar scalar, double step) {
        Set<SphericalUnit> unitSet = new HashSet<>();

        for (int i = 0; i <= Utilities.RADIAN_90; i += step) {
            for (int j = 0; j <= Utilities.RADIAN_90; j += step) {
                SphericalUnit unit = new SphericalUnit(i, j, scalar.getMagnitude());
                unitSet.add(unit);
            }
        }

        return unitSet;
    }

    /**
     * Generates a set of SphericalUnits using the given IScalar and step value.
     * This method generates the SphericalUnits by iterating through angles i and j in steps of the given value,
     * up to a maximum of 180 degrees, and then computing their respective magnitude, zenith and azimuth
     * values using the magnitude of the input scalar.
     *
     * @param scalar The input scalar used to generate the SphericalUnits.
     * @param step   The step value used to increment angles i and j while generating the SphericalUnits.
     * @return A set of SphericalUnits generated from the input scalar and step value.
     * @see <a href="https://en.wikipedia.org/wiki/Spherical_coordinate_system">Spherical coordinate system</a>
     * @see <a href="https://en.wikipedia.org/wiki/Inclination">Inclination</a>
     * @see <a href="https://en.wikipedia.org/wiki/Azimuth">Azimuth</a>
     * @see IScalar
     */
    public static Set<SphericalUnit> sphericalUnit180(IScalar scalar, double step) {
        Set<SphericalUnit> unitSet = new HashSet<>();

        for (int i = 0; i <= Utilities.RADIAN_180; i += step) {
            for (int j = 0; j <= Math.PI; j += step) {
                SphericalUnit unit = new SphericalUnit(i, j, scalar.getMagnitude());
                unitSet.add(unit);
            }
        }

        return unitSet;
    }

    /**
     * Generates a set of SphericalUnits using the given IScalar and step value.
     * This method generates the SphericalUnits by iterating through angles i and j in steps of the given value,
     * up to a maximum of 270 degrees, and then computing their respective magnitude, zenith and azimuth
     * values using the magnitude of the input scalar.
     *
     * @param scalar The input scalar used to generate the SphericalUnits.
     * @param step   The step value used to increment angles i and j while generating the SphericalUnits.
     * @return A set of SphericalUnits generated from the input scalar and step value.
     * @see <a href="https://en.wikipedia.org/wiki/Spherical_coordinate_system">Spherical coordinate system</a>
     * @see <a href="https://en.wikipedia.org/wiki/Inclination">Inclination</a>
     * @see <a href="https://en.wikipedia.org/wiki/Azimuth">Azimuth</a>
     * @see IScalar
     */
    public static Set<SphericalUnit> sphericalUnit270(IScalar scalar, double step) {
        Set<SphericalUnit> unitSet = new HashSet<>();

        for (int i = 0; i <= Utilities.RADIAN_270; i += step) {
            for (int j = 0; j <= Utilities.RADIAN_270; j += step) {
                SphericalUnit unit = new SphericalUnit(i, j, scalar.getMagnitude());
                unitSet.add(unit);
            }
        }

        return unitSet;
    }

    /**
     * Generates a set of SphericalUnits using the given IScalar and step value.
     * This method generates the SphericalUnits by iterating through angles i and j in steps of the given value,
     * up to a maximum of 360 degrees, and then computing their respective magnitude, zenith and azimuth
     * values using the magnitude of the input scalar.
     *
     * @param scalar The input scalar used to generate the SphericalUnits.
     * @param step   The step value used to increment angles i and j while generating the SphericalUnits.
     * @return A set of SphericalUnits generated from the input scalar and step value.
     * @see <a href="https://en.wikipedia.org/wiki/Spherical_coordinate_system">Spherical coordinate system</a>
     * @see <a href="https://en.wikipedia.org/wiki/Inclination">Inclination</a>
     * @see <a href="https://en.wikipedia.org/wiki/Azimuth">Azimuth</a>
     * @see IScalar
     */
    public static Set<SphericalUnit> sphericalUnit360(IScalar scalar, double step) {
        Set<SphericalUnit> unitSet = new HashSet<>();

        for (int i = 0; i < Utilities.RADIAN_360; i += step) {
            for (int j = 0; j < Utilities.RADIAN_360; j += step) {
                SphericalUnit unit = new SphericalUnit(i, j, scalar.getMagnitude());
                unitSet.add(unit);
            }
        }

        return unitSet;
    }
}
