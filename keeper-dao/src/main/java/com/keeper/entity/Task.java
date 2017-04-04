package com.keeper.entity;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.entity.states.TaskState;
import com.keeper.entity.states.TaskType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Task model implementation
 */
//@Entity
//@Table(name = "Tasks", schema = "entities")
public class Task extends GeoPointStorage implements IModel<Long>{

    public static final Task empty = new Task();

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "ownerId", nullable = false)
    private Long topicStarterId;

    @Column(name = "type", nullable = false)
    private TaskType type;

    @Column(name = "state", nullable = false)
    private TaskState state = TaskState.HIDEN;

    @Column(name = "theme")
    private String theme;

    @Column(name = "descr")
    private String descr;

    @Column(name = "pic")
    private Picture pic;

    @Column(name = "tags")
    private Set<String>    tags                = new HashSet<>();

    @Column(name = "participants")
    private Set<Long>   participants         = new HashSet<>();

    @Column(name = "activeParticipants")
    private Set<Long>   activeParticipants   = new HashSet<>();

    private Task() {}

    public Task(Long topicStarterId, TaskType type, String theme, String descr) {
        this.topicStarterId = topicStarterId;
        this.type = type;
        this.theme = theme;
        this.descr = descr;
    }

    public Task(Long topicStarterId, TaskType type, String theme, String descr, Picture pic) {
        this(topicStarterId, type, theme, descr);
        this.pic = pic;
    }

    public Task(Long topicStarterId, TaskType type, String theme, String descr, Set<String> tags) {
        this(topicStarterId, type, theme, descr);
        this.tags = tags;
    }

    public Task(Long topicStarterId, TaskType type, String theme, String descr, Picture pic, Set<String > tags) {
        this(topicStarterId, type, theme, descr, pic);
        this.tags = tags;
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



    public Set<Long> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Long> participants) {
        this.participants = participants;
    }

    public Set<Long> getActiveParticipants() {
        return activeParticipants;
    }

    public void setActiveParticipants(Set<Long> activeParticipants) {
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

