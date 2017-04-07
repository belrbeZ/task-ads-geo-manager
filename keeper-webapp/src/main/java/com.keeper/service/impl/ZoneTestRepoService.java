package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 5.04.2017.
 */

import com.keeper.entity.dao.ZoneTest;
import com.keeper.repo.ZoneTestRepository;
import com.keeper.service.IZoneTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Default Comment
 */
@Service
public class ZoneTestRepoService extends ModelRepoService<ZoneTest> implements IZoneTestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZoneTestRepoService.class);

    private final ZoneTestRepository repository;

    @Autowired
    public ZoneTestRepoService(ZoneTestRepository repository) {
        this.repository = repository;
        this.primeRepository = repository;
    }

    @Override
    public List<ZoneTest> getByCountry(String country) {
        return repository.findByCountry(country);
    }

    @Override
    public List<ZoneTest> getByCity(String city) {
        return repository.findByCity(city);
    }
}
