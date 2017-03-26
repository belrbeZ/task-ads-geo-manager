package com.keeper.entity;

/*
 * Created by GoodforGod on 26.03.2017.
 */

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Default Comment
 */
public class Token {

    public static final Token empty = new Token();

    public static final Integer DEFAULT_PERIOD = 24;

    private String value;

    private Timestamp validFor = Timestamp.valueOf(LocalDateTime.of(0,0,0,DEFAULT_PERIOD,0,0,0));

    //<editor-fold desc="GetterAndSetter">

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Timestamp getValidFor() {
        return validFor;
    }

    public void setValidFor(Timestamp validFor) {
        this.validFor = validFor;
    }
    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token = (Token) o;

        if (value != null ? !value.equals(token.value) : token.value != null) return false;
        return validFor != null ? validFor.equals(token.validFor) : token.validFor == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
