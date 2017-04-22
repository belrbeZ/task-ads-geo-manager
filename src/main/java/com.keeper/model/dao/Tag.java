package com.keeper.model.dao;

/*
 * Created by @GoodforGod on 4.04.2017.
 */

import com.keeper.util.resolve.DatabaseResolver;

import javax.persistence.*;

/**
 * Default Comment
 */
@Entity
@Table(name = DatabaseResolver.TABLE_TAGS, schema = DatabaseResolver.SCHEMA)
public class Tag {

    public static final Tag EMPTY = new Tag();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)   private Long taskId;
    @Column(name = "tag")                                   private String value;
    @Column(name = "counter")                               private Integer counter;

    private Tag() {
        this.taskId = -1L;
        this.value = "";
        this.counter = 0;
    }

    public Tag(Long taskId, String value) {
        this.taskId = taskId;
        this.value = value;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getTaskId() {
        return taskId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public void incCounter() {
        counter++;
    }

    public void decCounter() {
        counter--;
    }
    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        return value != null ? value.equals(tag.value) : tag.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
