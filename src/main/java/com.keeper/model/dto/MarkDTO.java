package com.keeper.model.dto;

/*
 * Created by GoodforGod on 21.03.2017.
 */

/**
 * Indicates how HOT is route or coordinate for our users
 *
 * IN MEMORY
 */
public class MarkDTO {

    public static final MarkDTO EMPTY = new MarkDTO();

    private Double value;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
