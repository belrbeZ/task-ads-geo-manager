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

    private BigDecimal longtitude;
    private BigDecimal latitude;

    public SimpleGeoPoint(@GeoCoordinate BigDecimal longtitude,
                          @GeoCoordinate BigDecimal latitude) {
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    public BigDecimal getLongtitude() {
        return longtitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }
}
