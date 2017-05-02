package com.keeper.model.dao;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.util.resolve.DatabaseResolver;

import javax.persistence.*;

@Entity
@Table(name = DatabaseResolver.TABLE_GEO_POINTS, schema = DatabaseResolver.SCHEMA)
public class GeoPoint {

    public static final GeoPoint EMPTY = new GeoPoint();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)           private Long id;
    @Column(name = "latitude")                                      private Double latitude;
    @Column(name = "longitude")                                     private Double longitude;
    @Column(name = "radius")                                        private Integer radius;
    @Column(name = "info")                                          private String info;

    private GeoPoint() {
        this.id = 0L;
        this.latitude = 0.;
        this.longitude = 0.;
        this.radius = 0;
        this.info = "";
    }

    public GeoPoint(String latitude, String longitude, Integer radius) {
        this.latitude = new Double(latitude);
        this.longitude = new Double(longitude);
        this.radius = radius;
    }

    public GeoPoint(String latitude, String longitude, Integer radius, String info) {
        this(latitude, longitude, radius);
        this.info = info;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static GeoPoint getEMPTY() {
        return EMPTY;
    }

    //    public Task getTask() {
//        return task;
//    }
//
//    public void setTask(Task task) {
//        this.task = task;
//    }

    //</editor-fold>
}
