package com.keeper.model.dao;

/*
 * Created by @GoodforGod on 16.04.2017.
 */

import com.keeper.model.SimpleGeoPoint;
import com.keeper.util.resolve.DatabaseResolver;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Default Comment
 */

@Entity
@Table(name = DatabaseResolver.TABLE_COMMENTS, schema = DatabaseResolver.SCHEMA)
public class Comment {

    public static final Comment EMPTY = new Comment();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)   private Long id;
    @Column(name = "taskId", nullable = false)              private Long taskId;
    @Column(name = "userId", nullable = false)              private Long userId;
    @Column(name = "createDate")                            private Timestamp createDate;
    @Column(name = "lastModifyDate")                        private Timestamp lastModifyDate;
    @Column(name = "message", nullable = false)             private String message;
    @Column(name = "longtitude")                            private String longtitude;
    @Column(name = "latitude")                              private String latitude;

    private Comment() {
        this.id = 0L;
        this.taskId = 0L;
        this.userId = 0L;
        this.createDate = Timestamp.valueOf(LocalDateTime.MIN);
        this.lastModifyDate = Timestamp.valueOf(LocalDateTime.MIN);
        this.message = "";
        this.longtitude = "";
        this.latitude = "";
    }

    public Comment(Long taskId, Long userId, String message, String longtitude, String latitude) {
        this.taskId     = taskId;
        this.userId     = userId;
        this.createDate = Timestamp.valueOf(LocalDateTime.now());
        this.lastModifyDate = createDate;
        this.message    = message;
        this.longtitude = longtitude;
        this.latitude   = latitude;
    }

    public Comment(Long taskId, Long userId, String message, SimpleGeoPoint geoPoint) {
        this(taskId, userId, message, geoPoint.getLongtitude().toString(), geoPoint.getLatitude().toString());
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Timestamp lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public void setGeoPoint(SimpleGeoPoint geoPoint) {
        this.latitude = geoPoint.getLatitude().toString();
        this.longtitude = geoPoint.getLongtitude().toString();
    }

    public SimpleGeoPoint getGeoPoint() {
        return new SimpleGeoPoint(longtitude, latitude);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    //</editor-fold>
}
