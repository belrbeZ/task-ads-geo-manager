package com.keeper.entity;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 */

import com.keeper.states.UserState;
import com.keeper.states.UserType;

/**
 * User model implementation
 */
public class User implements IModel<Integer>{

    public static final User empty = new User();

    private Long id;

    private UserState state = UserState.AWAIT_VERIFICATION;
    private UserType type;

    private String name;
    private String email;
    private String phone;
    private String password;
    private String about;

    private Zone zone;
    private SleepTime sleepTime;

    private User() { }

    private User(UserType type, String name, String password, String about, Zone zone) {
        this.type = type;
        this.name = name;
        this.password = password;
        this.about = about;

        this.zone = zone;
    }

    public User(UserType type, String name, String email, String password, String about, Zone zone) {
        this(type, name, password, about, zone);
        this.email = email;
    }

    public User(UserType type, String name, String email, String phone, String password, String about, Zone zone) {
        this(type, name, email, password, about, zone);
        this.phone = phone;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
