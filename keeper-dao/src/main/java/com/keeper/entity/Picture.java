package com.keeper.entity;

/*
 * Created by GoodforGod on 20.03.2017.
 */

import com.keeper.states.PicType;

/**
 * Picture model
 */
public class Picture {

    public static final Picture empty = new Picture();

    private Integer id;
    private Integer ownerId;

    private PicType type = PicType.TASK;
    private String pic;

    private Picture() {}

    public Picture(Integer ownerId, String pic) {
        this.ownerId = ownerId;
        this.pic = pic;
    }

    //<editor-fold desc="GetterAndSetter">

    public Integer getId() {
        return id;
    }

    public Integer getOwnerId() {
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
