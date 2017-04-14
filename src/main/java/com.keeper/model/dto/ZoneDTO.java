package com.keeper.model.dto;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import com.keeper.model.types.UserType;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Default Comment
 */
public class ZoneDTO {

    public static final ZoneDTO EMPTY = new ZoneDTO((long) UserType.EMPTY.getValue());

    private final Long  profileId;
    private String      city;
    private String      country;
    private Timestamp   registerDate;

    private ZoneDTO() {
        this.profileId         = (long) UserType.UNKNOWN.getValue();
        this.city           = "";
        this.country        = "";
        this.registerDate   = Timestamp.valueOf(LocalDateTime.MIN);
    }

    private ZoneDTO(Long profileId) {
        super();
        this.profileId = profileId;
    }

    public ZoneDTO(Long profileId, String city, String country, Timestamp timestamp) {
        this.profileId         = (profileId == null) ? UserType.EMPTY.getValue() : profileId;
        this.city           = city;
        this.country        = country;
        this.registerDate   = timestamp;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getprofileId() {
        return profileId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZoneDTO that = (ZoneDTO) o;

        return profileId.equals(that.profileId);
    }

    @Override
    public int hashCode() {
        return profileId.hashCode();
    }
}
