package com.keeper.service;

import com.keeper.entity.Route;
import com.keeper.entity.User;

import java.util.List;

/**
 * Created by AlexVasil on 29.03.2017.
 *
 * @author AlexVasil
 *
 */
public interface IRouteService {
    List<Route> addRoutes(Long ownerId, List<Route> routes);

    List<Route> getRoutes(Long ownerId, List<Long> routeIds);

    List<Route> getAllRoutes();

    List<Route> updateRoute(Long ownerId, List<Long> routeIds);

    void removeRoutes(Long ownerId, List<Long> routeIds);
}
