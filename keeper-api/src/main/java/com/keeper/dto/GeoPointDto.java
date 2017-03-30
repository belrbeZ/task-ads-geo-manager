package com.keeper.dto;

/**
 * Created by Alexandr Vasiliev on 29.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */

public class GeoPointDto implements ModelDto<Long> {


    public static final GeoPointDto empty = new GeoPointDto();

    private Long id;

    private String latitude;
    private String longitude;
    private Integer radius;

    private MarkDto mark;
    private String about;

    private GeoPointDto() {}

    public GeoPointDto(String latitude, String longitude, Integer radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    public GeoPointDto(String latitude, String longitude, Integer radius, String about) {
        this(latitude, longitude, radius);
        this.about = about;
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

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public MarkDto getMark() {
        return mark;
    }

    public void setMark(MarkDto mark) {
        this.mark = mark;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
    //</editor-fold>



}
