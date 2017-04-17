package com.keeper.model.dto;

import java.math.BigDecimal;

/**
 * Created by Alexandr Vasiliev on 29.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */

public class GeoPointDTO {

    public static final GeoPointDTO EMPTY = new GeoPointDTO();

    private Long id;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Integer radius;
    private String info;

    private GeoPointDTO() {}

    public GeoPointDTO(Long id, BigDecimal latitude, BigDecimal longitude, Integer radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.id = id;
    }

    public GeoPointDTO(Long id, BigDecimal latitude, BigDecimal longitude, Integer radius, String info) {
        this(id, latitude, longitude, radius);
        this.info = info;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
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
    //</editor-fold>
}
