package com.keeper.model.dto;

/*
 * Created by @GoodforGod on 03.05.2017.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Default Comment
 */
public class GeoLocations {

    private Set<Long> routes = new HashSet<>();
    private Set<Long> points = new HashSet<>();

    public void addRoute(RouteDTO route) {
        routes.add(route.getId());
    }

    public void addPoint(GeoUserDTO point) {
        points.add(point.getId());
    }

    public void addRoute(Long route) {
        routes.add(route);
    }

    public void addPoint(Long point) {
        points.add(point);
    }

    public void removeRoute(RouteDTO route) {
        removeRoute(route.getId());
    }

    public void removeRoute(Set<Long> routes) {
        this.routes.removeAll(routes);
    }

    public void removeRoute(Long routeId) {
        routes.remove(routeId);
    }

    public void removePoint(GeoUserDTO point) {
        removePoint(point.getId());
    }

    public void removePoint(Set<Long> points) {
        this.points.removeAll(points);
    }

    public void removePoint(Long pointId) {
        points.remove(pointId);
    }

    public Set<Long> getRoutes() {
        return routes;
    }

    public Set<Long> getPoints() {
        return points;
    }
}
