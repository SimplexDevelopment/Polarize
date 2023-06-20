package io.github.simplexdev.polarize.math;

import io.github.simplexdev.polarize.api.spatial.IVector;
import io.github.simplexdev.polarize.cartesian.CartesianVector;

public class ScalarTriple {
    private final double productA;
    private final double productB;
    private final double productC;

    private final IVector scalarTripleProduct;

    public ScalarTriple(IVector productA, IVector productB, IVector productC) {
        this.productA = productA.dot(productB.multiply(productC));
        this.productB = productB.dot(productC.multiply(productA));
        this.productC = productC.dot(productA.multiply(productB));

        this.scalarTripleProduct = new CartesianVector(
                this.productA,
                this.productB,
                this.productC);
    }

    public double getProductA() {
        return productA;
    }

    public double getProductB() {
        return productB;
    }

    public double getProductC() {
        return productC;
    }

    public IVector getScalarTripleProduct() {
        return scalarTripleProduct;
    }
}