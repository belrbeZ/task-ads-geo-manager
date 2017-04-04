package com.keeper.model.states;

/*
 * Created by GoodforGod on 20.03.2017.
 */

/**
 * Default Comment
 */
public enum TaskType {
    COMMON(0),
    CALL(1),
    ADVERTISE(2);

    private final int value;

    TaskType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
