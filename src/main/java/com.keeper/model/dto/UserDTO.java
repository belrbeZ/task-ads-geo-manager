package com.keeper.model.dto;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.keeper.model.types.UserType;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Default Comment
 */
public class UserDTO {

    public static final UserDTO EMPTY = new UserDTO();

    @NotNull
    private Long  id;
    private UserType    type;

    @NotEmpty
    private String      name;

    @Email
    private String      email;
    private String      phone;

    @NotEmpty
    private String      password;

    private String      about;
    private Boolean     notified;

    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime muteEnd;

    private ZoneDTO zone;
    private PictureDTO pic;
    private List<GeoPointDTO> geoPoints;
    private List<RouteDTO> routes;
   /* private List<TaskDTO> participantedTasks;*/

    private UserDTO() {
        this.id         = (long) UserType.UNKNOWN.getValue();
        this.type       = UserType.UNKNOWN;
        this.name       = "";
        this.email      = "";
        this.phone      = "";
        this.password   = "";
        this.about      = "";
        this.notified   = false;
        this.muteEnd    = LocalDateTime.MAX;
    }

    public UserDTO(Long id, UserType type, String name, String email, String phone, String password, String about) {
        this.id         = id;
        this.type       = type;
        this.name       = name;
        this.email      = email;
        this.phone      = phone;
        this.password   = password;
        this.about      = about;
    }

    public UserDTO(Long id, UserType type, String name,
                   String email, String phone, String about, String password,
                   boolean notified, Timestamp muteEnd) {
        this(id, type, name, email, phone, password, about);
        this.notified   = notified;
        this.muteEnd    = (muteEnd == null) ? null : muteEnd.toLocalDateTime();
    }

    public UserDTO(Long id, UserType type, String name,
                   String email, String phone, String about, String password,
                   boolean notified, Timestamp muteEnd,
                   PictureDTO pic, ZoneDTO zone, List<GeoPointDTO> geoPoints,
                   List<RouteDTO> routes) {
        this(id, type, name, email, phone, about, password, notified, muteEnd);
        this.pic = pic;
        this.zone = zone;
        this.geoPoints = geoPoints;
        this.routes = routes;
        /*this.participantedTasks = participantedTasks;*/
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return notified;
    }

    public void setNotified(Boolean notified) {
        this.notified = notified;
    }

    public LocalDateTime getMuteEnd() {
        return muteEnd;
    }

    public void setMuteEnd(LocalDateTime muteEnd) {
        this.muteEnd = muteEnd;
    }

    public PictureDTO getPic() {
        return pic;
    }

    public void setPic(PictureDTO pic) {
        this.pic = pic;
    }

    public List<RouteDTO> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RouteDTO> routes) {
        this.routes = routes;
    }

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
/*
    public List<TaskDTO> getParticipantedTasks() {
        return participantedTasks;
    }

    public void setParticipantedTasks(List<TaskDTO> participantedTasks) {
        this.participantedTasks = participantedTasks;
    }*/

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
