package com.keeper.service.testing;

/*
 * Created by @GoodforGod on 5.04.2017.
 */

import com.keeper.entity.dao.ZoneTest;
import com.keeper.repo.testing.ZoneTestRepository;
import com.keeper.service.impl.ModelRepoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Default Comment
 */
@Service
public class ZoneTestRepoService extends ModelRepoService<ZoneTest> implements IZoneTestService {

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
