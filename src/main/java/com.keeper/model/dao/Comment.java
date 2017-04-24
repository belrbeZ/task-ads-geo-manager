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
    @Column(name = "taskId")                                private Long taskId;
    @Column(name = "userId")                                private Long userId;
    @Column(name = "createDate")                            private Timestamp createDate;
    @Column(name = "lastModifyDate")                        private Timestamp lastModifyDate;
    @Column(name = "message", nullable = false)             private String message;
    @Column(name = "longtitude")                            private String longtitude;
    @Column(name = "latitude")                              private String latitude;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name="userId", referencedColumnName = "id", insertable = false, updatable = false)
//    private User user;

    private Comment() {
        this.id = 0L;
        this.taskId = 0L;
        this.userId = 0L;
        this.createDate = Timestamp.valueOf(LocalDateTime.MIN);
        this.lastModifyDate = Timestamp.valueOf(LocalDateTime.MAX);
        this.message = "";
        this.longtitude = "";
        this.latitude = "";
    }

    public Comment(Long taskId, Long userId, LocalDateTime createDate, LocalDateTime lastModifyDate,
                   String message, String longtitude, String latitude) {
        this.taskId     = taskId;
        this.userId     = userId;
//        this.createDate = Timestamp.valueOf(LocalDateTime.MIN);
//        this.lastModifyDate = Timestamp.valueOf(LocalDateTime.MAX);
        this.createDate = Timestamp.valueOf(createDate);
        this.lastModifyDate = Timestamp.valueOf(lastModifyDate);
        this.message    = message;
        this.longtitude = longtitude;
        this.latitude   = latitude;
    }

    public Comment(Long taskId, Long userId,/* LocalDateTime createDate,*/
                   String message, SimpleGeoPoint geoPoint) {
        this.taskId     = taskId;
        this.userId     = userId;
//        this.createDate = Timestamp.valueOf(LocalDateTime.now());
//        this.lastModifyDate = Timestamp.valueOf(LocalDateTime.now());
//        this.createDate = Timestamp.valueOf(createDate);
//        this.lastModifyDate = Timestamp.valueOf(createDate);
        this.message    = message;
        this.longtitude = geoPoint.getLongtitude();
        this.latitude   = geoPoint.getLatitude();
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
        this.latitude = geoPoint.getLatitude();
        this.longtitude = geoPoint.getLongtitude();
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
