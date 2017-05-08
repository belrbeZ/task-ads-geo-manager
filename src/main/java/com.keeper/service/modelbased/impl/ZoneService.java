package com.keeper.service.modelbased.impl;

/*
 * Created by @GoodforGod on 9.04.2017.
 */

import com.keeper.model.dao.Zone;
import com.keeper.model.dto.ZoneDTO;
import com.keeper.repo.ZoneRepository;
import com.keeper.service.modelbased.IZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
@Service
public class ZoneService extends ModelService<Zone> implements IZoneService {

    private final ZoneRepository repository;

    @Autowired
    public ZoneService(ZoneRepository repository) {
        this.repository = repository;
        this.primeRepository = repository;
    }

    @Override
    public Optional<Zone> getByUserId(Long userId) {
        if (userId == null) {
            LOGGER.warn("Get by NULLABLE userId");
            return Optional.empty();
        }

        return repository.findByUserId(userId);
    }

    @Override
    public Optional<List<Zone>> getByCountry(String country) {
        if (country == null || country.isEmpty()) {
            LOGGER.warn("Get by NULLABLE country");
            return Optional.empty();
        }

        return repository.findByCountry(country);
    }

    @Override
    public Optional<List<Zone>> getByCity(String city) {
        if (city == null || city.isEmpty()) {
            LOGGER.warn("Get by NULLABLE city");
            return Optional.empty();
        }

        return repository.findByCity(city);
    }

    @Transactional
    @Override
    public Optional<Zone> saveDTO(ZoneDTO model) {
        if(model == null) {
            LOGGER.warn("Save NULLABLE dto");
            return Optional.empty();
        }

        return null;
    }

    @Transactional
    @Override
    public Optional<Zone> updateDTO(ZoneDTO model) {
        if(model == null) {
            LOGGER.warn("Update NULLABLE dto");
            return Optional.empty();
        }

        return null;
    }

    @Transactional
    @Override
    public void removeByUserId(Long userId) {
        if (userId == null) {
            LOGGER.warn("Get by NULLABLE country");
            return;
        }

        repository.removeByUserId(userId);
    }
}
