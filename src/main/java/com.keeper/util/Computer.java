package com.keeper.util;

/*
 * Created by GoodforGod on 20.03.2017.
 */

import com.keeper.model.dto.GeoPointDTO;
import com.keeper.model.dto.GeoUserDTO;

/**
 * Computes Marks for Hot Coords and Routes
 */
public class Computer {

    public static double haversine(double lat1, double lng1, double lat2, double lng2) {
        int r = 6371; // average radius of the earth in km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lng2 - lng1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        return r * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    }

    public static boolean geoInRadius(double lat1, double lng1, double lat2, double lng2, int radius) {
        return haversine(lat1, lng1, lat2, lng2) <= (double)radius / 1000;
    }

    public static boolean geoInRadius(String lat1, String lng1, String lat2, String lng2, int radius) {
        return haversine(Double.valueOf(lat1), Double.valueOf(lng1), Double.valueOf(lat2), Double.valueOf(lng2)) <= (double)radius / 1000;
    }

    public static boolean geoInRadius(String lat1, String lng1, Double lat2, Double lng2, int radius) {
        return haversine(Double.valueOf(lat1), Double.valueOf(lng1), lat2, lng2) <= (double)radius / 1000;
    }

    public static boolean geoInRadius(Double lat1, Double lng1, String lat2, String lng2, int radius) {
        return haversine(lat1, lng1, Double.valueOf(lat2), Double.valueOf(lng2)) <= (double)radius / 1000;
    }

    public static boolean geoInRadius(GeoPointDTO geo, String lat2, String lng2) {
        return haversine(Double.valueOf(geo.getLatitude()), Double.valueOf(geo.getLongitude()), Double.valueOf(lat2), Double.valueOf(lng2)) <= (double)geo.getRadius() / 1000;
    }

    public static boolean geoInRadius(GeoPointDTO geo, Double lat2, Double lng2) {
        return haversine(Double.valueOf(geo.getLatitude()), Double.valueOf(geo.getLongitude()), lat2, lng2) <= (double)geo.getRadius() / 1000;
    }

    public static boolean geoInRadius(String lat1, String lng1, GeoPointDTO geo, int radius) {
        return haversine(Double.valueOf(lat1), Double.valueOf(lng1), Double.valueOf(geo.getLatitude()), Double.valueOf(geo.getLongitude())) <= (double)radius / 1000;
    }

    public static boolean geoInRadius(Double lat1, Double lng1, GeoPointDTO geo, int radius) {
        return haversine(lat1, lng1, Double.valueOf(geo.getLatitude()), Double.valueOf(geo.getLongitude())) <= (double)radius / 1000;
    }
}
