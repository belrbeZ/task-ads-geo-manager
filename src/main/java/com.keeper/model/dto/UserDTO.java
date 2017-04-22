package com.keeper.model.dto;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.keeper.model.dao.*;
import com.keeper.model.types.UserState;
import com.keeper.model.types.UserType;
import com.keeper.util.Converter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Default Comment
 */
public class UserDTO {

    public static final UserDTO EMPTY = new UserDTO((long)UserType.EMPTY.getValue(),UserType.EMPTY);

    private Long  id;
    private UserState   state;
    private UserType    type;
    private String      name;
    private String      email;
    private String      phone;
    private String      password;
    private String      about;
    private Boolean     isNotified;

    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime muteStart;

    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime muteEnd;

    private Picture     pic;
    private List<GeoPointDTO> geoPoints;
    private ZoneDTO zone;

    private UserDTO() {
        this.id         = (long) UserType.UNKNOWN.getValue();
        this.state      = UserState.UNKNOWN;
        this.type       = UserType.UNKNOWN;
        this.name       = "";
        this.email      = "";
        this.phone      = "";
        this.password   = "";
        this.about      = "";
        this.isNotified = false;
        this.muteStart  = LocalDateTime.MIN;
        this.muteEnd    = LocalDateTime.MAX;
    }

    private UserDTO(Long id, UserType type) {
        super();
        this.type = type;
        this.id = id;
    }

    public UserDTO(UserType type, String name, String email, String phone, String password, String about) {
        this.state      = UserState.AWAIT_VERIFICATION;
        this.type       = type;
        this.name       = name;
        this.email      = email;
        this.phone      = phone;
        this.password   = password;
        this.about      = about;
    }

    public UserDTO(Long id, UserType type, UserState state, String name,
                   String email, String phone, String about, String password,
                   boolean isNotified, LocalDateTime muteStart, LocalDateTime muteEnd) {
        this.id         = id;
        this.state      = state;
        this.type       = type;
        this.name       = name;
        this.email      = Converter.maskEmail(email);
        this.phone      = Converter.maskStr(phone);
        this.password   = password;
        this.about      = about;
        this.isNotified = isNotified;
        this.muteStart  = muteStart;
        this.muteEnd    = muteEnd;
    }

    public UserDTO(Long id, UserType type, UserState state, String name,
                   String email, String phone, String about, String password,
                   boolean isNotified, LocalDateTime muteStart, LocalDateTime muteEnd,
                   Picture pic, ZoneDTO zone, List<Route> routes, List<GeoPointDTO> geoPoints, List<Comment> comments) {
        this(id, type, state, name, email, phone, about, password, isNotified, muteStart, muteEnd);
        this.pic = pic;
        this.zone = zone;
        this.geoPoints = geoPoints;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public UserState getState() {
        return state;
    }

    public UserType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getAbout() {
        return about;
    }

    public Boolean getNotified() {
        return isNotified;
    }

    public LocalDateTime getMuteStart() {
        return muteStart;
    }

    public LocalDateTime getMuteEnd() {
        return muteEnd;
    }

    public Picture getPic() {
        return pic;
    }

    public void setPic(Picture pic) {
        this.pic = pic;
    }

//    public List<Route> getRoutes() {
//        return routes;
//    }
//
//    public void setRoutes(List<Route> routes) {
//        this.routes = routes;
//    }
//
//    public List<Comment> getComments() {
//        return comments;
//    }
//
//    public void setComments(List<Comment> comments) {
//        this.comments = comments;
//    }


    public List<GeoPointDTO> getGeoPoints() {
        return geoPoints;
    }

    public void setGeoPoints(List<GeoPointDTO> geoPoints) {
        this.geoPoints = geoPoints;
    }

    public ZoneDTO getZone() {
        return zone;
    }

    public void setZone(ZoneDTO zone) {
        this.zone = zone;
    }
    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO that = (UserDTO) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
