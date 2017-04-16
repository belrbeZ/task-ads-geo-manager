package com.keeper.model;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Default Comment
 */
public class ModelLoggerManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModelLoggerManager.class);

    public static void logConstructorError(String msg) {
        LOGGER.error(msg);
    }

    public static void logConstructError(Throwable throwable) {
        LOGGER.error(throwable.getMessage(), throwable);
    }

    public static void logConstructError(String msg, Throwable throwable) {
        LOGGER.error(msg, throwable);
    }

    public static void logSetupError(String msg) {
        LOGGER.error(msg);
    }

    public static void logSetupError(Throwable throwable) {
        LOGGER.error(throwable.getMessage(), throwable);
    }

    public static void logSetupError(String msg, Throwable throwable) {
        LOGGER.error(msg, throwable);
    }
}
