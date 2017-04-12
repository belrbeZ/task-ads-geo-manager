package com.keeper.model.dto;

/*
 * Created by Alexandr Vasiliev on 30.03.2017.
 */

/**
 * Picture model
 */
public class PictureDTO {

    public static final PictureDTO empty = new PictureDTO();

    private Long id;
    private Long userId;
    private Long taskId;
    private String pic;

    private PictureDTO() {}

    public PictureDTO(Long userId, Long taskId, String pic) {
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
