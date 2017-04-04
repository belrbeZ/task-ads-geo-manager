package com.keeper.service.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.repo.GeoPointRepository;
import com.keeper.model.dao.GeoPoint;
import com.keeper.service.IGeoPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Repository Service to work with Locations
 */
@Service
public class GeoPointRepoService implements IGeoPointService {

    @Autowired
    private GeoPointRepository repository;

    @Override
    public List<GeoPoint> addGeoPoints(Long userId, List<GeoPoint> geoPoints) {
        return null;
    }

    @Override
    public List<GeoPoint> getGeoPoints(Long userId, List<Long> geoPointsIds) {
        return null;
    }

    @Override
    public List<GeoPoint> getAllGeoPoints() {
        return null;
    }

    @Override
    public List<GeoPoint> updateGeoPoints(Long userId, List<GeoPoint> geoPoints) {
        return null;
    }

    @Override
    public void removeGeoPoints(Long userId, List<Long> geoPointsIds) {

    }
}
