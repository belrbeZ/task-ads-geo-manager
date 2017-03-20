package com.keeper.entity;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.states.UserState;
import com.keeper.states.UserType;

/**
 * User model implementation
 */
public class User {

    private Integer id;

    private UserState state;
    private UserType type;

    private String name;
    private String email;
    private String phone;
    private String about;

    private Zone zone;
    private SleepTime sleepTime;

    //<editor-fold desc="GetterAndSetter">

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public SleepTime getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(SleepTime sleepTime) {
        this.sleepTime = sleepTime;
    }
    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
