package com.keeper.entity.dto;

import com.keeper.entity.Task;
import com.keeper.entity.states.TaskState;
import com.keeper.entity.states.TaskType;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Alexandr Vasiliev on 29.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */
public class TaskDTO {
    public static final TaskDTO empty = new TaskDTO();

    private Long id;
    private Long topicStarterId;
    private TaskType type;
    private TaskState state = TaskState.HIDEN;
    private String theme;
    private String descr;

    private TaskDTO() {}

    public TaskDTO(Long topicStarterId, TaskType type, TaskState state, String theme, String descr) {
        this.topicStarterId = topicStarterId;
        this.type = type;
        this.state = state;
        this.theme = theme;
        this.descr = descr;
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

    //</editor-fold>
}
