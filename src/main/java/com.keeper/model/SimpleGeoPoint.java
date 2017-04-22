package com.keeper.model;

/*
 * Created by @GoodforGod on 16.04.2017.
 */

import com.keeper.util.annotations.GeoCoordinate;

import java.math.BigDecimal;

/**
 * Default Comment
 */
public class SimpleGeoPoint {

    private String longtitude;
    private String latitude;

    public SimpleGeoPoint(@GeoCoordinate String longtitude,
                          @GeoCoordinate String latitude) {
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public String getLatitude() {
        return latitude;
    }

    @Override
    public String toString() {
        return (new StringBuilder().append("long:").append(String.valueOf(longtitude)).append(" lat:").append(String.valueOf(latitude))).toString();
    }

}
