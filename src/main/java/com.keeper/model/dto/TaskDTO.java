package com.keeper.model.dto;

import com.keeper.model.dao.Picture;
import com.keeper.model.dao.User;
import com.keeper.model.types.TaskState;
import com.keeper.model.types.TaskType;

import java.util.List;

/**
 * Created by Alexandr Vasiliev on 29.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */
public class TaskDTO {
    public static final TaskDTO EMPTY = new TaskDTO();

    private Long id;
    private Long topicStarterId;
    private TaskType type;
    private TaskState state = TaskState.HIDEN;
    private String theme;
    private String descr;

    //    private GeoPointDTO geoPointDTO;
    private List<UserDTO> participants;
    private List<CommentDTO> comments;
    private PictureDTO picture;
    private List<TagDTO> tags;

    private TaskDTO() {}

    public TaskDTO(Long topicStarterId, TaskType type, TaskState state, String theme, String descr) {
        this.topicStarterId = topicStarterId;
        this.type = type;
        this.state = state;
        this.theme = theme;
        this.descr = descr;
    }

//    public TaskDTO(Long topicStarterId, TaskType type, TaskState state, String theme, String descr, GeoPointDTO geoPointDTO) {
//        this.topicStarterId = topicStarterId;
//        this.type = type;
//        this.state = state;
//        this.theme = theme;
//        this.descr = descr;
//        this.geoPointDTO = geoPointDTO;
//    }
    public TaskDTO(Long topicStarterId, TaskType type, TaskState state, String theme, String descr,
                   List<UserDTO> participants, List<CommentDTO> comments, List<TagDTO> tags, PictureDTO picture) {
        this.topicStarterId = topicStarterId;
        this.type = type;
        this.state = state;
        this.theme = theme;
        this.descr = descr;
        this.participants = participants;
        this.comments = comments;
        this.tags = tags;
        this.picture = picture;
    }
    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public Long getTopicStarterId() {
        return topicStarterId;
    }

    public TaskType getType() {
        return type;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public List<UserDTO> getParticipants() {
        return participants;
    }

    public void setParticipants(List<UserDTO> participants) {
        this.participants = participants;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    public PictureDTO getPicture() {
        return picture;
    }

    public void setPictures(PictureDTO picture) {
        this.picture = picture;
    }

    public List<TagDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagDTO> tags) {
        this.tags = tags;
    }

//    public GeoPointDTO getgeoPointDTO() {
//        return geoPointDTO;
//    }

//    public void setgeoPointDTO(GeoPointDTO geoPointDTO) {
//        this.geoPointDTO = geoPointDTO;
//    }

    //</editor-fold>
}
