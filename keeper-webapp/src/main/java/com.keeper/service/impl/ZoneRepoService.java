package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 9.04.2017.
 */

import com.keeper.entity.dao.Zone;
import com.keeper.repo.ZoneRepository;
import com.keeper.service.IZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Default Comment
 */
@Service
public class ZoneRepoService extends ModelRepoService<Zone> implements IZoneService {

    private final ZoneRepository repository;

    @Autowired
    public ZoneRepoService(ZoneRepository repository) {
        this.repository = repository;
        this.primeRepository = repository;
    }

    @Override
    public List<Zone> getByCountry(String country) {
        return repository.findByCountry(country);
    }

    @Override
    public List<Zone> getByCity(String city) {
        return repository.findByCity(city);
    }
}
