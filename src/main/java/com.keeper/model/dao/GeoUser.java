package com.keeper.model.dao;

/*
 * Created by @GoodforGod on 02.05.2017.
 */

import com.keeper.util.resolve.DatabaseResolver;

import javax.persistence.*;

/**
 * Default Comment
 */
@Entity
@Table(name = DatabaseResolver.TABLE_GEO_USERS, schema = DatabaseResolver.SCHEMA)
public class GeoUser {

    public static final GeoUser EMPTY = new GeoUser();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)   private Long id;
    @Column(name = "userId", nullable = false)              private Long userId;
    @Column(name = "latitude")                              private Double latitude;
    @Column(name = "longitude")                             private Double longitude;
    @Column(name = "radius")                                private Integer radius;
    @Column(name = "descr")                                 private String descr;

    private GeoUser() {
        this.id         = 0L;
        this.latitude   = 0.;
        this.longitude  = 0.;
        this.radius     = 0;
        this.descr      = "";
    }

    public GeoUser(Long userId, Double latitude, Double longitude, Integer radius, String descr) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.userId = userId;
        this.descr = descr;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
    //</editor-fold>
}
