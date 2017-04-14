package com.keeper.model.types;

/*
 * Created by GoodforGod on 20.03.2017.
 */

/**
 * Default Comment
 */
public enum TaskType {
    EMPTY(0),
    COMMON(1),
    CALL(2),
    ADVERTISE(3);

    private final int value;

    TaskType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
