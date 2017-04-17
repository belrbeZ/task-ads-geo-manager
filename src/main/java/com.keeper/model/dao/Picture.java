package com.keeper.model.dao;

/*
 * Created by GoodforGod on 20.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */


import com.keeper.model.types.PicType;
import com.keeper.model.types.TaskType;
import com.keeper.model.types.UserType;
import com.keeper.util.dao.DatabaseResolver;

import javax.persistence.*;


/**
 * Picture model
 */
@Entity
@Table(name = DatabaseResolver.TABLE_PICS, schema = DatabaseResolver.SCHEMA)
public class Picture {

    public static final Picture EMPTY = new Picture();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)   private Long id;
    @Column(name = "userId")                                private Long userId;
    @Column(name = "taskId")                                private Long taskId;
    @Column(name = "pic", nullable = false)                 private String pic;
    @Column(name = "info", nullable = false)                private String info;

    private Picture() {
        this.id = (long)PicType.EMPTY.getValue();
        this.userId = (long)UserType.EMPTY.getValue();
        this.taskId = (long) TaskType.EMPTY.getValue();
        this.pic = "";
        this.info = "";
    }

    public Picture(Long userId, Long taskId, String pic) {
        this.userId = userId;
        this.taskId = taskId;
        this.pic = pic;
        this.info = "";
    }

    public Picture(Long userId, Long taskId, String pic, String info) {
        this.userId = userId;
        this.taskId = taskId;
        this.pic = pic;
        this.info = info;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    //</editor-fold>
}
