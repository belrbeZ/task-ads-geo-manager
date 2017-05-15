package com.keeper.model.util;

/*
 * Created by @GoodforGod on 01.05.2017.
 */

import com.keeper.util.Validator;
import com.keeper.util.validation.annotation.GeoList;

import java.util.Collections;
import java.util.List;

/**
 * Default Comment
 */
public class SimpleRoute {

    private List<Double> longtitudes;
    private List<Double> latitudes;
    private double radius;

    public SimpleRoute() {
        this.latitudes = Collections.emptyList();
        this.longtitudes = Collections.emptyList();
        this.radius = 0;
    }

    public SimpleRoute(List<Double> longtitudes, List<Double> latitudes) {
        this.latitudes = longtitudes;
        this.latitudes = latitudes;
    }

    public SimpleRoute(List<Double> longtitudes, List<Double> latitudes, Double radius) {
        this(longtitudes, latitudes);
        this.radius = radius;
    }

    public SimpleRoute(@GeoList String[] longtitudes,
                       @GeoList String[] latitudes) {
        this.latitudes = Validator.convertGeoArrayToList(longtitudes);
        this.latitudes = Validator.convertGeoArrayToList(latitudes);
    }

    public SimpleRoute(@GeoList String[] longtitudes,
                       @GeoList String[] latitudes,
                       Double radius) {
        this(longtitudes, latitudes);
        this.radius = radius;
    }

    //<editor-fold desc="GetterAndSetter">

    public List<Double> getLongtitudes() {
        return longtitudes;
    }

    public void setLongtitudes(List<Double> longtitudes) {
        this.longtitudes = longtitudes;
    }

    public List<Double> getLatitudes() {
        return latitudes;
    }

    public void setLatitudes(List<Double> latitudes) {
        this.latitudes = latitudes;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    //</editor-fold>

}
