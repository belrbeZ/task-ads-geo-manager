package com.keeper.model.dto;

import com.keeper.model.types.TaskType;
import com.keeper.model.types.UserType;

/**
 * Created by Alexandr Vasiliev on 18.04.2017.
 *
 * @author Alexandr Vasiliev
 */
public class PictureDTO {

    public static final PictureDTO EMPTY = new PictureDTO();

    private Long userId;
    private Long taskId;

    private String pic;
    private String info;

    private PictureDTO() {
        this.userId = UserType.EMPTY.getValue();
        this.taskId = TaskType.EMPTY.getValue();
        this.pic = "";
        this.info = "";
    }

    public PictureDTO(Long userId, Long taskId, String pic, String info) {
        if(taskId == null && userId == null)
            throw new NullPointerException("Task or User ID Must be NotNull");

        this.userId = userId;
        this.taskId = taskId;
        this.pic = pic;
        this.info = info;
    }

    //<editor-fold desc="GetterAndSetter">
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
