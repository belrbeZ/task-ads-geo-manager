package com.keeper.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.keeper.util.validation.Deserializer;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * Created by Alexandr Vasiliev on 29.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */

public class GeoPointDTO {

    public static final GeoPointDTO EMPTY = new GeoPointDTO();

    private Long id;
    @NotEmpty
    private String latitude;
    @NotEmpty
    private String longitude;

//    @JsonSerialize(using = ToStringSerializer.class)
//    @JsonDeserialize(using = Deserializer.StringIntegerDeserializer.class)
    @NotEmpty
    String radiusD;

    @NotEmpty
    private String info;

    @JsonIgnore
    private Integer radius;

    public GeoPointDTO() {
        this.id = 0L;
        this.latitude = "";
        this.longitude = "";
        this.radius = 5;
        this.radiusD = String.valueOf(5);
        this.info = "";
    }

    public GeoPointDTO(Long id, String latitude, String longitude, String radiusD) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radiusD = radiusD;
        this.radius = Integer.parseInt(radiusD);
        this.id = id;
    }

    public GeoPointDTO(Long id, String latitude, String longitude, Integer radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.id = id;
    }

    public GeoPointDTO(Long id, String latitude, String longitude, Integer radius, String info) {
        this(id, latitude, longitude, radius);
        this.info = info;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Number radius) {
        this.radius = (Integer)radius;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getRadiusD() {
        return radiusD;
    }

    public void setRadiusD(String radiusD) {
        this.radiusD = radiusD;
        this.radius = Integer.parseInt(radiusD);
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    //</editor-fold>
}
