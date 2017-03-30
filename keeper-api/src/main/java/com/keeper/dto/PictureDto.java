package com.keeper.dto;

/*
 * Created by Alexandr Vasiliev on 30.03.2017.
 */


import com.keeper.entity.states.PicType;

/**
 * Picture model
 */
public class PictureDto {

    public static final PictureDto empty = new PictureDto();

    private Long id;

    private Long ownerId;

    private PicType type = PicType.TASK;

    private String pic;

    private PictureDto() {}

    public PictureDto(Long ownerId, String pic) {
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
