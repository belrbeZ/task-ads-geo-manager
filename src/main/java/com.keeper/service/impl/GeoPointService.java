package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 02.05.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.repo.GeoPointRepository;
import com.keeper.service.IFeedSubmiter;
import com.keeper.service.IGeoPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
@Service
public class GeoPointService extends ModelRepoService<GeoPoint> implements IGeoPointService {

    private final GeoPointRepository repository;
    private final IFeedSubmiter feedSubmitService;

    @Autowired
    public GeoPointService(GeoPointRepository repository,
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
    public Optional<List<GeoPoint>> getAllByUserId(Long userId) {
        return repository.findAllByUserId(userId);
    }

    @Override
    public Optional<GeoPoint> add(GeoPoint model) {
        Optional<GeoPoint> geoUser = super.add(model);
        geoUser.ifPresent(feedSubmitService::submit);
        return geoUser;
    }
}
