package com.keeper.model.dao;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.model.SimpleGeoPoint;
import com.keeper.model.types.RouteType;
import com.keeper.util.resolve.DatabaseResolver;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

/**
 * Route Location implementation
 */
@Entity
@Table(name = DatabaseResolver.TABLE_ROUTES, schema = DatabaseResolver.SCHEMA)
public class Route {

    public static final Route EMPTY = new Route();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)   private Long id;
    @Column(name = "userId", nullable = false)              private Long userId;
    @Column(name = "type", nullable = false)                private RouteType type;
    @Column(name = "info")                                  private String info;
    @Type(type = "com.keeper.util.dao.StringArrayUserType")
    @Column(name = "latitudes")                             private String[] latitudes;
    @Type(type = "com.keeper.util.dao.StringArrayUserType")
    @Column(name = "longtitudes")                           private String[] longtitudes;

    private Route() {
        this.id = (long)RouteType.EMPTY.getValue();
        this.type = RouteType.EMPTY;
        this.info = "";
        this.latitudes = new String[]{""};
        this.longtitudes = new String[]{""};
    }

    public Route(RouteType type, String info, List<SimpleGeoPoint> geoPoints){
        this.type = type;
        this.info = info;

        this.latitudes = new String[geoPoints.size()];
        this.longtitudes = new String[geoPoints.size()];

        for(int i = 0; i < geoPoints.size(); i++) {
            this.latitudes[i] = geoPoints.get(i).getLatitude();
            this.longtitudes[i] = geoPoints.get(i).getLongtitude();
        }
    }

    public Route(RouteType type, String info, List<String> longtitudes, List<String> latitudes){
        this.type = type;
        this.info = info;

        this.latitudes = new String[latitudes.size()];
        this.longtitudes = new String[longtitudes.size()];

        for(int i = 0; i < longtitudes.size(); i++) {
            this.latitudes[i] = latitudes.get(i);
            this.longtitudes[i] = longtitudes.get(i);
        }
    }

    public Route(RouteType type, String info, String[] longtitudes, String[] latitudes){
        this.type = type;
        this.info = info;
        this.longtitudes = longtitudes;
        this.latitudes = latitudes;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public RouteType getType() {
        return type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String[] getLatitudes() {
        return latitudes;
    }

    public List<String> getLatitudesAsList() {
        return Arrays.asList(latitudes);
    }

    public void setLatitudes(String[] latitudes) {
        this.latitudes = latitudes;
    }

    public String[] getLongtitudes() {
        return longtitudes;
    }

    public List<String> getLongtitudesAsList() {
        return Arrays.asList(longtitudes);
    }

    public void setLongtitudes(String[] longtitudes) {
        this.longtitudes = longtitudes;
    }

    public void addGeoPoint(SimpleGeoPoint geoPoint) {
        latitudes = Arrays.copyOf(latitudes, latitudes.length +1);
        longtitudes = Arrays.copyOf(longtitudes, longtitudes.length +1);

        latitudes[latitudes.length - 1] = geoPoint.getLatitude();
        longtitudes[longtitudes.length - 1] = geoPoint.getLongtitude();
    }

    public List<SimpleGeoPoint> getGeoPoints() {
        List<SimpleGeoPoint> geoPoints = new ArrayList<>();

        for(int i = 0; i < latitudes.length; i++)
            geoPoints.add(new SimpleGeoPoint(latitudes[i], longtitudes[i]));

        return geoPoints;
    }

    public void setType(RouteType type) {
        this.type = type;
    }

    public static Route getEmpty() {
        return EMPTY;
    }

    //</editor-fold>
}
