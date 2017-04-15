package com.keeper.model.dao;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.model.SimpleGeoPoint;
import com.keeper.model.types.RouteType;
import com.keeper.util.dao.DatabaseResolver;

import javax.persistence.*;
import java.util.List;

/**
 * Route Location implementation
 */
@Entity
@Table(name = DatabaseResolver.TABLE_ROUTES, schema = DatabaseResolver.SCHEMA)
public class Route {

    public static final Route empty = new Route();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)   private Long id;
    @Column(name = "type", nullable = false)                private RouteType type;
    @Column(name = "info")                                  private String info;
    @Column(name = "latitude")                              private List<String> latitude;
    @Column(name = "longtitude")                            private List<String> longtitude;

    private Route() {
        this.type = RouteType.COMMON;
    }

    public Route(RouteType type, String info, List<String> latitude, List<String> longtitude){
        this.type = type;
        this.info = info;
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public RouteType getType() {
        return type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<String> getLatitude() {
        return latitude;
    }

    public void setLatitude(List<String> latitude) {
        this.latitude = latitude;
    }

    public List<String> getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(List<String> longtitude) {
        this.longtitude = longtitude;
    }

    public void addGeoPoint(SimpleGeoPoint geoPoint) {
        latitude.add(geoPoint.getLatitude());
        longtitude.add(geoPoint.getLongtitude());
    }

    //</editor-fold>
}
