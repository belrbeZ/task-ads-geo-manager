package com.keeper.dao;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.entity.Coordinate;
import com.keeper.entity.Location;
import com.keeper.entity.Route;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Default Comment
 */
public class LocationDaoHibernate {

    public static final List<Location> emptyLocationList = new ArrayList<Location>();
    public static final List<Coordinate> emptyCoordList = new ArrayList<Coordinate>();
    public static final List<Route> emptyRouteList = new ArrayList<Route>();

    //<editor-fold desc="Location">

    public List<Location> getLocation(Integer userId) {

        return emptyLocationList;
    }


    public List<Location> setLocation(Integer userId, Location location) {

        return emptyLocationList;
    }

    public List<Location> removeLocation(Integer userId) {

        return emptyLocationList;
    }

    public List<Location> updateLocation(Integer userId, Location location) {

        return emptyLocationList;
    }
    //</editor-fold>

    //<editor-fold desc="Coordinates">

    public List<Coordinate> getCoordinates(Integer userId, List<Integer> coordinateIds) {

        return emptyCoordList;
    }

    public List<Coordinate> addCoordinates(Integer userId, List<Coordinate> coordinates) {

        return emptyCoordList;
    }

    public List<Coordinate> removeCoordinates(Integer userId, List<Integer> coordinateIds) {

        return emptyCoordList;
    }

    public List<Coordinate> updateCoordinates(Integer userId, List<Coordinate> coordinates) {

        return emptyCoordList;
    }
    //</editor-fold>

    //<editor-fold desc="Routes">

    public List<Route> getRoutes(Integer userId, List<Integer> routeIds) {

        return emptyRouteList;
    }

    public List<Route> addRoutes(Integer userId, List<Route> routes) {

        return emptyRouteList;
    }

    public List<Route> removeRoutes(Integer userId, List<Integer> routeIds) {

        return emptyRouteList;
    }

    public List<Route> updateRoute(Integer userId, List<Integer> routeIds) {

        return emptyRouteList;
    }
    //</editor-fold>
}
