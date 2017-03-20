package com.keeper.entity;

/*
 * Created by GoodforGod on 19.03.2017.
 */

/**
 * Default Comment
 */
public class Coordinate {

    public static final Coordinate emptyCoordinate = new Coordinate();

    private Integer id;

    private String latitude;
    private String longitude;
    private Integer radius;

    private Double mark;
    private String about;

    //<editor-fold desc="GetterAndSetter">

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
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
