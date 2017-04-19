package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 9.04.2017.
 */

import com.keeper.model.dao.Zone;
import com.keeper.repo.ZoneRepository;
import com.keeper.service.IZoneService;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
    public List<Zone> getEmptyList() {
        return Collections.emptyList();
    }

    @Override
    public List<Zone> getByCountry(String country) {
        return (country != null && !country.isEmpty())
                ? repository.findByCountry(country).orElse(getEmptyList())
                : Collections.emptyList();
    }

    @Override
    public List<Zone> getByCity(String city) {
        return (city != null && !city.isEmpty())
                ? repository.findByCity(city).orElse(getEmptyList())
                : Collections.emptyList();
    }
}
