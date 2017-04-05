package com.keeper.service.impl;

import com.keeper.entity.GeoPoint;
import com.keeper.repo.GeoPointRepository;
import com.keeper.service.IGeoPointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by AlexVasil on 29.03.2017.
 *
 * @author AlexVasil
 *
 */
@Service(value = "geoPointService")
public class GeoPointRepoService implements IGeoPointService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeoPointRepoService.class);

//    @Autowired
//    private GeoPointRepository geoPointRepository;

    @Override
    public List<GeoPoint> addGeoPoints(Long ownerId, List<GeoPoint> geoPoints) {
        return null;
    }

    @Override
    public List<GeoPoint> getGeoPoints(Long ownerId, List<Long> geoPointsIds) {
        return null;
    }

    @Override
    public List<GeoPoint> getAllGeoPoints() {
        return null;
    }

    @Override
    public List<GeoPoint> updateGeoPoints(Long ownerId, List<GeoPoint> geoPoints) {
        return null;
    }

    @Override
    public void removeGeoPoints(Long ownerId, List<Long> geoPointsIds) {

    }
}
