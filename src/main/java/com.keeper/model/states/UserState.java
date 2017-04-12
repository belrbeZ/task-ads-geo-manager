package com.keeper.model.states;

/*
 * Created by GoodforGod on 20.03.2017.
 */

/**
 * Default Comment
 */
public enum UserState {
    UNKNOWN(-1),
    AWAIT_VERIFICATION(1),
    REJECTED(2),
    VERIFIED(10);

    private final int value;

    UserState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
