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
import com.keeper.dao.repo.CoordinateRepository;
import com.keeper.dao.repo.LocationRepository;
import com.keeper.dao.repo.RouteRepository;
import com.keeper.entity.Coordinate;
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

    private final LocationDaoImpl_JpaHibernate locationDao;

    private final LocationRepository localRepo;
    private final CoordinateRepository coordinateRepo;
    private final RouteRepository routeRepo;

    @Autowired
    public LocationRepoService(LocationDao locationDao,
                               LocationRepository localRepo,
                               CoordinateRepository coordinateRepo,
                               RouteRepository routeRepo) {
        this.locationDao = (LocationDaoImpl_JpaHibernate) locationDao;
        this.localRepo = localRepo;
        this.coordinateRepo = coordinateRepo;
        this.routeRepo = routeRepo;
    }

    //<editor-fold desc="Location">

    public Location addLocation(Long ownerId, Location location) {
        return localRepo.save(location);
    }

    public Location getLocation(Long ownerId) {
        return localRepo.findByOwnerId(ownerId);
    }

    public List<Location> getAllLocations() {
        return localRepo.findAll();
    }

    public Location updateLocation(Long ownerId, Location location) {
        return localRepo.save(location);
    }

    public Location updateLocation(User user, Location location) {
        return localRepo.save(location);
    }

    public void removeLocation(Long ownerId) {
        localRepo.deleteByOwnerId(ownerId);
    }

    public Location removeLocation(Location location) {
        localRepo.delete(location);
        return location;
    }
    //</editor-fold>

    //<editor-fold desc="Coordinates">

    public Coordinate addCoordinates(Long userId, Coordinate coord) {
        return coordinateRepo.save(coord);
    }

    public List<Coordinate> addCoordinates(Long userId, List<Coordinate> coords) {
        return locationDao.createCoordinates(userId, coords);
    }

    @Override
    public Coordinate addCoordinates(User user, Coordinate coord) {
        return null;
    }

    @Override
    public List<Coordinate> addCoordinates(User user, List<Coordinate> coords) {
        return null;
    }

    public Coordinate getCoordinates(final Long userId, Long coordId) {
        return getFirstCoordinate(locationDao.readCoordinates(userId, makeIdList(coordId)));
    }

    public List<Coordinate> getCoordinates(Long userId, List<Long> coordIds) {
        return locationDao.readCoordinates(userId, coordIds);
    }

    @Override
    public Coordinate getCoordinates(User user, Long coordId) {
        return null;
    }

    @Override
    public List<Coordinate> getCoordinates(User user, List<Long> coordIds) {
        return null;
    }

    @Override
    public List<Coordinate> getAllCoordionates() {
        return null;
    }

    public Coordinate updateCoordinates(Long userId, Coordinate coord) {
        return getFirstCoordinate(locationDao.updateCoordinates(userId, makeCoordList(coord)));
    }

    public List<Coordinate> updateCoordinates(Long userId, List<Coordinate> coords) {
        return locationDao.updateCoordinates(userId, coords);
    }

    @Override
    public Coordinate updateCoordinates(User user, Coordinate coord) {
        return null;
    }

    @Override
    public List<Coordinate> updateCoordinates(User user, List<Coordinate> coords) {
        return null;
    }

    public void removeCoordinates(Long userId, Long coordId) {
        getFirstCoordinate(locationDao.deleteCoordinates(userId, makeIdList(coordId)));
    }

    public void removeCoordinates(Long userId, List<Long> coordIds) {
        locationDao.deleteCoordinates(userId, coordIds);
    }

    @Override
    public void removeCoordinates(User user, Long coordId) {

    }

    @Override
    public void removeCoordinates(User user, List<Long> coordIds) {

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
