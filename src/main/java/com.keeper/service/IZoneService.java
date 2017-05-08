package com.keeper.service;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import com.keeper.model.dao.Zone;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public interface IZoneService extends IModelService<Zone> {
    Optional<Zone> getByUserId(Long userId);

    Optional<List<Zone>> getByCountry(String country);

    Optional<List<Zone>> getByCity(String city);

    /**
     * TRANSACTIONAL
     */
    void removeByUserId(Long userId);
}
