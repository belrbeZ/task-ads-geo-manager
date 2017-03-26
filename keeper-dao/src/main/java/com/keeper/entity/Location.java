package com.keeper.entity;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Location Implementation, contains all routes and coordinates for User KeepEyeOn History
 */
public class Location extends CoordinateStorage implements IModel<Integer> {

    public static final Location empty = new Location();

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    private Set<Coordinate> coordinates = new HashSet<>();
    private Set<Route> routes = new HashSet<>();

    @Column(name = "totalCoordMark")
    private Mark totalCoordinateMark;

    @Column(name = "totalRouteMark")
    private Mark totalRouteMark;

    private Location() { }

    public Location(Integer userId) {
        this.userId = userId;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    //<editor-fold desc="Routes">

    public Set<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(Set<Route> routes) {
        this.routes = routes;
    }

    public Route addRoute(Route route) {
        this.routes.add(route);
        return route;
    }

    public Route removeRoute(Route route) {
        this.routes.remove(route);
        return route;
    }
    //</editor-fold>

    //<editor-fold desc="Marks">

    public Mark getTotalCoordinateMark() {
        return totalCoordinateMark;
    }

    public void setTotalCoordinateMark(Mark totalCoordinateMark) {
        this.totalCoordinateMark = totalCoordinateMark;
    }

    public Mark getTotalRouteMark() {
        return totalRouteMark;
    }

    public void setTotalRouteMark(Mark totalRouteMark) {
        this.totalRouteMark = totalRouteMark;
    }
    //</editor-fold>

    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (id != null ? !id.equals(location.id) : location.id != null) return false;
        return userId != null ? userId.equals(location.userId) : location.userId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
