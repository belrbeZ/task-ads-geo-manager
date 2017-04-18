package com.keeper.model.dto;

/*
 * Created by @GoodforGod on 17.04.2017.
 */

import javax.persistence.Column;

/**
 * Default Comment
 */
public class TagDTO {

    public static final TagDTO EMPTY = new TagDTO();

    private Long taskId;
    private String value;
    private Integer counter;

    public TagDTO(){}

    public TagDTO(Long taskId, String value, Integer counter){
        this.taskId = taskId;
        this.value = value;
        this.counter = counter;
    }

    public static TagDTO getEMPTY() {
        return EMPTY;
    }

    public Long getTaskId() {
        return taskId;
    }

    public String getValue() {
        return value;
    }

    public Integer getCounter() {
        return counter;
    }
}
