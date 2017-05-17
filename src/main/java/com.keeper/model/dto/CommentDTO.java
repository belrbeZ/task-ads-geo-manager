package com.keeper.model.dto;

import com.keeper.model.types.TaskType;
import com.keeper.model.types.UserType;
import com.keeper.model.util.SimpleGeoPoint;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * Created by @GoodforGod on 17.04.2017.
 */

/**
 * Default Comment
 */
public class CommentDTO {

    public static final CommentDTO EMPTY = new CommentDTO();

    @NotNull private Long id;
    @NotNull private Long taskId;
    @NotNull private Long userId;

    private String userName;
    private LocalDateTime createDate;
    private LocalDateTime lastModifyDate;
    private String message;
    private SimpleGeoPoint geo;

    private CommentDTO() {
        this.taskId = TaskType.EMPTY.getValue();
        this.userId = UserType.EMPTY.getValue();
        this.createDate = LocalDateTime.MIN;
        this.lastModifyDate = LocalDateTime.MIN;
        this.message = "";
        this.geo = SimpleGeoPoint.EMPTY;
    }

    public CommentDTO(Long userId, Long taskId, String userName) {
        this.userId = userId;
        this.taskId = taskId;
        this.userName = userName;
    }

    public CommentDTO(Long id, Long taskId, Long userId, Timestamp createDate, Timestamp lastModifyDate,
                      String message, Double latitude, Double longitude){
        this.id = id;
        this.taskId     = taskId;
        this.userId     = userId;
        this.createDate = (createDate != null)
                ? createDate.toLocalDateTime()
                : null;
        this.lastModifyDate = (lastModifyDate != null)
                ? lastModifyDate.toLocalDateTime()
                : (createDate != null) ? createDate.toLocalDateTime() : null;
        this.message    = message;
        this.geo = new SimpleGeoPoint(latitude.toString(), longitude.toString());
    }

    //<editor-fold desc="GetterAndSetter">

    public String getPrettyCreateDate() {
        return (createDate != null)
                ? createDate.format(DateTimeFormatter.ofPattern("HH:mm"))
                : "";
    }

    public String getPrettyLastModifyDate() {
        return (lastModifyDate != null)
                ? lastModifyDate.format(DateTimeFormatter.ofPattern("HH:mm"))
                : "";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void setLastModifyDate(LocalDateTime lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SimpleGeoPoint getGeo() {
        return geo;
    }

    public void setGeo(SimpleGeoPoint geo) {
        this.geo = geo;
    }

    public Long getTaskId() {
        return taskId;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getLastModifyDate() {
        return lastModifyDate;
    }

    public String getMessage() {
        return message;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentDTO that = (CommentDTO) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
