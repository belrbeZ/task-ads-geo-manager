package com.keeper.entity.dto;

import com.keeper.entity.states.RouteType;

import java.util.List;

/**
 * Created by Alexandr Vasiliev on 30.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */
public class RouteDTO {

    public static final RouteDTO empty = new RouteDTO();

    private Long id;
    private RouteType type;
    private List<GeoPointDTO> points;
    private String info;

    private RouteDTO() {}

    public RouteDTO(RouteType type, List<GeoPointDTO> points, String info){
        this.type = type;
        this.points = points;
        this.info = info;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public RouteType getType() {
        return type;
    }

    public List<GeoPointDTO> getPoints() {
        return points;
    }

    public void setPoints(List<GeoPointDTO> points) {
        this.points = points;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    //</editor-fold>
}
