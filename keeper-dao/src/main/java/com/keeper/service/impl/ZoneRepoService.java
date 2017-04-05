package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 5.04.2017.
 */

import com.keeper.entity.Zone;
import com.keeper.repo.ZoneRepository;
import com.keeper.service.IZoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Default Comment
 */
public class ZoneRepoService implements IZoneService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeoPointRepoService.class);

    @Autowired
    private ZoneRepository repository;

    @Override
    public Zone addRoutes(Long userId, Zone zone) {
        return null;
    }

    @Override
    public Zone getRoutes(Long userId, Long zoneId) {
        return null;
    }

    @Override
    public Zone getAllRoutes() {
        return null;
    }

    @Override
    public Zone updateRoute(Long userId, Long zoneId) {
        return null;
    }

    @Override
    public void removeRoutes(Long userId, Long zoneId) {

    }
}
