package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 5.04.2017.
 */

import com.keeper.entity.ZoneTest;
import com.keeper.repo.ZoneTestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Default Comment
 */
@Service
public class ZoneTestRepoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeoPointRepoService.class);

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ZoneTestRepository repository;

    public ZoneTest add(ZoneTest zone) {
        return null;
    }

    public ZoneTest get(Long userId) {
        return null;
    }

    public ZoneTest update(ZoneTest zone) {
        return null;
    }

    public void remove(Long userId) {

    }
}
