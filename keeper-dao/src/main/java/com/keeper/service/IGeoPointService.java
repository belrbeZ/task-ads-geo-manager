package com.keeper.service;

import com.keeper.entity.GeoPoint;

import java.util.List;

/**
 * Created by AlexVasil on 29.03.2017.
 *
 * @author AlexVasil
 *
 */
public interface IGeoPointService {
    List<GeoPoint> addGeoPoints(Long ownerId, List<GeoPoint> geoPoints);

    List<GeoPoint> getGeoPoints(Long ownerId, List<Long> geoPointsIds);

    List<GeoPoint> getAllGeoPoints();

    List<GeoPoint> updateGeoPoints(Long ownerId, List<GeoPoint> geoPoints);

    void removeGeoPoints(Long ownerId, List<Long> geoPointsIds);
}
