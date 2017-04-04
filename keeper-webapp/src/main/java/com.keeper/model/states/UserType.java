package com.keeper.model.states;

/*
 * Created by GoodforGod on 20.03.2017.
 */

/**
 * Default Comment
 */
public enum UserType {
    USER(0),
    COMMUNITY(1),
    ORGANIZATION(2),
    ENTERPRISE(3);

    private final int value;

    UserType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
