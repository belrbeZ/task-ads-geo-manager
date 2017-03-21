package com.keeper.entity;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.states.TaskState;
import com.keeper.states.TaskType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Task model implementation
 */
public class Task extends CoordinateStorage {

    public static final Task empty = new Task();

    private Integer id;
    private Integer topicStarterId;

    private TaskType type;
    private TaskState state = TaskState.HIDEN;

    private String theme;
    private String descr;
    private Picture pic;

    private Set<String>    tags                = new HashSet<>();
    private Set<Integer>   participants         = new HashSet<>();
    private Set<Integer>   activeParticipants   = new HashSet<>();

    private Task() {}

    public Task(Integer topicStarterId, TaskType type, String theme, String descr) {
        this.topicStarterId = topicStarterId;
        this.type = type;
        this.theme = theme;
        this.descr = descr;
    }

    public Task(Integer topicStarterId, TaskType type, String theme, String descr, Picture pic) {
        this(topicStarterId, type, theme, descr);
        this.pic = pic;
    }

    public Task(Integer topicStarterId, TaskType type, String theme, String descr, Set<String> tags) {
        this(topicStarterId, type, theme, descr);
        this.tags = tags;
    }

    public Task(Integer topicStarterId, TaskType type, String theme, String descr, Picture pic, Set<String > tags) {
        this(topicStarterId, type, theme, descr, pic);
        this.tags = tags;
    }

    //<editor-fold desc="GetterAndSetter">

    public Integer getId() {
        return id;
    }

    public Integer getTopicStarterId() {
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

    public Picture getPic() {
        return pic;
    }

    public void setPic(Picture pic) {
        this.pic = pic;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }



    public Set<Integer> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Integer> participants) {
        this.participants = participants;
    }

    public Set<Integer> getActiveParticipants() {
        return activeParticipants;
    }

    public void setActiveParticipants(Set<Integer> activeParticipants) {
        this.activeParticipants = activeParticipants;
    }

    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return id != null ? id.equals(task.id) : task.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

