package com.keeper.service;

import com.keeper.model.dao.GeoPoint;

import java.util.List;

/**
 * Created by AlexVasil on 29.03.2017.
 *
 * @author AlexVasil
 *
 */
public interface IGeoPointService {
//    List<GeoPoint> getByUserId(Long ownerId);

    List<GeoPoint> updateGeoPoints(List<GeoPoint> geoPoints);
}
