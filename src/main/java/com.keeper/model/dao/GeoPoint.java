package com.keeper.model.dao;

/*
 * Created by @GoodforGod on 02.05.2017.
 */

import com.keeper.model.SimpleGeoPoint;
import com.keeper.util.resolve.DatabaseResolver;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Default Comment
 */
@Entity
@Table(name = DatabaseResolver.TABLE_GEO_POINTS, schema = DatabaseResolver.SCHEMA)
public class GeoPoint {

    public static final GeoPoint EMPTY = new GeoPoint();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)   private Long id;

    @NotNull
    @Column(name = "userId", nullable = false)              private Long userId;

    @Column(name = "latitude")                              private Double latitude;
    @Column(name = "longitude")                             private Double longitude;
    @Column(name = "radius")                                private Integer radius;

    @Column(name = "descr")                                 private String descr;

    private GeoPoint() {
        this.id         = 0L;
        this.latitude   = 0.;
        this.longitude  = 0.;
        this.radius     = 0;
        this.descr      = "";
    }

    public GeoPoint(Long userId, Double latitude, Double longitude, Integer radius, String descr) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.userId = userId;
        this.descr = descr;
    }

    //<editor-fold desc="GetterAndSetter">

    public SimpleGeoPoint getGeo() {
        return new SimpleGeoPoint(latitude.toString(), longitude.toString(), radius);
    }

    public void setGeo(SimpleGeoPoint geo) {
        this.longitude = geo.getLongitude();
        this.latitude = geo.getLatitude();
        this.radius = geo.getRadius();
    }

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
