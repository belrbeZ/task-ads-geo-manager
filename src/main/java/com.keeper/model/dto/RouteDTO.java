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
    private List<SimpleGeoPoint> points = new ArrayList<>();

    private RouteDTO() {
        this.id     = 0L;
        this.userId = 0L;
        this.type   = RouteType.EMPTY;
        this.info   = "";
        this.points = Collections.emptyList();
    }

    public RouteDTO(Long id, Long userId, RouteType type, String info, String[] latitudes, String[] longtitudes) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.info = info;

        for(int i = 0; i > latitudes.length; i++)
            points.add(new SimpleGeoPoint(longtitudes[i], latitudes[i]));

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

    public List<SimpleGeoPoint> getPoints() {
        return points;
    }
    //</editor-fold>
}
