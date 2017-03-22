package com.keeper.service;

/*
 * Created by GoodforGod on 23.03.2017.
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

    Location addLocation(Integer userId, Location location);

    Location getLocation(Integer userId);

    Location updateLocation(Integer userId, Location location);

    Location removeLocation(Integer userId);
    //</editor-fold>

    //<editor-fold desc="Coordinates">

    Coordinate addCoordinates(Integer userId, Coordinate coord);
    List<Coordinate> addCoordinates(Integer userId, List<Coordinate> coords);

    Coordinate getCoordinates(final Integer userId, Integer coordId);
    List<Coordinate> getCoordinates(Integer userId, List<Integer> coordIds);

    Coordinate updateCoordinates(Integer userId, Coordinate coord);
    List<Coordinate> updateCoordinates(Integer userId, List<Coordinate> coords);

    Coordinate removeCoordinates(Integer userId, Integer coordId);
    List<Coordinate> removeCoordinates(Integer userId, List<Integer> coordIds);
    //</editor-fold>

    //<editor-fold desc="Routes">

    Route addRoutes(Integer userId, Route route);
    List<Route> addRoutes(Integer userId, List<Route> routes);

    Route getRoutes(Integer userId, Integer routeId);
    List<Route> getRoutes(Integer userId, List<Integer> routeIds);

    Route updateRoute(Integer userId, Integer routeId);
    List<Route> updateRoute(Integer userId, List<Integer> routeIds);

    Route removeRoute(Integer userId, Integer routeId);
    List<Route> removeRoutes(Integer userId, List<Integer> routeIds);
    //</editor-fold>
}
