package io.github.simplexdev.polarize.log;

import java.util.logging.Logger;

public class PolarizeLogger {
    private static final Logger logger = Logger.getLogger("Polarize");

    private PolarizeLogger() {
        throw new AssertionError();
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void warning(String message) {
        logger.warning(message);
    }

    public static void warning(Throwable throwable) {
        logger.warning(throwable.getMessage());
    }

    public static void severe(String message) {
        logger.severe(message);
    }

    public static void severe(Throwable throwable) {
        logger.severe(throwable.getMessage());
    }
}
