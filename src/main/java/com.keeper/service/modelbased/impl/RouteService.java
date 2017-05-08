package com.keeper.service.modelbased.impl;

/*
 * Created by @GoodforGod on 18.04.2017.
 */

import com.keeper.model.dao.Route;
import com.keeper.model.dto.RouteDTO;
import com.keeper.repo.RouteRepository;
import com.keeper.service.util.IFeedSubmitService;
import com.keeper.service.util.impl.FeedService;
import com.keeper.service.modelbased.IRouteService;
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
public class RouteService extends ModelService<Route> implements IRouteService {

    private final RouteRepository repository;
    private final IFeedSubmitService feedSubmitService;

    @Autowired
    public RouteService(RouteRepository repository,
                        FeedService feedSubmitService) {
        this.repository = repository;
        this.primeRepository = repository;
        this.feedSubmitService = feedSubmitService;
    }

    @PostConstruct
    public void setup() {
        feedSubmitService.loadRoutes(getAll().orElse(getEmptyList()));
    }

    @Override
    public List<Route> getByUserId(Long userId) {
        return repository.findAllByUserId(userId).orElse(getEmptyList());
    }

    @Transactional
    @Override
    public Optional<Route> saveDTO(RouteDTO model) {
        if(model == null) {
            LOGGER.warn("Save NULLABLE dto");
            return Optional.empty();
        }

        return save(Translator.toDAO(model));
    }

    @Transactional
    @Override
    public Optional<Route> updateDTO(RouteDTO model) {
        if(model == null) {
            LOGGER.warn("Update NULLABLE dto");
            return Optional.empty();
        }

        return null;
    }

    @Transactional
    @Override
    public Optional<Route> save(Route model) {
        Optional<Route> route = super.save(model);
        route.ifPresent(feedSubmitService::submit);
        return route;
    }
}
