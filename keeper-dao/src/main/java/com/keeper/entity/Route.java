package com.keeper.entity;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.states.RouteType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Route Location implementation
 */
@Entity
@Table(name = "Routes", schema = "entities")
public class Route extends GeoPointStorage {

    public static final Route empty = new Route();

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "ownerId", nullable = false)
    private Long userId;

    @Column(name = "type", nullable = false)
    private RouteType type;

    @Column(name = "mark")
    private Mark mark = Mark.empty;

    @Column(name = "about")
    private String about;

    private Route() {}

    public Route(Long userId, RouteType type, String about){
        this.userId = userId;
        this.type = type;
        this.about = about;
    }

    public Route(Long userId, RouteType type, String about, List<GeoPoint> geoPoints) {
        this(userId, type, about);
        setGeoPoints(new HashSet<>(geoPoints));
    }

    public Route(Long userId, RouteType type, String about, Set<GeoPoint> geoPoints) {
        this(userId, type, about);
        setGeoPoints(new HashSet<>(geoPoints));
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public Long getUserId() {
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
