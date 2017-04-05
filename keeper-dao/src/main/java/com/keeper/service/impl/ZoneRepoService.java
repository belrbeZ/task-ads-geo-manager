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
    public Zone add(Zone zone) {
        return null;
    }

    @Override
    public Zone get(Long userId) {
        return null;
    }

    @Override
    public Zone update(Zone zone) {
        return null;
    }

    @Override
    public void remove(Long userId) {

    }
}
