package com.keeper.entity.states;

/*
 * Created by @GoodforGod on 10.04.2017.
 */

/**
 * Default Comment
 */
public enum ErrorType {
    UNKNOWN("UNKNOWN ERROR!"),
    PASS("Incorrect Password!"),
    EMAIL("Incorrect Email!");

    private final String msg;

    ErrorType(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
