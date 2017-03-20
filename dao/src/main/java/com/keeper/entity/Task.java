package com.keeper.entity;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.states.TaskState;
import com.keeper.states.TaskType;

import java.util.ArrayList;
import java.util.List;

/**
 * Task model implementation
 */
public class Task {

    public static final Task empty = new Task();

    private Integer id;
    private Integer topicStarterId;

    private TaskType  type;
    private TaskState state;

    private String theme;
    private String description;
    private Picture pic;

    private List<String>    tags                = new ArrayList<String>();
    private List<Integer>   participants        = new ArrayList<Integer>();
    private List<Integer>   activeParticipants  = new ArrayList<Integer>();
    private List<Coordinate> coordinates        = new ArrayList<Coordinate>();

    //<editor-fold desc="GetterAndSetter">

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTopicStarterId() {
        return topicStarterId;
    }

    public void setTopicStarterId(Integer topicStarterId) {
        this.topicStarterId = topicStarterId;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Picture getPic() {
        return pic;
    }

    public void setPic(Picture pic) {
        this.pic = pic;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Integer> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Integer> participants) {
        this.participants = participants;
    }

    public List<Integer> getActiveParticipants() {
        return activeParticipants;
    }

    public void setActiveParticipants(List<Integer> activeParticipants) {
        this.activeParticipants = activeParticipants;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
