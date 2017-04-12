package com.keeper.service;


import com.keeper.model.dao.Route;

import java.util.List;

/**
 * Created by AlexVasil on 29.03.2017.
 *
 * @author AlexVasil
 *
 */
public interface IRouteService {
    List<Route> add(Long userId, List<Route> routes);

    List<Route> get(Long userId, List<Long> routeIds);

    List<Route> getAll();

    List<Route> update(Long userId, List<Long> routeIds);

    void remove(Long userId, List<Long> routeIds);
}
