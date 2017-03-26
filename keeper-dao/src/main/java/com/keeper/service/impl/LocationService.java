package com.keeper.service.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.dao.hibernate.LocationDao;
import com.keeper.dao.hibernate.impl.LocationDaoHibernate;
import com.keeper.dao.springrepo.LocationRepository;
import com.keeper.entity.Coordinate;
import com.keeper.entity.Location;
import com.keeper.entity.Route;
import com.keeper.service.ILocationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.keeper.util.CollectorResolver.*;


/**
 * Repository to work with Locations
 */
//@Repository
@Service("locationService")
@Transactional
public class LocationService implements ILocationService {

    private LocationDaoHibernate locationDao;

    private LocationRepository localRepo;

    public LocationService(LocationDao locationDao) {
        this.locationDao = (LocationDaoHibernate) locationDao;
    }

    //<editor-fold desc="Location">

    public Location addLocation(Long userId, Location location) {
        return getFirstLocation(locationDao.createLocation(userId, location));
    }

    public Location getLocation(Long userId) {
        return getFirstLocation(locationDao.readLocation(makeIdList(userId)));
    }

    public Location updateLocation(Long userId, Location location) {
        return getFirstLocation(locationDao.updateLocation(userId, location));
    }

    public Location removeLocation(Long userId) {
        return getFirstLocation(locationDao.deleteLocation(makeIdList(userId)));
    }
    //</editor-fold>

    //<editor-fold desc="Coordinates">

    public Coordinate addCoordinates(Long userId, Coordinate coord) {

        return getFirstCoordinate(locationDao.createCoordinates(userId, makeCoordList(coord)));
    }

    public List<Coordinate> addCoordinates(Long userId, List<Coordinate> coords) {

        return locationDao.createCoordinates(userId, coords);
    }

    public Coordinate getCoordinates(final Long userId, Long coordId) {
        return getFirstCoordinate(locationDao.readCoordinates(userId, makeIdList(coordId)));
    }

    public List<Coordinate> getCoordinates(Long userId, List<Long> coordIds) {
        return locationDao.readCoordinates(userId, coordIds);
    }


    public Coordinate updateCoordinates(Long userId, Coordinate coord) {

        return getFirstCoordinate(locationDao.updateCoordinates(userId, makeCoordList(coord)));
    }

    public List<Coordinate> updateCoordinates(Long userId, List<Coordinate> coords) {

        return locationDao.updateCoordinates(userId, coords);
    }

    public Coordinate removeCoordinates(Long userId, Long coordId) {

        return getFirstCoordinate(locationDao.deleteCoordinates(userId, makeIdList(coordId)));
    }

    public List<Coordinate> removeCoordinates(Long userId, List<Long> coordIds) {

        return locationDao.deleteCoordinates(userId, coordIds);
    }
    //</editor-fold>

    //<editor-fold desc="Routes">

    public Route addRoutes(Long userId, Route route) {

        return getFirstRoute(locationDao.createRoutes(userId, makeRouteList(route)));
    }

    public List<Route> addRoutes(Long userId, List<Route> routes) {

        return locationDao.createRoutes(userId, routes);
    }

    public Route getRoutes(Long userId, Long routeId) {

        return getFirstRoute(locationDao.readRoutes(userId, makeIdList(routeId)));
    }

    public List<Route> getRoutes(Long userId, List<Long> routeIds) {

        return locationDao.readRoutes(userId, routeIds);
    }

    public Route updateRoute(Long userId, Long routeId) {

        return getFirstRoute(locationDao.updateRoute(userId, makeIdList(routeId)));
    }

    public List<Route> updateRoute(Long userId, List<Long> routeIds) {

        return locationDao.updateRoute(userId, routeIds);
    }

    public Route removeRoute(Long userId, Long routeId) {

        return getFirstRoute(locationDao.deleteRoutes(userId, makeIdList(routeId)));
    }

    public List<Route> removeRoutes(Long userId, List<Long> routeIds) {

        return locationDao.deleteRoutes(userId, routeIds);
    }
    //</editor-fold>

}
