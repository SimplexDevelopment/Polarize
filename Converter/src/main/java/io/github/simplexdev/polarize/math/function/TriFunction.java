package io.github.simplexdev.polarize.math.function;

@FunctionalInterface
public interface TriFunction<T, S, U, V> {
    V apply(T t, S s, U u);
}
