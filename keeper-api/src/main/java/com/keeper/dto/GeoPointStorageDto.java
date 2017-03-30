package com.keeper.dto;

/*
 * Created by Alexandr Vasiliev on 30.03.2017.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Used in Location and Route to work with geoPoint set
 */
public abstract class GeoPointStorageDto {

    private Set<GeoPointDto> geoPoints = new HashSet<>();

    public Set<GeoPointDto> getGeoPoints() {
        return geoPoints;
    }

    public void setGeoPoints(Set<GeoPointDto> geoPoints) {
        this.geoPoints = geoPoints;
    }

    public GeoPointDto addCoordinate(GeoPointDto geoPoint) {
        this.geoPoints.add(geoPoint);
        return geoPoint;
    }

    public GeoPointDto removeCoordinate(GeoPointDto geoPoint) {
        this.geoPoints.remove(geoPoint);
        return geoPoint;
    }

    public GeoPointDto removeCoordinate(final Long geoPointId) {
         return this.geoPoints.stream()
                .filter(coordinate -> geoPointId.equals(coordinate.getId()))
                .findFirst()
                .orElse(null);
    }

}
