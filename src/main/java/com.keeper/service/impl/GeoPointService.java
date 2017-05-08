package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 02.05.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.repo.GeoPointRepository;
import com.keeper.service.IFeedSubmiter;
import com.keeper.service.IGeoPointService;
import com.keeper.util.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
@Service
public class GeoPointService extends ModelService<GeoPoint> implements IGeoPointService {

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
    public Optional<List<GeoPoint>> getByUserId(Long userId) {
        return repository.findAllByUserId(userId);
    }

    @Transactional
    @Override
    public Optional<GeoPoint> saveDTO(GeoPointDTO model) {
        return save(Translator.toDAO(model));
    }

    @Transactional
    @Override
    public Optional<GeoPoint> updateDTO(GeoPointDTO model) {
        return null;
    }

    @Transactional
    @Override
    public Optional<GeoPoint> save(GeoPoint model) {
        Optional<GeoPoint> geoUser = super.save(model);
        geoUser.ifPresent(feedSubmitService::submit);
        return geoUser;
    }
}
