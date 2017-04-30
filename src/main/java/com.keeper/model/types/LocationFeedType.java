package com.keeper.model.types;

/*
 * Created by @GoodforGod on 30.04.2017.
 */

/**
 * Default Comment
 */
public enum LocationFeedType {
    ROUTE(0),
    COMMON(1),
    COMPLEX(2);

    private final int value;

    LocationFeedType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
