package com.keeper.service.impl;

import com.keeper.entity.Route;
import com.keeper.repo.RouteRepository;
import com.keeper.service.IRouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by AlexVasil on 29.03.2017.
 *
 * @author AlexVasil
 *
 */
@Service(value = "routeService")
public class RouteRepoService implements IRouteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeoPointRepoService.class);

//    @Autowired
//    private RouteRepository repository;

    @Override
    public List<Route> addRoutes(Long ownerId, List<Route> routes) {
        return null;
    }

    @Override
    public List<Route> getRoutes(Long ownerId, List<Long> routeIds) {
        return null;
    }

    @Override
    public List<Route> getAllRoutes() {
        return null;
    }

    @Override
    public List<Route> updateRoute(Long ownerId, List<Long> routeIds) {
        return null;
    }

    @Override
    public void removeRoutes(Long ownerId, List<Long> routeIds) {

    }
}
