package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 4.04.2017.
 */

import com.keeper.model.dao.Route;
import com.keeper.repo.RouteRepository;
import com.keeper.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;

/**
 * Default Comment
 */
@Service
public class RouteRepoService implements IRouteService {

    @Autowired
    private RouteRepository repository;

    @Override
    public List<Route> addRoutes(Long userId, List<Route> routes) {
        return null;
    }

    @Override
    public List<Route> getRoutes(Long userId, List<Long> routeIds) {
        return null;
    }

    @Override
    public List<Route> getAllRoutes() {
        return null;
    }

    @Override
    public List<Route> updateRoute(Long userId, List<Long> routeIds) {
        return null;
    }

    @Override
    public void removeRoutes(Long userId, List<Long> routeIds) {

    }
}
