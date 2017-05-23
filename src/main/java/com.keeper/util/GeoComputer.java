package com.keeper.util;

/*
 * Created by GoodforGod on 20.03.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.util.SimpleGeoPoint;
import com.keeper.model.util.SimpleRoute;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Computes Marks for Hot Geo Points and Routes
 */
public class GeoComputer {

    private static final double EarthRadiusInKm = 6378.1370D;
    private static final double DoubleToRadians = (Math.PI / 180D);

    /**
     * @return radius between two geo points
     */
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

    /**
     * @return is second geo point in radius of first
     */
    public static boolean geoInRadius(Double lat1, Double lng1, Double lat2, Double lng2, Integer radius) {
        return haversineInMeters(lat1, lng1, lat2, lng2) <= radius;
    }

    public static boolean geoInRadius(GeoPoint origin, SimpleGeoPoint target) {
        return geoInRadius(origin.getLatitude(), origin.getLongitude(), target.getLatitude(), target.getLongitude(), origin.getRadius());
    }

    public static boolean geoInRadius(SimpleGeoPoint origin, SimpleGeoPoint target) {
        return geoInRadius(origin.getLatitude(), origin.getLongitude(), target.getLatitude(), target.getLongitude(), origin.getRadius());
    }

    public static boolean geoInRouteRadius(SimpleGeoPoint origin, SimpleRoute route) {
        Iterator<SimpleGeoPoint> geoIterator = route.getGeos().iterator();

        boolean result = false;

        while (geoIterator.hasNext()) {
            SimpleGeoPoint startPoint = geoIterator.next();
            result = geoInRadius(origin, startPoint);

            if(result) break;

            if(geoIterator.hasNext()) {
                SimpleGeoPoint nextPoint = geoIterator.next();

                int stepsToDo = (int)(haversineInMeters(startPoint.getLatitude(), startPoint.getLongitude(), nextPoint.getLatitude(), nextPoint.getLongitude()) / route.getRadius());

                // Useless, all should be recreated
                result = geoInRadius(origin, nextPoint);

                if(result) break;
            }
        }

        return result;
    }

    public static boolean geoInsidePolygon(SimpleGeoPoint geo, ArrayList<Double> lat, ArrayList<Double> lng) {
        double angle = 0;
        double point1_lat;
        double point1_long;
        double point2_lat;
        double point2_long;

        for (int i = 0; i < lat.size(); i++) {
            point1_lat = lat.get(i) - geo.getLatitude();
            point1_long = lng.get(i) - geo.getLongitude();
            point2_lat = lat.get((i + 1) % lat.size()) - geo.getLatitude();
            point2_long = lng.get((i + 1) % lat.size()) - geo.getLongitude();
            angle += Angle2D(point1_lat, point1_long, point2_lat, point2_long);
        }

        return !(Math.abs(angle) < Math.PI);
    }

    private static final Double TWO_PI = Math.PI * 2;

    private static double Angle2D(double y1, double x1, double y2, double x2) {
        double theta = Math.atan2(y2, x2) - Math.atan2(y1, x1);

        while (theta > Math.PI)
            theta -= TWO_PI;

        while (theta < -Math.PI)
            theta += TWO_PI;

        return theta;
    }

    /**
     * @param lat1 & lng1 POINT #1
     * @param lat2 & lng2 POINT #2 to check
     * @param radius is POINT #1 radius
     * @param percentageError is error for radius for calculations
     */
    public static boolean geoWithInRange(double lat1, double lng1, double lat2, double lng2,
                                         Integer radius, Integer percentageError) {
        double radiusError = (percentageError != null && percentageError > 0 && percentageError <= 100)
                ? (double) percentageError * .01D
                : .05D;

        double radiusWithError = radius + radius * radiusError;

        return haversineInMeters(lat1, lng1, lat2, lng2) <= radiusWithError;
    }

    public static boolean geoWithInRange(GeoPoint origin, SimpleGeoPoint target, Integer error) {
        return geoWithInRange(origin.getLatitude(), origin.getLongitude(),
                target.getLatitude(), target.getLongitude(),
                origin.getRadius(), error);
    }

    public static boolean geoWithInRange(SimpleGeoPoint origin, SimpleGeoPoint target, Integer error) {
        return geoWithInRange(origin.getLatitude(), origin.getLongitude(),
                target.getLatitude(), target.getLongitude(),
                origin.getRadius(), error);
    }
}
