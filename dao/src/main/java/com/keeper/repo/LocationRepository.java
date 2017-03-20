package com.keeper.repo;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.dao.LocationDaoHibernate;
import com.keeper.entity.Coordinate;
import com.keeper.entity.Location;
import com.keeper.entity.Route;

import java.util.List;

import static com.keeper.util.CollectorResolver.*;

/**
 * Repository to work with Locations
 */
public class LocationRepository {

    private LocationDaoHibernate locationDao;

    //<editor-fold desc="Location">

    public Location getLocation(Integer userId) {

        return Location.emptyLocation;
    }


    public Location setLocation(Integer userId, Location location) {

        return Location.emptyLocation;
    }

    public Location removeLocation(Integer userId) {

        return Location.emptyLocation;
    }

    public Location updateLocation(Integer userId, Location location) {

        return Location.emptyLocation;
    }
    //</editor-fold>

    //<editor-fold desc="Coordinates">

    public Coordinate getCoordinates(final Integer userId, Integer coordId) {
        return getFirstCoordinate(locationDao.getCoordinates(userId, makeIdList(coordId)));
    }

    public List<Coordinate> getCoordinates(Integer userId, List<Integer> coordIds) {
        return locationDao.getCoordinates(userId, coordIds);
    }

    public Coordinate addCoordinates(Integer userId, Coordinate coordinate) {

        return getFirstCoordinate(locationDao.addCoordinates(userId, makeCoordList(coordinate)));
    }

    public List<Coordinate> addCoordinates(Integer userId, List<Coordinate> coordinates) {

        return locationDao.addCoordinates(userId, coordinates);
    }

    public Coordinate removeCoordinates(Integer userId, Integer coordinateId) {

        return getFirstCoordinate(locationDao.removeCoordinates(userId, makeIdList(coordinateId)));
    }

    public List<Coordinate> removeCoordinates(Integer userId, List<Integer> coordinateIds) {

        return locationDao.removeCoordinates(userId, coordinateIds);
    }

    public Coordinate updateCoordinates(Integer userId, Coordinate coordinate) {

        return getFirstCoordinate(locationDao.updateCoordinates(userId, makeCoordList(coordinate)));
    }

    public List<Coordinate> updateCoordinates(Integer userId, List<Coordinate> coordinates) {

        return locationDao.updateCoordinates(userId, coordinates);
    }
    //</editor-fold>

    //<editor-fold desc="Routes">

    public Route getRoutes(Integer userId, Integer routeId) {

        return getFirstRoute(locationDao.getRoutes(userId, makeIdList(routeId)));
    }

    public List<Route> getRoutes(Integer userId, List<Integer> routeIds) {

        return locationDao.getRoutes(userId, routeIds);
    }

    public Route addRoutes(Integer userId, Route route) {

        return getFirstRoute(locationDao.addRoutes(userId, makeRouteList(route)));
    }

    public List<Route> addRoutes(Integer userId, List<Route> routes) {

        return locationDao.addRoutes(userId, routes);
    }

    public Route removeRoute(Integer userId, Integer routeId) {

        return getFirstRoute(locationDao.removeRoutes(userId, makeIdList(routeId)));
    }

    public List<Route> removeRoutes(Integer userId, List<Integer> routeIds) {

        return locationDao.removeRoutes(userId, routeIds);
    }

    public Route updateRoute(Integer userId, Integer routeId) {

        return getFirstRoute(locationDao.updateRoute(userId, makeIdList(routeId)));
    }

    public List<Route> updateRoute(Integer userId, List<Integer> routeIds) {

        return locationDao.updateRoute(userId, routeIds);
    }
    //</editor-fold>

}
