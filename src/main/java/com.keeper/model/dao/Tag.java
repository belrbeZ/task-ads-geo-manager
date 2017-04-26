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
    @Column(name = "id", unique = true, nullable = false)   private Long id;
    @Column(name = "tag")                                   private String tag;
    @Column(name = "counter")                               private Integer counter;

    private Tag() {
        this.id = -1L;
        this.tag = "";
        this.counter = 0;
    }

    public Tag(Long id, String tag) {
        this.id = id;
        this.tag = tag;
        this.counter = 0;
    }

    public Tag(Long id, String tag, Integer counter) {
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

        return tag != null ? tag.equals(tag.tag) : tag.tag == null;
    }

    @Override
    public int hashCode() {
        return tag != null ? tag.hashCode() : 0;
    }
}
