package com.keeper.entity;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Location Implementation, contains all routes and coordinates for User KeepEyeOn History
 */
public class Location {

    public static final Location empty = new Location();

    private Integer id;
    private Integer userId;

    private List<Coordinate> coordinates = new ArrayList<Coordinate>();
    private List<Route> routes = new ArrayList<Route>();

    private Double totalCoordinateMark;
    private Double totalRouteMark;

    //<editor-fold desc="GetterAndSetter">

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public Double getTotalCoordinateMark() {
        return totalCoordinateMark;
    }

    public void setTotalCoordinateMark(Double totalCoordinateMark) {
        this.totalCoordinateMark = totalCoordinateMark;
    }

    public Double getTotalRouteMark() {
        return totalRouteMark;
    }

    public void setTotalRouteMark(Double totalRouteMark) {
        this.totalRouteMark = totalRouteMark;
    }
    //</editor-fold>

}
