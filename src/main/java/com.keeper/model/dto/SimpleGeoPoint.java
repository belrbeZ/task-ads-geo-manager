package com.keeper.model.dto;

/*
 * Created by @GoodforGod on 16.04.2017.
 */

import com.keeper.util.validation.annotation.Geo;

import javax.validation.constraints.NotNull;

/**
 * Default Comment
 */
public class SimpleGeoPoint {

    public static final SimpleGeoPoint EMPTY = new SimpleGeoPoint();

    private Double longitude;
    private Double latitude;
    private Integer radius;

    private SimpleGeoPoint() {
        this.latitude = 0.;
        this.longitude = 0.;
        this.radius = 0;
    }

    public SimpleGeoPoint(@Geo String latitude,
                          @Geo String longitude) {
        this.latitude = Double.valueOf(latitude);
        this.longitude = Double.valueOf(longitude);
        this.radius = 5;
    }

    public SimpleGeoPoint(@Geo String latitude,
                          @Geo String longitude,
                          @NotNull Integer radius) {
        this(latitude, longitude);
        this.radius = radius;
    }

    //<editor-fold desc="GetterAndSetter">

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLongitude(@Geo String longtitude) {
        this.longitude = Double.valueOf(longtitude);
    }

    public void setLatitude(@Geo String latitude) {
        this.latitude = Double.valueOf(latitude);
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(@NotNull Integer radius) {
        this.radius = radius;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "long: " + longitude + ", lat: " + latitude;
    }

}
