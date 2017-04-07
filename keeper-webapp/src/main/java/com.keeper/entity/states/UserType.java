package com.keeper.entity.states;

/*
 * Created by GoodforGod on 20.03.2017.
 */

/**
 * Default Comment
 */
public enum UserType {
    EMPTY(-1),
    UNKNOWN(0),
    USER(10),
    COMMUNITY(20),
    ORGANIZATION(30),
    ENTERPRISE(40);

    private final int value;

    UserType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
