package com.keeper.model.types;

/*
 * Created by GoodforGod on 21.03.2017.
 */

/**
 * Default Comment
 */
public enum PicType {
    EMPTY(-1),
    TASK(0),
    USER(1);

    private final int value;

    PicType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
