package com.keeper.model.dto;

/*
 * Created by @GoodforGod on 17.04.2017.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.keeper.model.types.RouteType;
import com.keeper.model.types.UserType;
import com.keeper.model.util.SimpleGeoPoint;

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

    @JsonIgnore
    private List<SimpleGeoPoint> points;

    private Double[][] arrayPoints2D;

    public RouteDTO() {
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

        if(latitudes.length==0 || longitudes.length==0){
            this.points = Collections.emptyList();
            this.arrayPoints2D = new Double[0][0];
        }

        this.points = new ArrayList<>();
        for(int i = 0; i < latitudes.length; i++) {
            points.add(new SimpleGeoPoint(latitudes[i], longitudes[i]));
        }
    }

    public RouteDTO(Long id, String info, Integer radius, List<SimpleGeoPoint> list) {
        this.id     = id;
        this.userId = UserType.EMPTY.getValue();
        this.type   = RouteType.EMPTY;
        this.info   = info;
        this.radius = radius;
        this.points = list;


    }

    public RouteDTO(Long id, String info, Integer radius, Double[][] list) {
        this.id     = id;
        this.userId = UserType.EMPTY.getValue();
        this.type   = RouteType.EMPTY;
        this.info   = info;
        this.radius = radius;

        for (Double[] durXY:
             list) {
            this.points.add(new SimpleGeoPoint(durXY[0], durXY[1]));
        }
        arrayPoints2D = list;

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
        this.arrayPoints2D = new Double[points.size()][2];
        for (int i = 0; i < points.size(); i++) {
            this.arrayPoints2D[i][0] = points.get(i).getLatitude();
            this.arrayPoints2D[i][1] = points.get(i).getLongitude();
        }
        this.points = points;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = Long.parseLong(id);
    }

    public Double[][] getArrayPoints2D() {
        return arrayPoints2D;
    }

    public void setArrayPoints2D(String arrayPoints2D) {
        if(arrayPoints2D=="[]") {
            this.arrayPoints2D = new Double[0][0];
            this.points = Collections.emptyList();
            return;
        }

        arrayPoints2D=arrayPoints2D.replace("[","");//replacing all [ to ""
        arrayPoints2D=arrayPoints2D.substring(0,arrayPoints2D.length()-2);//ignoring last two ]]
        String s1[]=arrayPoints2D.split("],");//separating all by "],"

        Double my_matrincs[][] = new Double[s1.length][2];//declaring two dimensional matrix for input

        for(int i=0;i<s1.length;i++){
            s1[i]=s1[i].trim();//ignoring all extra space if the string s1[i] has
            String single_int[]=s1[i].split(",");//separating integers by ", "

            for(int j=0;j<single_int.length;j++){
                my_matrincs[i][j]= Double.valueOf(single_int[j]);//adding single values
            }
        }

        this.arrayPoints2D = my_matrincs;

        if(this.points==null || this.points.isEmpty()) {
            this.points = new ArrayList<>();
        } else {
            this.points.clear();
        }

        for (Double[] durXY:
                this.arrayPoints2D) {
            this.points.add(new SimpleGeoPoint(durXY[0], durXY[1]));
        }
    }

    /*public void setArrayPoints2D(Double[][] arrayPoints2D) {
        this.arrayPoints2D = arrayPoints2D;

        this.points.clear();
        for (Double[] durXY:
                arrayPoints2D) {
            this.points.add(new SimpleGeoPoint(durXY[0], durXY[1]));
        }
    }*/

    /*public void setArrayPoints2D(String[][] arrayPoints2D) {
        this.arrayPoints2D = new Double[arrayPoints2D.length][2];
        for (int i = 0; i < arrayPoints2D.length; i++) {
            this.arrayPoints2D[i][0] = Double.valueOf(arrayPoints2D[i][0]);
            this.arrayPoints2D[i][1] = Double.valueOf(arrayPoints2D[i][1]);
        }

        this.points.clear();
        for (Double[] durXY:
                this.arrayPoints2D) {
            this.points.add(new SimpleGeoPoint(durXY[0], durXY[1]));
        }
    }*/

    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteDTO routeDTO = (RouteDTO) o;

        if (id != null ? !id.equals(routeDTO.id) : routeDTO.id != null) return false;
        return userId != null ? userId.equals(routeDTO.userId) : routeDTO.userId == null;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
