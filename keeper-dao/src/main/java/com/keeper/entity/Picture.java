package com.keeper.entity;

/*
 * Created by GoodforGod on 20.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.states.PicType;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Picture model
 */
public class Picture {

    public static final Picture empty = new Picture();

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "ownerId", nullable = false)
    private Long ownerId;

    @Column(name = "type", nullable = false)
    private PicType type = PicType.TASK;

    @Column(name = "value", nullable = false)
    private String pic;

    private Picture() {}

    public Picture(Long ownerId, String pic) {
        this.ownerId = ownerId;
        this.pic = pic;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public PicType getType() {
        return type;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    //</editor-fold>
}
