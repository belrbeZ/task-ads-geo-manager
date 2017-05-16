package com.keeper.model;

/**
 * Created by AlexVasil on 16.05.2017.
 *
 * @author AlexVasil
 */
public class SimpleResponse {

    private String message;

    public SimpleResponse() {
        message = "Response";
    }

    public SimpleResponse(String response) {
        message = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
