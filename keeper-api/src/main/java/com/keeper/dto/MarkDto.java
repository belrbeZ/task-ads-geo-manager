package com.keeper.dto;

/**
 * Created by Alexandr Vasiliev on 30.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */
public class MarkDto {

    public static MarkDto empty = new MarkDto();

    private Double value;

    //<editor-fold desc="GetterAdnSetter">

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
    //</editor-fold>


}
