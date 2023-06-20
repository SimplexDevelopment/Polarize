package io.github.simplexdev.caravan.base;

import io.github.simplexdev.caravan.CaravanAPI;

public final class Caravan implements CaravanAPI {
    private static final CaravanAPI api = new Caravan();

    public static CaravanAPI getAPI() {
        return api;
    }
}
