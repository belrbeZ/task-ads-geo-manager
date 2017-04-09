package com.keeper.entity.dao;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import com.keeper.entity.states.UserType;
import com.keeper.util.dao.DatabaseResolver;
import org.apache.taglibs.standard.tag.common.core.NullAttributeException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Default Comment
 */
@Entity
@Table(name = DatabaseResolver.TABLE_ZONES, schema = DatabaseResolver.SCHEMA)
public class Zone {

    public static final Zone EMPTY = new Zone() {{ this.userId = (long)UserType.EMPTY.getValue(); }};

    @Id
    @Column(name = "userId", unique = true, nullable = false)   private Long userId;
    @Column(name = "city")                                      private String city;
    @Column(name = "country",       nullable = false)           private String country;
    @Column(name = "registerDate",  nullable = false)           private Timestamp registerDate;

    private Zone() {
        this.userId         = (long) UserType.UNKNOWN.getValue();
        this.city           = "";
        this.country        = "";
        this.registerDate   = Timestamp.valueOf(LocalDateTime.MIN);
    }

    public Zone(Long userId, String city, String country) throws NullAttributeException {

        if(userId == null)
            throw new NullAttributeException("Nullable", "USER_ID");

        this.userId     = userId;
        this.city       = city;
        this.country    = country;
        this.registerDate = Timestamp.valueOf(LocalDateTime.now());
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getUserId() {
        return userId;
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

        return userId.equals(zoneTest.userId);
    }

    @Override
    public int hashCode() {
        return userId.hashCode();
    }
}
