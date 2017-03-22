package com.keeper.entity;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.states.RouteType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Route Location implementation
 */
public class Route extends CoordinateStorage {

    public static final Route empty = new Route();

    private Integer id;
    private Integer userId;

    private RouteType type;
    private Mark mark = Mark.empty;
    private String about;

    private Route() {}

    public Route(Integer userId, RouteType type, String about){
        this.userId = userId;
        this.type = type;
        this.about = about;
    }

    public Route(Integer userId, RouteType type, String about, List<Coordinate> coords) {
        this(userId, type, about);
        setCoordinates(new HashSet<>(coords));
    }

    public Route(Integer userId, RouteType type, String about, Set<Coordinate> coords) {
        this(userId, type, about);
        setCoordinates(coords);
    }

    //<editor-fold desc="GetterAndSetter">

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public RouteType getType() {
        return type;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        return id != null ? id.equals(route.id) : route.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
