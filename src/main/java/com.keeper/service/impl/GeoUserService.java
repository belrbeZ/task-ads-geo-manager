package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 02.05.2017.
 */

import com.keeper.model.dao.GeoUser;
import com.keeper.repo.GeoUserRepository;
import com.keeper.service.IFeedSubmiter;
import com.keeper.service.IGeoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
@Service
public class GeoUserService extends ModelRepoService<GeoUser> implements IGeoUserService {

    private final GeoUserRepository repository;
    private final IFeedSubmiter feedSubmitService;

    @Autowired
    public GeoUserService(GeoUserRepository repository,
                          FeedService feedSubmitService) {
        this.repository = repository;
        this.primeRepository = repository;
        this.feedSubmitService = feedSubmitService;
    }

    @PostConstruct
    public void setup() {
        feedSubmitService.loadPoints(getAll().orElse(getEmptyList()));
    }

    @Override
    public Optional<List<GeoUser>> getAllByUserId(Long userId) {
        return repository.findAllByUserId(userId);
    }

    @Override
    public Optional<GeoUser> add(GeoUser model) {
        Optional<GeoUser> geoUser = super.add(model);
        geoUser.ifPresent(feedSubmitService::submit);
        return geoUser;
    }
}
