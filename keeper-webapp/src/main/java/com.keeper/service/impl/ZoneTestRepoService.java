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
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Default Comment
 */
@Service
public class ZoneTestRepoService implements IZoneTestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ZoneTestRepoService.class);

    @Autowired
    private ZoneTestRepository repository;

    @Override
    public boolean isExists(Long id) {
        return false;
    }

    @Override
    public ZoneTest add(ZoneTest model) {
        return null;
    }

    @Override
    public ZoneTest get(Long id) {
        return null;
    }

    @Override
    public List<ZoneTest> getAll() {
        return null;
    }

    @Override
    public ZoneTest update(ZoneTest model) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
