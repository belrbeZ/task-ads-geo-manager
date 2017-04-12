package com.keeper.model.dao;

/*
 * Created by @GoodforGod on 4.04.2017.
 */

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Default Comment
 */
@Entity
@Table(name = DatabaseResolver.TABLE_PARTICINATMAANGER, schema = DatabaseResolver.SCHEMA)
public class ParticipantManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)   private Long id;
    @Column(name = "userId")                                private Long userId;
    @Column(name = "taskId")                                private Long taskId;

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
    //</editor-fold>
}
