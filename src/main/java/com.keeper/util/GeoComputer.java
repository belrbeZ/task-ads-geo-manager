package com.keeper.util;

/*
 * Created by GoodforGod on 20.03.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dao.Task;

/**
 * Computes Marks for Hot Coords and Routes
 */
public class GeoComputer {

    private static final double EarthRadiusInKm = 6378.1370D;
    private static final double DoubleToRadians = (Math.PI / 180D);

    private static double haversineInKm(double lat1, double lng1, double lat2, double lng2) {
        double dlng = (lng2 - lng1) * DoubleToRadians;
        double dlat = (lat2 - lat1) * DoubleToRadians;
        double a = Math.pow(Math.sin(dlat / 2D), 2D)
                + Math.cos(lat1 * DoubleToRadians)
                * Math.cos(lat2 * DoubleToRadians)
                * Math.pow(Math.sin(dlng / 2D), 2D);
        double c = 2D * Math.atan2(Math.sqrt(a), Math.sqrt(1D - a));

        return EarthRadiusInKm * c;
    }

    private static double haversineInMeters(double lat1, double lng1, double lat2, double lng2) {
       return haversineInKm(lat1, lng1, lat2, lng2) * 1000D;
    }

    public static boolean geoInRadius(Double lat1, Double lng1, Double lat2, Double lng2, Integer radius) {
        return haversineInMeters(lat1, lng1, lat2, lng2) <= radius;
    }

    public static boolean geoInRadius(GeoPoint geo, Task task) {
        return geoInRadius(geo.getLatitude(), geo.getLongitude(), task.getGeo().getLatitude(), task.getGeo().getLongitude(), geo.getRadius());
    }
}
