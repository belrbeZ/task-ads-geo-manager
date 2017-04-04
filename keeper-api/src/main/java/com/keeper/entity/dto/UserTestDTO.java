package com.keeper.entity.dto;

/*
 * Created by @GoodforGod on 4.04.2017.
 */

import com.keeper.entity.states.UserState;
import com.keeper.entity.states.UserType;

import java.security.Timestamp;
import java.util.TimeZone;

/**
 * Default Comment
 */
public class UserTestDTO {
    public static final UserTestDTO empty = new UserTestDTO();

    private Long id;
    private UserState state = UserState.AWAIT_VERIFICATION;
    private UserType type;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String about;
    private Boolean isNotified = false;
    private Timestamp muteStart;
    private Timestamp muteEnd;
    private TimeZone timeZone = TimeZone.getDefault();

    private UserTestDTO() { }

    public UserTestDTO(UserType type, String name, String email, String phone, String password, String about) {
        this.type = type;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.about = about;
    }

    public UserTestDTO(UserType type, String name, String email, String phone, String password, String about, TimeZone timeZone){
        this(type, name, email, phone, password, about);
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

    public Boolean getNotified() {
        return isNotified;
    }

    public void setNotified(Boolean notified) {
        isNotified = notified;
    }

    public Timestamp getMuteStart() {
        return muteStart;
    }

    public void setMuteStart(Timestamp muteStart) {
        this.muteStart = muteStart;
    }

    public Timestamp getMuteEnd() {
        return muteEnd;
    }

    public void setMuteEnd(Timestamp muteEnd) {
        this.muteEnd = muteEnd;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    //</editor-fold>
}
