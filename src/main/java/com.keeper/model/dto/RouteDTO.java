package com.keeper.model.dto;

/*
 * Created by @GoodforGod on 17.04.2017.
 */

import com.keeper.model.SimpleGeoPoint;
import com.keeper.model.types.RouteType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Default Comment
 */
public class RouteDTO {

    public static final RouteDTO EMPTY = new RouteDTO();

    private Long id;
    private Long userId;
    private RouteType type;
    private String info;
    Integer radius;
    private List<SimpleGeoPoint> points = new ArrayList<>();

    private RouteDTO() {
        this.id     = 0L;
        this.userId = 0L;
        this.type   = RouteType.EMPTY;
        this.info   = "";
        this.radius = radius;
        this.points = Collections.emptyList();
    }

    public RouteDTO(Long id, Long userId, RouteType type, String info, Integer radius, String[] latitudes, String[] longtitudes) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.info = info;
        this.radius = radius;

        for(int i = 0; i < latitudes.length; i++){
            points.add(new SimpleGeoPoint(longtitudes[i], latitudes[i]));
//            System.out.println("RouteDTO"+this.getPoints().get(i));
        }

    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public RouteType getType() {
        return type;
    }

    public String getInfo() {
        return info;
    }

    public Integer getRadius() {
        return radius;
    }

    public List<SimpleGeoPoint> getPoints() {
        return points;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setType(RouteType type) {
        this.type = type;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setPoints(List<SimpleGeoPoint> points) {
        this.points = points;
    }

    //</editor-fold>
}
