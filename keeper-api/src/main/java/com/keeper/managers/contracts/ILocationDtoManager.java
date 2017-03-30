package com.keeper.managers.contracts;

/*
 * Created by Alexandr Vasiliev on 30.03.2017.
 */



import com.keeper.dto.GeoPointDto;
import com.keeper.dto.LocationDto;
import com.keeper.dto.RouteDto;
import com.keeper.dto.UserDto;

import java.util.List;

/**
 * Default Comment
 */
public interface ILocationDtoManager <T> extends ModelDtoManager<T, LocationDto> {

    //<editor-fold desc="LocationDto">

    LocationDto addLocation(Long ownerId, List<LocationDto> locationDto);

    List<LocationDto> getLocations(Long ownerId);

    List<LocationDto> getAllLocations();

    LocationDto updateLocation(LocationDto locationDto);

    void removeLocations(List<Long> ownerId);

    List<LocationDto> removeLocation(List<LocationDto> locations);
    //</editor-fold>

    //<editor-fold desc="Coordinates">

    List<GeoPointDto> addGeoPoints(Long ownerId, List<GeoPointDto> geoPoints);

    List<GeoPointDto> getGeoPoints(Long ownerId, List<Long> geoPointsIds);

    List<GeoPointDto> getAllGeoPoints();

    List<GeoPointDto> updateGeoPoints(Long ownerId, List<GeoPointDto> geoPoints);

    void removeGeoPoints(Long ownerId, List<Long> geoPointsIds);
    //</editor-fold>

    //<editor-fold desc="Routes">

//    RouteDto addRoutes(Long ownerId, RouteDto routeDto);
//    RouteDto addRoutes(UserDto user, RouteDto routeDto);
    List<RouteDto> addRoutes(Long ownerId, List<RouteDto> routes);
    List<RouteDto> addRoutes(UserDto user, List<RouteDto> routes);

//    RouteDto getRoutes(Long ownerId, Long routeId);
//    RouteDto getRoutes(UserDto user, Long routeId);
    List<RouteDto> getRoutes(Long ownerId, List<Long> routeIds);
    List<RouteDto> getRoutes(UserDto user, List<Long> routeIds);

    List<RouteDto> getAllRoutes();

//    RouteDto updateRoute(Long ownerId, Long routeId);
//    RouteDto updateRoute(UserDto user, Long routeId);
    List<RouteDto> updateRoute(Long ownerId, List<Long> routeIds);
    List<RouteDto> updateRoute(UserDto user, List<Long> routeIds);

//    void removeRoute(Long ownerId, Long routeId);
//    void removeRoute(UserDto user, Long routeId);
    void removeRoutes(Long ownerId, List<Long> routeIds);
    void removeRoutes(UserDto user, List<Long> routeIds);
    //</editor-fold>
}
