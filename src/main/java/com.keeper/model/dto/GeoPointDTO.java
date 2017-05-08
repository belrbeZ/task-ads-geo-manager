package com.keeper.model.dto;

/*
 * Created by @GoodforGod on 02.05.2017.
 */

import com.keeper.model.types.UserType;
import com.keeper.util.validation.annotation.Geo;

import javax.validation.constraints.NotNull;

/**
 * Default Comment
 */
public class GeoPointDTO {

    public static final GeoPointDTO EMPTY = new GeoPointDTO();

    private Long id;
    private Long userId;

    private Double latitude;
    private Double longitude;

    @NotNull private Integer radius;

    private String descr;

    private GeoPointDTO() {
        this.latitude = 0.;
        this.longitude = 0.;
        this.radius = 5;
        this.userId = UserType.EMPTY.getValue();
        this.id     = 0L;
        this.descr = "";
    }

    public GeoPointDTO(Long id, Long userId,
                       @Geo String latitude,
                       @Geo String longitude) {
        this.latitude = Double.valueOf(latitude);
        this.longitude = Double.valueOf(longitude);
        this.radius = 5;
        this.userId = userId;
        this.id     = id;
        this.descr  = "";
    }

    public GeoPointDTO(Long id, Long userId,
                       @Geo String latitude,
                       @Geo String longitude,
                       Integer radius) {
        this(id, userId, latitude, longitude);
        this.radius = radius;
    }

    public GeoPointDTO(Long id, Long userId,
                       @Geo String latitude,
                       @Geo String longitude,
                       Integer radius,
                       String descr) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeoPointDTO that = (GeoPointDTO) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
