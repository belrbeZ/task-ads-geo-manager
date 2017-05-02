package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 02.05.2017.
 */

import com.keeper.model.dao.GeoUser;
import com.keeper.repo.GeoUserRepository;
import com.keeper.service.IGeoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
@Service
public class GeoUserService extends ModelRepoService<GeoUser> implements IGeoUserService {

    private final GeoUserRepository repository;

    @Autowired
    public GeoUserService(GeoUserRepository repository) {
        this.repository = repository;
        this.primeRepository = repository;
    }

    @Override
    public Optional<List<GeoUser>> getAllByUserId(Long userId) {
        return repository.findAllByUserId(userId);

    }
}
