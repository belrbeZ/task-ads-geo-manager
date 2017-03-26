package com.keeper.service;

/*
 * Created by GoodforGod on 23.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.entity.Coordinate;
import com.keeper.entity.Location;
import com.keeper.entity.Route;

import java.util.List;

/**
 * Default Comment
 */
public interface ILocationService {
    //<editor-fold desc="Location">

    Location addLocation(Long userId, Location location);

    Location getLocation(Long userId);

    Location updateLocation(Long userId, Location location);

    Location removeLocation(Long userId);
    //</editor-fold>

    //<editor-fold desc="Coordinates">

    Coordinate addCoordinates(Long userId, Coordinate coord);
    List<Coordinate> addCoordinates(Long userId, List<Coordinate> coords);

    Coordinate getCoordinates(final Long userId, Long coordId);
    List<Coordinate> getCoordinates(Long userId, List<Long> coordIds);

    Coordinate updateCoordinates(Long userId, Coordinate coord);
    List<Coordinate> updateCoordinates(Long userId, List<Coordinate> coords);

    Coordinate removeCoordinates(Long userId, Long coordId);
    List<Coordinate> removeCoordinates(Long userId, List<Long> coordIds);
    //</editor-fold>

    //<editor-fold desc="Routes">

    Route addRoutes(Long userId, Route route);
    List<Route> addRoutes(Long userId, List<Route> routes);

    Route getRoutes(Long userId, Long routeId);
    List<Route> getRoutes(Long userId, List<Long> routeIds);

    Route updateRoute(Long userId, Long routeId);
    List<Route> updateRoute(Long userId, List<Long> routeIds);

    Route removeRoute(Long userId, Long routeId);
    List<Route> removeRoutes(Long userId, List<Long> routeIds);
    //</editor-fold>
}
