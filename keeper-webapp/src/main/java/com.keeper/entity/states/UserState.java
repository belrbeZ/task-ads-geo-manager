package com.keeper.entity.states;

/*
 * Created by GoodforGod on 20.03.2017.
 */

/**
 * Default Comment
 */
public enum UserState {
    AWAIT_VERIFICATION(0),
    REJECTED(2),
    VERIFIED(1);

    private final int value;

    UserState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
