package com.keeper.entity;

/*
 * Created by GoodforGod on 21.03.2017.
 */

/**
 * Indicates how HOT is route or coordinate for our users
 *
 * IN MEMORY
 */
public class Mark implements IModel<Long>{

    public static Mark empty = new Mark();

    private Double value;

    //<editor-fold desc="GetterAdnSetter">

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
    //</editor-fold>


    @Override
    public Long getId() {
        return null;
    }
}
