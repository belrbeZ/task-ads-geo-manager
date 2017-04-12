package com.keeper.entity.types;

/*
 * Created by GoodforGod on 21.03.2017.
 */

import javax.persistence.Embeddable;

/**
 * Default Comment
 */
public enum PicType {
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
