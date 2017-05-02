package com.keeper.model.dto;

/*
 * Created by @GoodforGod on 02.05.2017.
 */

import com.keeper.util.validation.annotation.GeoCoordinate;

import javax.validation.constraints.NotNull;

/**
 * Default Comment
 */
public class GeoUserDTO {

    public static final GeoUserDTO EMPTY = new GeoUserDTO();

    @NotNull        private Long id;
    @NotNull        private Long userId;

    @GeoCoordinate  private String latitude;
    @GeoCoordinate  private String longitude;

    private Integer radius;
    private String descr;

    private GeoUserDTO() {
        this.latitude = "0.";
        this.longitude = "0.";
        this.radius = 5;
        this.userId = 0L;
        this.id     = 0L;
        this.descr = "";
    }

    public GeoUserDTO(Long id, Long userId, String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = 5;
        this.userId = userId;
        this.id = id;
        this.descr = "";
    }

    public GeoUserDTO(Long id, Long userId, String latitude, String longitude, Integer radius) {
        this(id, userId, latitude, longitude);
        this.radius = radius;
    }

    public GeoUserDTO(Long id, Long userId, String latitude, String longitude, Integer radius, String descr) {
        this(id, userId, latitude, longitude, radius);
        this.descr = descr;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeoUserDTO that = (GeoUserDTO) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
