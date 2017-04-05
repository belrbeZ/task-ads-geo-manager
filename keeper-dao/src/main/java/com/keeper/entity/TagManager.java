package com.keeper.entity;

/*
 * Created by @GoodforGod on 4.04.2017.
 */

import com.keeper.util.DatabaseResolver;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Default Comment
 */
//@Entity
//@Table(name = DatabaseResolver.TABLE_TAGMANAGER, schema = DatabaseResolver.SCHEMA)
public class TagManager {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)   private Long id;
    @Column(name = "tagId")                                 private Long tagId;
    @Column(name = "taskId")                                private Long taskId;

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
    //</editor-fold>
}
