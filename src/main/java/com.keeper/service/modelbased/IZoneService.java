package com.keeper.service.modelbased;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import com.keeper.model.dao.Zone;
import com.keeper.model.dto.ZoneDTO;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public interface IZoneService extends IModelDTOService<Zone,ZoneDTO> {
    Optional<Zone> getByUserId(Long userId);

    Optional<List<Zone>> getByCountry(String country);

    Optional<List<Zone>> getByCity(String city);

    /** TRANSACTIONAL */
    void removeByUserId(Long userId);
}
