package com.keeper.repo;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.entity.Coordinate;
import com.keeper.entity.Location;
import com.keeper.entity.Route;

import java.util.List;

/**
 * Repository to work with Locations
 */
public class LocationRepository {

    //<editor-fold desc="Location">

    public Location getLocation(Integer userId) {

        return null;
    }


    public Location setLocation(Integer userId, Location location) {

        return null;
    }

    public Location removeLocation(Integer userId) {

        return null;
    }

    public Location updateLocation(Integer userId, Location location) {

        return null;
    }
    //</editor-fold>

    //<editor-fold desc="Coordinates">

    public Coordinate getCoordinates(Integer userId, Integer coordinateId) {

        return null;
    }

    public List<Coordinate> getCoordinates(Integer userId, List<Integer> coordinateIds) {

        return null;
    }

    public Coordinate addCoordinates(Integer userId, Coordinate coordinate) {

        return null;
    }

    public List<Coordinate> addCoordinates(Integer userId, List<Coordinate> coordinates) {

        return null;
    }

    public Coordinate removeCoordinates(Integer userId, Integer coordinateId) {

        return null;
    }

    public List<Coordinate> removeCoordinates(Integer userId, List<Integer> coordinateIds) {

        return null;
    }

    public Coordinate updateCoordinates(Integer userId, Coordinate coordinate) {

        return null;
    }

    public List<Coordinate> updateCoordinates(Integer userId, List<Coordinate> coordinates) {

        return null;
    }
    //</editor-fold>

    //<editor-fold desc="Routes">

    public Route getRoutes(Integer userId, Integer routeId) {

        return null;
    }

    public List<Route> getRoutes(Integer userId, List<Integer> routeIds) {

        return null;
    }

    public Route addRoutes(Integer userId, Route route) {

        return null;
    }

    public List<Route> addRoutes(Integer userId, List<Route> routes) {

        return null;
    }

    public Route removeRoute(Integer userId, Integer routeId) {

        return null;
    }

    public List<Route> removeRoutes(Integer userId, List<Integer> routeIds) {

        return null;
    }

    public Route updateRoute(Integer userId, Integer routeId) {

        return null;
    }

    public List<Route> updateRoute(Integer userId, List<Integer> routeIds) {

        return null;
    }
    //</editor-fold>

}
