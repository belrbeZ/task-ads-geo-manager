package com.keeper.model.dao;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.util.dao.DatabaseResolver;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = DatabaseResolver.TABLE_GEOPOINTS, schema = DatabaseResolver.SCHEMA)
public class GeoPoint {

    public static final GeoPoint EMPTY = new GeoPoint();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)           private Long id;
    @Column(name = "latitude")                                      private BigDecimal latitude;
    @Column(name = "longitude")                                     private BigDecimal longitude;
    @Column(name = "radius")                                        private Integer radius;
    @Column(name = "info")                                          private String info;

    @OneToOne(fetch = FetchType.LAZY)
//    The PrimaryKeyJoinColumn annotation does say that the primary key of the entity is used as the foreign key value to the associated entity.
    @PrimaryKeyJoinColumn//(name = "geopoint_id")
    private Task task;

    //GeoPo must get only if we need it     mappedBy = DatabaseResolver.TABLE_GEOMANAGER,
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

    //    The MapsId annotation ask Hibernate to copy the identifier from another associated entity
//    @MapsId
//    @OneToOne(mappedBy = "geopoint", cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY, optional = false)
//    private Task task;

    private GeoPoint() {}

    public GeoPoint(BigDecimal latitude, BigDecimal longitude, Integer radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    public GeoPoint(BigDecimal latitude, BigDecimal longitude, Integer radius, String info) {
        this(latitude, longitude, radius);
        this.info = info;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

//    public Task getTask() {
//        return task;
//    }
//
//    public void setTask(Task task) {
//        this.task = task;
//    }

    //</editor-fold>
}
