package com.keeper.service.modelbased.impl;

/*
 * Created by @GoodforGod on 18.04.2017.
 */

import com.keeper.model.dao.Route;
import com.keeper.model.dto.RouteDTO;
import com.keeper.repo.RouteRepository;
import com.keeper.service.core.IFeedSubmit;
import com.keeper.service.core.impl.FeedService;
import com.keeper.service.modelbased.IRouteService;
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
public class RouteService extends PrimeModelService<Route, Long> implements IRouteService {

    private final RouteRepository repository;
    private final IFeedSubmit feedSubmitService;

    @Autowired
    public RouteService(RouteRepository repository,
                        FeedService feedSubmitService) {
        this.repository = repository;
        setup(repository);
        this.feedSubmitService = feedSubmitService;
    }

    @PostConstruct
    public void setup() {
        try {
            getAll().ifPresent(feedSubmitService::loadRoutes);
        } catch (Exception e) {
            logger.error("NO ROUTES LOADED! [FEED SERVICE]", e);
        }
    }

    @Override
    public Optional<List<Route>> getByUserId(Long userId) {
        if(invalidId(userId, REMOVE_NULLABLE_ID))
            return Optional.empty();

        return repository.findAllByUserId(userId);
    }

    @Transactional
    @Override
    public Optional<Route> saveDTO(RouteDTO model) {
        if(model == null) {
            logger.warn(CREATE_MODEL_NULLABLE);
            return Optional.empty();
        }

        return save(ModelTranslator.toDAO(model));
    }

    @Transactional
    @Override
    public Optional<Route> updateDTO(RouteDTO model) {
        if(model == null) {
            logger.warn(UPDATE_MODEL_NULLABLE);
            return Optional.empty();
        }

        Optional<Route> toSave = get(model.getId());

        if(!toSave.isPresent()) {
            logger.warn(UPDATE_NOT_FOUND);
            return Optional.empty();
        }

        return super.save(ModelTranslator.updateDAO(toSave.get(), model));
    }

    @Transactional
    @Override
    public Optional<Route> save(Route model) {
        if(invalidModel(model, CREATE_MODEL_NULLABLE))
            return Optional.empty();

        Optional<Route> route = super.save(model);
        route.ifPresent(feedSubmitService::submit);
        return route;
    }

    @Transactional
    @Override
    public Optional<Route> update(Route model) {
        return save(model);
    }
}
