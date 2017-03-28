package com.keeper.service.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.dao.jpahibernate.LocationDao;
import com.keeper.dao.jpahibernate.impl.LocationDaoImpl_JpaHibernate;
import com.keeper.dao.repo.GeoPointRepository;
import com.keeper.dao.repo.LocationRepository;
import com.keeper.dao.repo.RouteRepository;
import com.keeper.entity.GeoPoint;
import com.keeper.entity.Location;
import com.keeper.entity.Route;
import com.keeper.entity.User;
import com.keeper.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.keeper.util.CollectorResolver.*;


/**
 * Repository Service to work with Locations
 */
@Service("locationService")
public class LocationRepoService implements ILocationService {

    @Autowired private LocationDaoImpl_JpaHibernate locationDao;

    @Autowired private LocationRepository localRepo;
    @Autowired private GeoPointRepository geoPointRepo;
    @Autowired private RouteRepository routeRepo;

    //<editor-fold desc="Location">

    @Override
    public Location addLocation(Long ownerId, Location location) {
        return localRepo.save(location);
    }

    @Override
    public Location getLocation(Long ownerId) {
        return localRepo.findByOwnerId(ownerId);
    }

    @Override
    public List<Location> getAllLocations() {
        return localRepo.findAll();
    }

    @Override
    public Location updateLocation(Location location) {
        return localRepo.save(location);
    }

    @Override
    public void removeLocation(Long ownerId) {
        localRepo.deleteByOwnerId(ownerId);
    }

    @Override
    public Location removeLocation(Location location) {
        localRepo.delete(location);
        return location;
    }
    //</editor-fold>

    //<editor-fold desc="Coordinates">

    @Override
    public List<GeoPoint> addGeoPoints(Long userId, List<GeoPoint> geoPoints) {
        return locationDao.createCoordinates(userId, geoPoints);
    }

    @Override
    public List<GeoPoint> getGeoPoints(Long userId, List<Long> geoPointsIds) {
        return locationDao.readCoordinates(userId, geoPointsIds);
    }

    @Override
    public List<GeoPoint> getAllGeoPoints() {
        return geoPointRepo.findAll();
    }

    @Override
    public List<GeoPoint> updateGeoPoints(Long userId, List<GeoPoint> geoPoints) {
        return locationDao.updateCoordinates(userId, geoPoints);
    }

    @Override
    public void removeGeoPoints(Long userId, List<Long> geoPointsIds) {
        locationDao.deleteCoordinates(userId, geoPointsIds);
    }

    //</editor-fold>

    //<editor-fold desc="Routes">

    public Route addRoutes(Long userId, Route route) {
        return getFirstRoute(locationDao.createRoutes(userId, makeRouteList(route)));
    }

    public List<Route> addRoutes(Long userId, List<Route> routes) {
        return locationDao.createRoutes(userId, routes);
    }

    @Override
    public Route addRoutes(User user, Route route) {
        return null;
    }

    @Override
    public List<Route> addRoutes(User user, List<Route> routes) {
        return routeRepo.save(routes);
    }

    public Route getRoutes(Long userId, Long routeId) {
        return getFirstRoute(locationDao.readRoutes(userId, makeIdList(routeId)));
    }

    public List<Route> getRoutes(Long userId, List<Long> routeIds) {
        return locationDao.readRoutes(userId, routeIds);
    }

    @Override
    public Route getRoutes(User user, Long routeId) {
        return null;
    }


    @Override
    public List<Route> getRoutes(User user, List<Long> routeIds) {
        return null;
    }

    @Override
    public List<Route> getAllRoutes() {
        return null;
    }

    public Route updateRoute(Long userId, Long routeId) {
        return getFirstRoute(locationDao.updateRoute(userId, makeIdList(routeId)));
    }

    public List<Route> updateRoute(Long userId, List<Long> routeIds) {
        return locationDao.updateRoute(userId, routeIds);
    }

    @Override
    public Route updateRoute(User user, Long routeId) {
        return null;
    }

    @Override
    public List<Route> updateRoute(User user, List<Long> routeIds) {
        return null;
    }

    public void removeRoute(Long userId, Long routeId) {
        localRepo.deleteByOwnerId(userId);
    }

    public void removeRoutes(Long userId, List<Long> routeIds) {
        locationDao.deleteRoutes(userId, routeIds);
    }

    @Override
    public void removeRoute(User user, Long routeId) {

    }

    @Override
    public void removeRoutes(User user, List<Long> routeIds) {

    }

    //</editor-fold>
}
