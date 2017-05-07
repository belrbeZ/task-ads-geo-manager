package com.keeper.model.dto;

/*
 * Created by @GoodforGod on 17.04.2017.
 */

/**
 * Default Comment
 */
public class TagDTO {

    public static final TagDTO EMPTY = new TagDTO();

    private Long id;
    private String tag;
    private Integer counter;

    public TagDTO(){
        counter = 0;
    }

    public TagDTO(Long id, String tag, Integer counter){
        this.id = id;
        this.tag = tag;
        this.counter = counter;
    }

    public static TagDTO getEMPTY() {
        return EMPTY;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }
}
