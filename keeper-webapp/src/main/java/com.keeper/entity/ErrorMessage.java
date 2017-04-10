package com.keeper.entity;

/*
 * Created by @GoodforGod on 10.04.2017.
 */

import com.keeper.entity.states.ErrorType;

/**
 * Default Comment
 */
public class ErrorMessage {

    private String msg;

    public ErrorMessage(ErrorType type) {
        this.msg = type.getMsg();
    }

    public ErrorMessage(Throwable error) {
        this.msg = error.getMessage();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
