package com.keeper.entity;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.entity.states.TaskState;
import com.keeper.entity.states.TaskType;
import com.keeper.util.DatabaseResolver;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Task model implementation
 */
@Entity
@Table(name = DatabaseResolver.TABLE_TASKS, schema = DatabaseResolver.SCHEMA)
public class Task {

    public static final Task empty = new Task();

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)   private Long id;
    @Column(name = "userId", nullable = false)              private Long topicStarterId;
    @Column(name = "type")                                  private TaskType type;
    @Column(name = "state")                                 private TaskState state = TaskState.HIDEN;
    @Column(name = "theme")                                 private String theme;
    @Column(name = "descr")                                 private String descr;

    private Task() {}

    public Task(Long topicStarterId, TaskType type, TaskState state, String theme, String descr) {
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
