package com.keeper.service.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.entity.GeoPoint;
import com.keeper.entity.Location;
import com.keeper.entity.Route;
import com.keeper.entity.User;
import com.keeper.repo.GeoPointRepository;
import com.keeper.repo.LocationRepository;
import com.keeper.repo.RouteRepository;
import com.keeper.service.contracts.ILocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.keeper.util.CollectorResolver.*;


/**
 * Repository Service to work with Locations
 */
@Service(value = "locationService")
public class LocationRepoService implements ILocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeoPointRepoService.class);

    @Resource
    private LocationRepository locationRepo;

    @Resource
    private GeoPointRepository geoPointRepo;

    @Resource
    private RouteRepository routeRepo;

    //<editor-fold desc="Location">

    @Override
    public Location addLocation(Long ownerId, List<Location> locations) {
        return locationRepo.save(locations.get(0));
    }

    @Override
    public List<Location> getLocations(Long ownerId) {
        return locationRepo.findAllByUserId(ownerId);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepo.findAll();
    }

    @Override
    public Location updateLocation(Location location) {
        return locationRepo.save(location);
    }

    @Override
    public void removeLocations(List<Long> ownerId) {
        for (Long durId :
                ownerId) {
            locationRepo.deleteByUserId(durId);
        }
    }

//    @Override
//    public void removeLocations(List<Long> ownerId) {
//        locationRepo.deleteByOwnerId(ownerId.get(0));
//    }

    @Override
    public List<Location> removeLocation(List<Location> location) {
        locationRepo.delete(location);
        return location;
    }
    //</editor-fold>

    //<editor-fold desc="Coordinates">

    @Override
    public List<GeoPoint> addGeoPoints(Long userId, List<GeoPoint> geoPoints) {

        return locationRepo.createCoordinates(userId, geoPoints);
    }

    @Override
    public List<GeoPoint> getGeoPoints(Long userId, List<Long> geoPointsIds) {
        return locationRepo.readCoordinates(userId, geoPointsIds);
    }

    @Override
    public List<GeoPoint> getAllGeoPoints() {
        return geoPointRepo.findAll();
    }

    @Override
    public List<GeoPoint> updateGeoPoints(Long userId, List<GeoPoint> geoPoints) {
        return locationRepo.updateCoordinates(userId, geoPoints);
    }

    @Override
    public void removeGeoPoints(Long userId, List<Long> geoPointsIds) {
        locationRepo.deleteCoordinates(userId, geoPointsIds);
    }

    //</editor-fold>

    //<editor-fold desc="Routes">

    public Route addRoutes(Long userId, Route route) {
        return getFirstRoute(locationRepo.createRoutes(userId, makeRouteList(route)));
    }

    public List<Route> addRoutes(Long userId, List<Route> routes) {
        return locationRepo.createRoutes(userId, routes);
    }

    @Override
    public List<Route> addRoutes(User user, List<Route> routes) {
        return routeRepo.save(routes);
    }


    public List<Route> getRoutes(Long userId, List<Long> routeIds) {
        return locationRepo.readRoutes(userId, routeIds);
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
        return getFirstRoute(locationRepo.updateRoute(userId, makeIdList(routeId)));
    }

    public List<Route> updateRoute(Long userId, List<Long> routeIds) {
        return locationRepo.updateRoute(userId, routeIds);
    }

    @Override
    public List<Route> updateRoute(User user, List<Long> routeIds) {
        return null;
    }

    public void removeRoutes(Long userId, List<Long> routeIds) {
        locationRepo.deleteRoutes(userId, routeIds);
    }
    

    @Override
    public void removeRoutes(User user, List<Long> routeIds) {

    }

    //</editor-fold>
}
