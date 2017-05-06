package com.keeper.model;

/*
 * Created by @GoodforGod on 16.04.2017.
 */

import com.keeper.util.validation.annotation.GeoCoordinate;

/**
 * Default Comment
 */
public class SimpleGeoPoint {

    public static final SimpleGeoPoint EMPTY = new SimpleGeoPoint();

    private Double longitude;
    private Double latitude;
    private Integer radius;

    private SimpleGeoPoint(){
        this.latitude = 0.;
        this.longitude = 0.;
        this.radius = 0;
    }

    public SimpleGeoPoint(@GeoCoordinate String latitude,
                          @GeoCoordinate String longitude) {
        this.longitude = Double.valueOf(longitude);
        this.latitude = Double.valueOf(latitude);
        this.radius = 5;
    }

    public SimpleGeoPoint(@GeoCoordinate String latitude,
                          @GeoCoordinate String longitude,
                          Integer radius) {
        this(longitude, latitude);
        this.radius = radius;
    }

    //<editor-fold desc="GetterAndSetter">

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(@GeoCoordinate String longtitude) {
        this.longitude = Double.valueOf(longtitude);
    }

    public void setLatitude(@GeoCoordinate String latitude) {
        this.latitude = Double.valueOf(latitude);
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "long: " + longitude + ", lat: " + latitude;
    }

}
