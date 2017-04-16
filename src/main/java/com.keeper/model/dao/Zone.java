package com.keeper.model.dao;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import com.keeper.model.types.UserType;
import com.keeper.util.dao.DatabaseResolver;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Default Comment
 */
@Entity
@Table(name = DatabaseResolver.TABLE_ZONES, schema = DatabaseResolver.SCHEMA)
public class Zone {

    public static final Zone EMPTY = new Zone((long)UserType.EMPTY.getValue());

    @Id
    @Column(name = "profileId", unique = true, nullable = false)    private Long profileId;
    @Column(name = "city")                                          private String city;
    @Column(name = "country",       nullable = false)               private String country;
    @Column(name = "registerDate",  nullable = false)               private Timestamp registerDate;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    //join on userId in zone id with userId in user table
    private Zone zone;

    private Zone() {
        this.profileId         = (long) UserType.UNKNOWN.getValue();
        this.city           = "";
        this.country        = "";
        this.registerDate   = Timestamp.valueOf(LocalDateTime.MIN);
    }

    private Zone(Long id) {
        super();
        this.profileId = id;
    }

    public Zone(Long profileId, String city, String country) throws NullPointerException {

        if(profileId == null)
            throw new NullPointerException("USER_ID");

        this.profileId     = profileId;
        this.city       = city;
        this.country    = country;
        this.registerDate = Timestamp.valueOf(LocalDateTime.now());
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getProfileId() {
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

        Zone zoneTest = (Zone) o;

        return profileId.equals(zoneTest.profileId);
    }

    @Override
    public int hashCode() {
        return profileId.hashCode();
    }
}
