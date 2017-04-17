package com.keeper.model.types;

/*
 * Created by GoodforGod on 20.03.2017.
 */

/**
 * Default Comment
 */
public enum TaskState {
    UNKNOWN(-1),
    HIDEN(0),
    OKAY(1),
    CLOSED(2),
    REJECTED(3),
    BANNED(4);

    private final int value;

    TaskState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
