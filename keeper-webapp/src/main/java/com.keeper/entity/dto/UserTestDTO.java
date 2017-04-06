package com.keeper.entity.dto;

/*
 * Created by @GoodforGod on 4.04.2017.
 */

import com.keeper.entity.states.UserType;

import java.security.Timestamp;

/**
 * Default Comment
 */
public class UserTestDTO {

    public static final UserTestDTO empty = new UserTestDTO();

    private Long        id;
    private UserType    type;
    private String      name;
    private String      email;
    private String      phone;
    private String      about;
    private Boolean     isNotified;
    private Timestamp   muteStart;
    private Timestamp   muteEnd;

    private UserTestDTO() { }

    public UserTestDTO(Long id,
                        UserType type,
                        String name,
                        String email,
                        String phone,
                        String about) {

        this.id         = id;
        this.type       = type != null ? type : UserType.USER;
        this.name       = name;
        this.email      = email;
        this.phone      = phone;
        this.about      = about;
        this.isNotified = false;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
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
    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTestDTO userTest = (UserTestDTO) o;

        return email.equals(userTest.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
