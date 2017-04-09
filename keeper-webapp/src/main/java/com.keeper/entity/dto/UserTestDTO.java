package com.keeper.entity.dto;

/*
 * Created by @GoodforGod on 4.04.2017.
 */

import com.keeper.entity.states.UserType;
import com.keeper.util.Converter;

import java.security.Timestamp;

/**
 * Default Comment
 */
public class UserTestDTO {

    public static final UserTestDTO EMPTY = new UserTestDTO((long)UserType.EMPTY.getValue())
                                                                {{ setType(UserType.EMPTY); }};
    private final Long  id;
    private UserType    type;
    private String      name;
    private String      maskEmail;
    private String      maskPhone;
    private String      about;
    private Boolean     isNotified;
    private Timestamp   muteEnd;

    private UserTestDTO() {
        this.id         = (long) UserType.UNKNOWN.getValue();
        this.type       = UserType.UNKNOWN;
        this.name       = "";
        this.maskEmail  = "";
        this.maskPhone  = "";
        this.about      = "";
        this.isNotified = false;
    }

    private UserTestDTO(Long id) {
        super();
        this.id = id;
    }

    public UserTestDTO(Long id, UserType type, String name, String maskedEmail,
                        String phone, String about, boolean isNotified) {
        this.id         = (id == null) ? UserType.UNKNOWN.getValue() : id;
        this.type       = type != null ? type : UserType.UNKNOWN;
        this.name       = name;
        this.maskEmail  = maskedEmail;
        this.maskPhone  = Converter.maskStr(phone);
        this.about      = about;
        this.isNotified = isNotified;
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

    public String getMaskEmail() {
        return maskEmail;
    }

    public void setMaskEmail(String maskEmail) {
        this.maskEmail = maskEmail;
    }

    public String getMaskPhone() {
        return maskPhone;
    }

    public void setMaskPhone(String maskPhone) {
        this.maskPhone = maskPhone;
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

        UserTestDTO that = (UserTestDTO) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
