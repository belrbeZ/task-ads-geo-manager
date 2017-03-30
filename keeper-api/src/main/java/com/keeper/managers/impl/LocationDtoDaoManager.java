package com.keeper.managers.impl;

import com.keeper.dto.GeoPointDto;
import com.keeper.dto.LocationDto;
import com.keeper.dto.RouteDto;
import com.keeper.dto.UserDto;
import com.keeper.entity.Location;
import com.keeper.managers.contracts.ILocationDtoManager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandr Vasiliev on 30.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */

@Service
public class LocationDtoDaoManager implements ILocationDtoManager<Location>  {



    @Override
    public LocationDto addLocation(Long ownerId, List<LocationDto> locationDto) {
        return null;
    }

    @Override
    public List<LocationDto> getLocations(Long ownerId) {
        return null;
    }

    @Override
    public List<LocationDto> getAllLocations() {
        return null;
    }

    @Override
    public LocationDto updateLocation(LocationDto locationDto) {
        return null;
    }

    @Override
    public void removeLocations(List<Long> ownerId) {

    }

    @Override
    public List<LocationDto> removeLocation(List<LocationDto> locations) {
        return null;
    }

    @Override
    public List<GeoPointDto> addGeoPoints(Long ownerId, List<GeoPointDto> geoPoints) {
        return null;
    }

    @Override
    public List<GeoPointDto> getGeoPoints(Long ownerId, List<Long> geoPointsIds) {
        return null;
    }

    @Override
    public List<GeoPointDto> getAllGeoPoints() {
        return null;
    }

    @Override
    public List<GeoPointDto> updateGeoPoints(Long ownerId, List<GeoPointDto> geoPoints) {
        return null;
    }

    @Override
    public void removeGeoPoints(Long ownerId, List<Long> geoPointsIds) {

    }

    @Override
    public List<RouteDto> addRoutes(Long ownerId, List<RouteDto> routes) {
        return null;
    }

    @Override
    public List<RouteDto> addRoutes(UserDto user, List<RouteDto> routes) {
        return null;
    }

    @Override
    public List<RouteDto> getRoutes(Long ownerId, List<Long> routeIds) {
        return null;
    }

    @Override
    public List<RouteDto> getRoutes(UserDto user, List<Long> routeIds) {
        return null;
    }

    @Override
    public List<RouteDto> getAllRoutes() {
        return null;
    }

    @Override
    public List<RouteDto> updateRoute(Long ownerId, List<Long> routeIds) {
        return null;
    }

    @Override
    public List<RouteDto> updateRoute(UserDto user, List<Long> routeIds) {
        return null;
    }

    @Override
    public void removeRoutes(Long ownerId, List<Long> routeIds) {

    }

    @Override
    public void removeRoutes(UserDto user, List<Long> routeIds) {

    }

    @Override
    public Location parseDtoToDao(LocationDto geoPointDto) {
        return null;
    }

    @Override
    public LocationDto parseDaoToDto(Location geoPoint) {
        return null;
    }
}
