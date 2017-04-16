package com.keeper.model.dao;

/*
 * Created by @GoodforGod on 16.04.2017.
 */

import com.keeper.model.SimpleGeoPoint;
import com.keeper.util.dao.DatabaseResolver;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Default Comment
 */

@Entity
@Embeddable
@Table(name = DatabaseResolver.TABLE_COMMENTS, schema = DatabaseResolver.SCHEMA)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)   private Long id;
    @Column(name = "taskId",        nullable = false)       private Long taskId;
    @Column(name = "userId",        nullable = false)       private Long userId;
    @Column(name = "createDate",    nullable = false)       private Timestamp createDate;
    @Column(name = "lastModifyDate")                        private Timestamp lastModifyDate;
    @Column(name = "message",       nullable = false)       private String message;
    @Column(name = "longtitude")                            private String longtitude;
    @Column(name = "latitude")                              private String latitude;

    private Comment() { }

    public Comment(Long taskId, Long userId, LocalDateTime createDate,
                   String message, SimpleGeoPoint geoPoint) {
        this.taskId = taskId;
        this.userId = userId;
        this.createDate = Timestamp.valueOf(createDate);
        this.message = message;
        this.longtitude = geoPoint.getLongtitude();
        this.latitude = geoPoint.getLatitude();
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public Long getUserId() {
        return userId;
    }

    public Timestamp getCreateDate() {
        return createDate;
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
    //</editor-fold>
}
