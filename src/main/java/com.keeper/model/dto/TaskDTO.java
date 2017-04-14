package com.keeper.model.dto;

import com.keeper.model.states.TaskState;
import com.keeper.model.types.TaskType;

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

//    public GeoPointDTO getgeoPointDTO() {
//        return geoPointDTO;
//    }

//    public void setgeoPointDTO(GeoPointDTO geoPointDTO) {
//        this.geoPointDTO = geoPointDTO;
//    }

    //</editor-fold>
}
