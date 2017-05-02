package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 18.04.2017.
 */

import com.keeper.model.dao.Route;
import com.keeper.repo.RouteRepository;
import com.keeper.service.IFeedSubmitService;
import com.keeper.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
@Service
public class RouteService extends ModelRepoService<Route> implements IRouteService {

    private final RouteRepository repository;
    private final IFeedSubmitService feedSubmitService;

    @Autowired
    public RouteService(RouteRepository repository, IFeedSubmitService feedSubmitService) {
        this.repository = repository;
        this.primeRepository = repository;
        this.feedSubmitService = feedSubmitService;
    }

    @Override
    public List<Route> getEmptyList() {
        return Collections.emptyList();
    }

    @Override
    public Optional<Route> add(Route model) {
        Optional<Route> route = super.add(model);
        route.ifPresent(feedSubmitService::submit);
        return route;
    }

    @Override
    public List<Route> getAllByUserId(Long userId) {
        return repository.findAllByUserId(userId).orElse(getEmptyList());
    }
}
