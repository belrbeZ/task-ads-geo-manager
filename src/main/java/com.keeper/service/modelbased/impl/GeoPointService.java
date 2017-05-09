package com.keeper.service.modelbased.impl;

/*
 * Created by @GoodforGod on 02.05.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.repo.GeoPointRepository;
import com.keeper.service.core.IFeedSubmitService;
import com.keeper.service.core.impl.FeedService;
import com.keeper.service.modelbased.IGeoPointService;
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
    private final IFeedSubmitService feedSubmitService;

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
        if(userId == null) {
            LOGGER.warn("Save NULLABLE dto");
            return Optional.empty();
        }

        return repository.findAllByUserId(userId);
    }

    @Transactional
    @Override
    public Optional<GeoPoint> saveDTO(GeoPointDTO model) {
        if(model == null) {
            LOGGER.warn("Save NULLABLE dto");
            return Optional.empty();
        }

        return save(Translator.toDAO(model));
    }

    @Transactional
    @Override
    public Optional<GeoPoint> updateDTO(GeoPointDTO model) {
        if(model == null) {
            LOGGER.warn("Update NULLABLE dto");
            return Optional.empty();
        }

        Optional<GeoPoint> toSave = get(model.getId());

        if(!toSave.isPresent()) {
            LOGGER.warn("Update model which doesn't exist");
            return Optional.empty();
        }

        return super.save(Translator.updateDAO(toSave.get(), model));
    }

    @Transactional
    @Override
    public Optional<GeoPoint> save(GeoPoint model) {
        if(model == null) {
            LOGGER.warn("Save NULLABLE dto");
            return Optional.empty();
        }

        Optional<GeoPoint> geoUser = super.save(model);
        geoUser.ifPresent(feedSubmitService::submit);
        return geoUser;
    }

    @Override
    public Optional<GeoPoint> update(GeoPoint model) {
        return save(model);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        super.remove(id);
        feedSubmitService.removeGeo(id);
    }
}
