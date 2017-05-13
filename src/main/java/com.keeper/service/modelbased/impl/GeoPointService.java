package com.keeper.service.modelbased.impl;

/*
 * Created by @GoodforGod on 02.05.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.repo.GeoPointRepository;
import com.keeper.service.core.IFeedSubmit;
import com.keeper.service.core.impl.FeedService;
import com.keeper.service.modelbased.IGeoPointService;
import com.keeper.util.ModelTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

import static com.keeper.util.resolvers.ErrorMessageResolver.*;

/**
 * Default Comment
 */
@Service
public class GeoPointService extends PrimeModelService<GeoPoint> implements IGeoPointService {

    private final GeoPointRepository repository;
    private final IFeedSubmit feedSubmitService;

    @Autowired
    public GeoPointService(GeoPointRepository repository,
                           FeedService feedSubmitService) {
        this.repository = repository;
        this.primeRepository = repository;
        this.feedSubmitService = feedSubmitService;
    }

    @PostConstruct
    public void setup() {
        try {
            getAll().ifPresent(feedSubmitService::loadPoints);
        } catch (Exception e) {
            LOGGER.error("NO POINTS LOADED! [FEED SERVICE]", e);
        }
    }

    @Override
    public Optional<List<GeoPoint>> getByUserId(Long userId) {
        if(invalidId(userId, GET_NULLABLE_ID + "USER"))
            return Optional.empty();

        return repository.findAllByUserId(userId);
    }

    @Transactional
    @Override
    public Optional<GeoPoint> saveDTO(GeoPointDTO model) {
        if(model == null) {
            LOGGER.warn(CREATE_MODEL_NULLABLE);
            return Optional.empty();
        }

        return save(ModelTranslator.toDAO(model));
    }

    @Transactional
    @Override
    public Optional<GeoPoint> updateDTO(GeoPointDTO model) {
        if(model == null) {
            LOGGER.warn(UPDATE_MODEL_NULLABLE);
            return Optional.empty();
        }

        Optional<GeoPoint> toSave = get(model.getId());

        if(!toSave.isPresent()) {
            LOGGER.warn(UPDATE_NOT_FOUND);
            return Optional.empty();
        }

        System.out.println("    getted for update:"+toSave.get());

        return super.save(ModelTranslator.updateDAO(toSave.get(), model));
    }

    @Transactional
    @Override
    public Optional<GeoPoint> save(GeoPoint model) {
        if(invalidModel(model, CREATE_MODEL_NULLABLE))
            return Optional.empty();

        Optional<GeoPoint> geoUser = super.save(model);
        geoUser.ifPresent(feedSubmitService::submit);
        return geoUser;
    }

    @Override
    public Optional<GeoPoint> update(GeoPoint model) {
        if(invalidModel(model, UPDATE_MODEL_NULLABLE))
            return Optional.empty();

        return save(model);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        if(invalidId(id, REMOVE_NULLABLE_ID))
            return;

        super.remove(id);
        feedSubmitService.removeGeo(id);
    }
}
