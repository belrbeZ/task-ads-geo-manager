package com.keeper.service;

/*
 * Created by @GoodforGod on 5.04.2017.
 */

import com.keeper.entity.Zone;

/**
 * Default Comment
 */
public interface IZoneService {
    Zone addRoutes(Long ownerId, Zone zone);

    Zone getRoutes(Long ownerId, Long zoneId);

    Zone getAllRoutes();

    Zone updateRoute(Long ownerId, Long zoneId);

    void removeRoutes(Long ownerId, Long zoneId);
}
