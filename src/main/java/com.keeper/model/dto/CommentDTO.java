package com.keeper.model.dto;

import com.keeper.model.SimpleGeoPoint;
import com.keeper.model.types.TaskType;
import com.keeper.model.types.UserType;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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

    private LocalDateTime createDate;
    private LocalDateTime lastModifyDate;
    private String message;
    private SimpleGeoPoint geo;

    private CommentDTO() {
        this.id = -1L;
        this.taskId = TaskType.EMPTY.getValue();
        this.userId = UserType.EMPTY.getValue();
        this.createDate = LocalDateTime.MIN;
        this.lastModifyDate = LocalDateTime.MIN;
        this.message = "";
        this.geo = SimpleGeoPoint.EMPTY;
    }

    public CommentDTO(Long id, Long taskId, Long userId, Timestamp createDate, Timestamp lastModifyDate,
                      String message, Double latitude, Double longitude){
        this.id = id;
        this.taskId     = taskId;
        this.userId     = userId;
        this.createDate = createDate.toLocalDateTime();
        this.lastModifyDate = lastModifyDate!=null ? lastModifyDate.toLocalDateTime() : createDate.toLocalDateTime();
        this.message    = message;
        this.geo = new SimpleGeoPoint(latitude.toString(), longitude.toString());
    }

    //<editor-fold desc="GetterAndSetter">

    public SimpleGeoPoint getGeo() {
        return geo;
    }

    public void setGeo(SimpleGeoPoint geo) {
        this.geo = geo;
    }

    public static CommentDTO getEMPTY() {
        return EMPTY;
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

}
