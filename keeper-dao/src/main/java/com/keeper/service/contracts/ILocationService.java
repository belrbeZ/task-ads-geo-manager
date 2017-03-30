package com.keeper.service.contracts;

/*
 * Created by GoodforGod on 23.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.entity.GeoPoint;
import com.keeper.entity.Location;
import com.keeper.entity.Route;
import com.keeper.entity.User;

import java.util.List;

/**
 * Default Comment
 */
public interface ILocationService {

    //<editor-fold desc="Location">

    Location addLocation(Long ownerId, List<Location> location);

    List<Location> getLocations(Long ownerId);

    List<Location> getAllLocations();

    Location updateLocation(Location location);

    void removeLocations(List<Long> ownerId);

    List<Location> removeLocation(List<Location> locations);
    //</editor-fold>

    //<editor-fold desc="Coordinates">

    List<GeoPoint> addGeoPoints(Long ownerId, List<GeoPoint> geoPoints);

    List<GeoPoint> getGeoPoints(Long ownerId, List<Long> geoPointsIds);

    List<GeoPoint> getAllGeoPoints();

    List<GeoPoint> updateGeoPoints(Long ownerId, List<GeoPoint> geoPoints);

    void removeGeoPoints(Long ownerId, List<Long> geoPointsIds);
    //</editor-fold>

    //<editor-fold desc="Routes">

//    Route addRoutes(Long ownerId, Route route);
//    Route addRoutes(User user, Route route);
    List<Route> addRoutes(Long ownerId, List<Route> routes);
    List<Route> addRoutes(User user, List<Route> routes);

//    Route getRoutes(Long ownerId, Long routeId);
//    Route getRoutes(User user, Long routeId);
    List<Route> getRoutes(Long ownerId, List<Long> routeIds);
    List<Route> getRoutes(User user, List<Long> routeIds);

    List<Route> getAllRoutes();

//    Route updateRoute(Long ownerId, Long routeId);
//    Route updateRoute(User user, Long routeId);
    List<Route> updateRoute(Long ownerId, List<Long> routeIds);
    List<Route> updateRoute(User user, List<Long> routeIds);

//    void removeRoute(Long ownerId, Long routeId);
//    void removeRoute(User user, Long routeId);
    void removeRoutes(Long ownerId, List<Long> routeIds);
    void removeRoutes(User user, List<Long> routeIds);
    //</editor-fold>
}
