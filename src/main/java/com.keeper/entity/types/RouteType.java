package com.keeper.entity.types;

/*
 * Created by GoodforGod on 20.03.2017.
 */

/**
 * Default Comment
 */
public enum RouteType {
    COMMON(0),
    COMPLEX(1);

    private final int value;

    RouteType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
