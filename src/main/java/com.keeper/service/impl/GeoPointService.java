package com.keeper.service.impl;

import com.keeper.model.dao.GeoPoint;
import com.keeper.repo.GeoPointRepository;
import com.keeper.service.IFeedSubmitService;
import com.keeper.service.IGeoPointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by AlexVasil on 29.03.2017.
 *
 * @author AlexVasil
 *
 */
@Service
public class GeoPointService extends ModelRepoService<GeoPoint> implements IGeoPointService {

    private final GeoPointRepository repository;
    private final IFeedSubmitService feedSubmitService;

    @Autowired
    public GeoPointService(GeoPointRepository repository, FeedService feedSubmitService) {
        this.repository = repository;
        this.primeRepository = repository;
        this.feedSubmitService = feedSubmitService;
    }

    @Override
    public GeoPoint getEmpty() {
        return GeoPoint.EMPTY;
    }

    @Override
    public List<GeoPoint> getEmptyList() {
        return Collections.emptyList();
    }

    @Override
    public Optional<GeoPoint> add(GeoPoint model) {
        Optional<GeoPoint> point = super.add(model);
        point.ifPresent(feedSubmitService::submit);
        return point;
    }
}
