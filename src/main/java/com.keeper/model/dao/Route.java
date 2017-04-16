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
import java.math.BigDecimal;
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
    @Column(name = "latitudes")                             private List<BigDecimal> latitudes;
    @Column(name = "longtitudes")                           private List<BigDecimal> longtitudes;

//    //Routes must get only if we need it
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    //Join on userId in Routes table
//    private User user;

    private Route() {
        this.type = RouteType.COMMON;
    }

    public Route(RouteType type, String info, List<BigDecimal> latitudes, List<BigDecimal> longtitudes){
        this.type = type;
        this.info = info;
        this.latitudes = latitudes;
        this.longtitudes = longtitudes;
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

    public List<BigDecimal> getLatitudes() {
        return latitudes;
    }

    public void setLatitudes(List<BigDecimal> latitudes) {
        this.latitudes = latitudes;
    }

    public List<BigDecimal> getLongtitudes() {
        return longtitudes;
    }

    public void setLongtitudes(List<BigDecimal> longtitudes) {
        this.longtitudes = longtitudes;
    }

    public void addGeoPoint(SimpleGeoPoint geoPoint) {
        latitudes.add(geoPoint.getLatitude());
        longtitudes.add(geoPoint.getLongtitude());
    }

    //</editor-fold>
}
