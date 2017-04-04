package com.keeper.service;

/*
 * Created by GoodforGod on 23.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.model.dao.GeoPoint;

import java.util.List;

/**
 * Default Comment
 */
public interface IGeoPointService {
    List<GeoPoint> addGeoPoints(Long userId, List<GeoPoint> geoPoints);

    List<GeoPoint> getGeoPoints(Long userId, List<Long> geoPointsIds);

    List<GeoPoint> getAllGeoPoints();

    List<GeoPoint> updateGeoPoints(Long userId, List<GeoPoint> geoPoints);

    void removeGeoPoints(Long userId, List<Long> geoPointsIds);
}
