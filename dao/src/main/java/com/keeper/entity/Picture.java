package com.keeper.entity;

/*
 * Created by GoodforGod on 20.03.2017.
 */

/**
 * Default Comment
 */
public class Picture {

    public static final Picture emptyPic = new Picture();

    private Integer userId;

    private String pic;

    //<editor-fold desc="GetterAndSetter">

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    //</editor-fold>
}
