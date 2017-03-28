package com.keeper.entity;

/*
 * Created by GoodforGod on 21.03.2017.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Used in Location and Route to work with geoPoint set
 */
public abstract class GeoPointStorage {

    private Set<GeoPoint> geoPoints = new HashSet<>();

    public Set<GeoPoint> getGeoPoints() {
        return geoPoints;
    }

    public void setGeoPoints(Set<GeoPoint> geoPoints) {
        this.geoPoints = geoPoints;
    }

    public GeoPoint addCoordinate(GeoPoint geoPoint) {
        this.geoPoints.add(geoPoint);
        return geoPoint;
    }

    public GeoPoint removeCoordinate(GeoPoint geoPoint) {
        this.geoPoints.remove(geoPoint);
        return geoPoint;
    }

    public GeoPoint removeCoordinate(final Long geoPointId) {
         return this.geoPoints.stream()
                .filter(coordinate -> geoPointId.equals(coordinate.getId()))
                .findFirst()
                .orElse(null);
    }

}
