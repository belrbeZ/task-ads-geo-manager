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

import javax.persistence.*;


/**
 * Picture model
 */
//@Entity
//@Table(name = DatabaseResolver.TABLE_PICS, schema = DatabaseResolver.SCHEMA)
public class Picture {

    public static final Picture empty = new Picture();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)   private Long id;
    @Column(name = "userId")                                private Long userId;
    @Column(name = "taskId")                                private Long taskId;
    @Column(name = "pic", nullable = false)                 private String pic;
    @Column(name = "info", nullable = false)                private String info;

//    @OneToOne(fetch = FetchType.LAZY)
//    @PrimaryKeyJoinColumn
//    private User User;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @PrimaryKeyJoinColumn
//    private Task task;

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
    //</editor-fold>
}
