package com.keeper.entity.dao;

/*
 * Created by GoodforGod on 20.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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
    @Column(name = "value", nullable = false)               private String pic;

    private Picture() {}

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
