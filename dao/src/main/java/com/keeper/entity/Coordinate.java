package com.keeper.entity;

/*
 * Created by GoodforGod on 19.03.2017.
 */

/**
 * Default Comment
 */
public class Coordinate {

    public static final Coordinate empty = new Coordinate();

    private Integer id;

    private String latitude;
    private String longitude;
    private Integer radius;

    private Mark mark;
    private String about;

    private Coordinate() {}

    public Coordinate(String latitude, String longitude, Integer radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    public Coordinate(String latitude, String longitude, Integer radius, String about) {
        this(latitude, longitude, radius);
        this.about = about;
    }

    //<editor-fold desc="GetterAndSetter">

    public Integer getId() {
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

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
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
