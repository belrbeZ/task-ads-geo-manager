package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 18.04.2017.
 */

import com.keeper.model.dao.Route;
import com.keeper.repo.RouteRepository;
import com.keeper.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Default Comment
 */
@Service
public class RouteService extends ModelRepoService<Route> implements IRouteService {

    private final RouteRepository repository;

    @Autowired
    public RouteService(RouteRepository repository) {
        this.repository = repository;
        this.primeRepository = repository;
    }

    @Override
    public List<Route> getEmptyList() {
        return Collections.emptyList();
    }

    @Override
    public List<Route> getAllByUserId(Long userId) {
        return repository.findAllByUserId(userId).orElse(getEmptyList());
    }
}
