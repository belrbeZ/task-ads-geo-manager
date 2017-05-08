package com.keeper.model.dto;

/*
 * Created by @GoodforGod on 17.04.2017.
 */

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Default Comment
 */
public class TagDTO {

    public static final TagDTO EMPTY = new TagDTO();

    @NotNull private Long id;

    @NotEmpty private String tag;

    private Integer counter;

    private TagDTO(){
        this.id = 0L;
        this.tag = "";
        this.counter = 0;
    }

    public TagDTO(Long id, String tag, Integer counter){
        this.id = id;
        this.tag = tag;
        this.counter = counter;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }
    //</editor-fold>

}
