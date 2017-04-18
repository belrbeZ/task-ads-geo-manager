package com.keeper.model.dto;

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

    public PictureDTO(){}

    public PictureDTO(Long userId, Long taskId, String pic, String info){
        this.userId = userId;
        this.taskId = taskId;
        this.pic = pic;
        this.info = info;
    }

}
