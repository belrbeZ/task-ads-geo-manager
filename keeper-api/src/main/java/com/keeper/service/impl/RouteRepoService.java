package com.keeper.service.impl;

import com.keeper.model.dao.Route;
import com.keeper.service.IRouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by AlexVasil on 29.03.2017.
 *
 * @author AlexVasil
 *
 */
//@Service(value = "routeService")
public class RouteRepoService implements IRouteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeoPointRepoService.class);

//    @Autowired
//    private RouteRepository repository;

    @Override
    public List<Route> add(Long ownerId, List<Route> routes) {
        return null;
    }

    @Override
    public List<Route> get(Long ownerId, List<Long> routeIds) {
        return null;
    }

    @Override
    public List<Route> getAll() {
        return null;
    }

    @Override
    public List<Route> update(Long ownerId, List<Long> routeIds) {
        return null;
    }

    @Override
    public void remove(Long ownerId, List<Long> routeIds) {

    }
}
