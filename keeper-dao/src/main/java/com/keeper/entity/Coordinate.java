package com.keeper.entity;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 *
 */

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Coordinates", catalog = "entities")
public class Coordinate implements IModel<Integer> {

    public static final Coordinate empty = new Coordinate();

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "coord_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "latitude")
    private String latitude;
    @Column(name = "longitude")
    private String longitude;
    @Column(name = "radius")
    private Integer radius;

    @Column(name = "mark")
    private Mark mark;
    @Column(name = "about")
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
