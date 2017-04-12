package com.keeper.managers;

/*
 * Created by @GoodforGod on 5.04.2017.
 */

import com.keeper.model.dao.Zone;
import com.keeper.model.dto.ZoneDTO;

/**
 * Default Comment
 */
public interface IZoneManager extends IModelManager<Zone, ZoneDTO> {
    ZoneDTO addRoutes(Long ownerId, ZoneDTO zone);

    ZoneDTO getRoutes(Long ownerId, ZoneDTO zoneId);

    ZoneDTO getAllRoutes();

    ZoneDTO updateRoute(Long ownerId, Long zoneId);

    void removeRoutes(Long ownerId, Long zoneId);
}
