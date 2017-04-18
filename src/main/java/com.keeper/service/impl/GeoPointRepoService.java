package com.keeper.service.impl;

import com.keeper.model.dao.GeoPoint;
import com.keeper.repo.GeoPointRepository;
import com.keeper.service.IGeoPointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by AlexVasil on 29.03.2017.
 *
 * @author AlexVasil
 *
 */
@Service
public class GeoPointRepoService extends ModelRepoService<GeoPoint> implements IGeoPointService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeoPointRepoService.class);

    private final GeoPointRepository repository;

    @Autowired
    public GeoPointRepoService(GeoPointRepository repository) {
        this.repository = repository;
    }

    @Override
    public GeoPoint getEmpty() {
        return GeoPoint.EMPTY;
    }

    @Override
    public List<GeoPoint> getEmptyList() {
        return Collections.emptyList();
    }

    @Override
    public List<GeoPoint> getByUserId(Long ownerId) {
        return getEmptyList();
    }

    @Override
    public List<GeoPoint> updateGeoPoints(List<GeoPoint> geoPoints) {
        return getEmptyList();
    }
}
