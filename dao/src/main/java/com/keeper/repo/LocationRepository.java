package com.keeper.repo;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 */

import com.keeper.DaoHibernate.LocationDaoHibernate;
import com.keeper.dao.LocationDAO;
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

    public LocationRepository(LocationDAO locationDao) {
        this.locationDao = (LocationDaoHibernate) locationDao;
    }

    public LocationDaoHibernate getLocationDao() {
        return locationDao;
    }

    //<editor-fold desc="Location">

    public Location addLocation(Integer userId, Location location) {
        return getFirstLocation(locationDao.createLocation(userId, location));
    }

    public Location getLocation(Integer userId) {
        return getFirstLocation(locationDao.readLocation(makeIdList(userId)));
    }

    public Location updateLocation(Integer userId, Location location) {
        return getFirstLocation(locationDao.updateLocation(userId, location));
    }

    public Location removeLocation(Integer userId) {
        return getFirstLocation(locationDao.deleteLocation(makeIdList(userId)));
    }
    //</editor-fold>

    //<editor-fold desc="Coordinates">

    public Coordinate addCoordinates(Integer userId, Coordinate coord) {

        return getFirstCoordinate(locationDao.createCoordinates(userId, makeCoordList(coord)));
    }

    public List<Coordinate> addCoordinates(Integer userId, List<Coordinate> coords) {

        return locationDao.createCoordinates(userId, coords);
    }

    public Coordinate getCoordinates(final Integer userId, Integer coordId) {
        return getFirstCoordinate(locationDao.readCoordinates(userId, makeIdList(coordId)));
    }

    public List<Coordinate> getCoordinates(Integer userId, List<Integer> coordIds) {
        return locationDao.readCoordinates(userId, coordIds);
    }


    public Coordinate updateCoordinates(Integer userId, Coordinate coord) {

        return getFirstCoordinate(locationDao.updateCoordinates(userId, makeCoordList(coord)));
    }

    public List<Coordinate> updateCoordinates(Integer userId, List<Coordinate> coords) {

        return locationDao.updateCoordinates(userId, coords);
    }

    public Coordinate removeCoordinates(Integer userId, Integer coordId) {

        return getFirstCoordinate(locationDao.deleteCoordinates(userId, makeIdList(coordId)));
    }

    public List<Coordinate> removeCoordinates(Integer userId, List<Integer> coordIds) {

        return locationDao.deleteCoordinates(userId, coordIds);
    }
    //</editor-fold>

    //<editor-fold desc="Routes">

    public Route addRoutes(Integer userId, Route route) {

        return getFirstRoute(locationDao.createRoutes(userId, makeRouteList(route)));
    }

    public List<Route> addRoutes(Integer userId, List<Route> routes) {

        return locationDao.createRoutes(userId, routes);
    }

    public Route getRoutes(Integer userId, Integer routeId) {

        return getFirstRoute(locationDao.readRoutes(userId, makeIdList(routeId)));
    }

    public List<Route> getRoutes(Integer userId, List<Integer> routeIds) {

        return locationDao.readRoutes(userId, routeIds);
    }

    public Route updateRoute(Integer userId, Integer routeId) {

        return getFirstRoute(locationDao.updateRoute(userId, makeIdList(routeId)));
    }

    public List<Route> updateRoute(Integer userId, List<Integer> routeIds) {

        return locationDao.updateRoute(userId, routeIds);
    }

    public Route removeRoute(Integer userId, Integer routeId) {

        return getFirstRoute(locationDao.deleteRoutes(userId, makeIdList(routeId)));
    }

    public List<Route> removeRoutes(Integer userId, List<Integer> routeIds) {

        return locationDao.deleteRoutes(userId, routeIds);
    }
    //</editor-fold>

}
