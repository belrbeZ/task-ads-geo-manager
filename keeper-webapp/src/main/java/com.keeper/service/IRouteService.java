package com.keeper.service;

/*
 * Created by @GoodforGod on 4.04.2017.
 */

import com.keeper.model.dao.Route;

import java.util.List;

/**
 * Default Comment
 */
public interface IRouteService {
    List<Route> addRoutes(Long userId, List<Route> routes);

    List<Route> getRoutes(Long userId, List<Long> routeIds);

    List<Route> getAllRoutes();

    List<Route> updateRoute(Long userId, List<Long> routeIds);

    void removeRoutes(Long userId, List<Long> routeIds);
}
