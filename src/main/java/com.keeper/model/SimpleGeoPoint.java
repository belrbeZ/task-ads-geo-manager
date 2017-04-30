package com.keeper.model;

/*
 * Created by @GoodforGod on 16.04.2017.
 */

import com.keeper.util.validation.annotation.GeoCoordinate;

/**
 * Default Comment
 */
public class SimpleGeoPoint {

    private Double longtitude;
    private Double latitude;
    private Double radius;

    public SimpleGeoPoint(){ }

    public SimpleGeoPoint(@GeoCoordinate String longtitude,
                          @GeoCoordinate String latitude,
                          double radius) {
        this.longtitude = Double.valueOf(longtitude);
        this.latitude = Double.valueOf(latitude);
        this.radius = radius;
    }

    public SimpleGeoPoint(@GeoCoordinate String longtitude,
                          @GeoCoordinate String latitude,
                          int radius) {
        this(longtitude, latitude, (double)radius / 1000);
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongtitude(@GeoCoordinate String longtitude) {
        this.longtitude = Double.valueOf(longtitude);
    }

    public void setLatitude(@GeoCoordinate String latitude) {
        this.latitude = Double.valueOf(latitude);
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "long: " + longtitude + ", lat: " + latitude;
    }

}
