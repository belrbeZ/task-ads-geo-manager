package com.keeper.dto;

/*
 * Created by Alexandr Vasiliev on 30.03.2017.
 */

import java.util.HashSet;
import java.util.Set;


/**
 * LocationDto Implementation, contains all routes and coordinates for User KeepEyeOn History
 */
public class LocationDto extends GeoPointStorageDto implements ModelDto<Long> {

    public static final LocationDto empty = new LocationDto();

    private Long id;

    private Long userId;

    private Set<RouteDto> routes = new HashSet<>();

    private MarkDto totalGeoPointMark;

    private MarkDto totalRouteMark;

    private LocationDto() { }

    public LocationDto(Long userId) {
        this.userId = userId;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    //<editor-fold desc="Routes">

    public Set<RouteDto> getRoutes() {
        return routes;
    }

    public void setRoutes(Set<RouteDto> routes) {
        this.routes = routes;
    }

    public RouteDto addRoute(RouteDto routeDto) {
        this.routes.add(routeDto);
        return routeDto;
    }

    public RouteDto removeRoute(RouteDto routeDto) {
        this.routes.remove(routeDto);
        return routeDto;
    }
    //</editor-fold>

    //<editor-fold desc="Marks">

    public MarkDto getTotalGeoPointMark() {
        return totalGeoPointMark;
    }

    public void setTotalGeoPointMark(MarkDto totalGeoPointMark) {
        this.totalGeoPointMark = totalGeoPointMark;
    }

    public MarkDto getTotalRouteMark() {
        return totalRouteMark;
    }

    public void setTotalRouteMark(MarkDto totalRouteMark) {
        this.totalRouteMark = totalRouteMark;
    }
    //</editor-fold>

    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationDto location = (LocationDto) o;

//        if (id != null ? !id.equals(location.id) : location.id != null) return false;

        return (id != null ? id.equals(location.id) : location.id == null) && (userId != null ? userId.equals(location.userId) : location.userId == null);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
