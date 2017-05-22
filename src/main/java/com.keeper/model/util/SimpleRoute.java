package com.keeper.model.util;

/*
 * Created by @GoodforGod on 01.05.2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Default Comment
 */
public class SimpleRoute {

    private List<SimpleGeoPoint> geos;
    private double radius;

    public SimpleRoute() {
        this.geos = new ArrayList<>();
        this.radius = 10;
    }

    public SimpleRoute(List<Double> longitudes, List<Double> latitudes) {
        this();
        if(longitudes == null || longitudes.isEmpty() || latitudes == null || latitudes.isEmpty())
            throw new NullPointerException("Nullable Latitude or longitude");
        if(longitudes.size() != latitudes.size())
            throw new NullPointerException("Latitude size NOT EQUAL Longitude size");

        for(int i = 0; i < latitudes.size(); i++)
            geos.add(new SimpleGeoPoint(latitudes.get(i).toString(), longitudes.get(i).toString()));
    }

    public SimpleRoute(List<Double> longtitudes, List<Double> latitudes, Double radius) {
        this(longtitudes, latitudes);
        this.radius = radius;
    }

    public SimpleRoute(String[] longitudes,
                       String[] latitudes) {
        this();
        if(longitudes == null || longitudes.length == 0 || latitudes == null || latitudes.length == 0)
            throw new NullPointerException("Nullable Latitude or longitude");
        if(longitudes.length != latitudes.length)
            throw new NullPointerException("Latitude size NOT EQUAL Longitude size");

        for(int i = 0; i < latitudes.length; i++)
            geos.add(new SimpleGeoPoint(latitudes[i], longitudes[i]));
    }

    public SimpleRoute(String[] longtitudes,
                       String[] latitudes,
                       Double radius) {
        this(longtitudes, latitudes);
        this.radius = radius;
    }

    //<editor-fold desc="GetterAndSetter">

    public List<SimpleGeoPoint> getGeos() {
        return geos;
    }

    public void setGeos(List<SimpleGeoPoint> geos) {
        this.geos = geos;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    //</editor-fold>
}
