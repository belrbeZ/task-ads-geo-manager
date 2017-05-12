package com.keeper.model.dto;

/*
 * Created by @GoodforGod on 17.04.2017.
 */

import com.keeper.model.types.RouteType;
import com.keeper.model.types.UserType;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Default Comment
 */
public class RouteDTO {

    public static final RouteDTO EMPTY = new RouteDTO();

    @NotNull private Long id;
    @NotNull private Long userId;

    private RouteType type;
    private String info;
    private Integer radius;
    private List<SimpleGeoPoint> points = new ArrayList<>();

    private RouteDTO() {
        this.id     = 0L;
        this.userId = UserType.EMPTY.getValue();
        this.type   = RouteType.EMPTY;
        this.info   = "";
        this.radius = 0;
        this.points = Collections.emptyList();
    }

    public RouteDTO(Long id, Long userId, RouteType type, String info, Integer radius, String[] latitudes, String[] longitudes) {
        this.id     = id;
        this.userId = userId;
        this.type   = type;
        this.info   = info;
        this.radius = radius;

        for(int i = 0; i < latitudes.length; i++) {
            points.add(new SimpleGeoPoint(latitudes[i], longitudes[i]));
        }
    }

    //<editor-fold desc="GetterAndSetter">

    public List<Double> getLongitudes() {
        return points.stream().map(SimpleGeoPoint::getLongitude).collect(Collectors.toList());
    }

    public List<Double> getLatitudes() {
        return points.stream().map(SimpleGeoPoint::getLatitude).collect(Collectors.toList());
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteDTO routeDTO = (RouteDTO) o;

        return id.equals(routeDTO.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
