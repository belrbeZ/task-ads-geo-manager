package com.keeper.model.dao;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import com.keeper.model.ModelLoggerManager;
import com.keeper.model.types.UserState;
import com.keeper.model.types.UserType;
import com.keeper.util.Hasher;
import com.keeper.util.dao.DatabaseResolver;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Default Comment
 */
@Entity
@Table(name = DatabaseResolver.TABLE_USERS, schema = DatabaseResolver.SCHEMA)
public class User {

    public static final User EMPTY = new User((long)UserType.EMPTY.getValue(), UserType.EMPTY);

    @Id
    @Column(name = "id", unique = true, nullable = false)   private Long id;
    @Column(name = "state")                                 private UserState state;
    @Column(name = "type")                                  private UserType type;
    @Column(name = "name",       nullable = false)          private String name;
    @Column(name = "email",      nullable = false)          private String email;
    @Column(name = "phone")                                 private String phone;
    @Column(name = "password",   nullable = false)          private String password;
    @Column(name = "about")                                 private String about;
    @Column(name = "isNotified")                            private Boolean isNotified;
    @Column(name = "startMuteTime")                         private Timestamp muteStart;
    @Column(name = "endMuteTime")                           private Timestamp muteEnd;

    @OneToOne(fetch = FetchType.LAZY)
    //Join on useirId column in Zone.class
    @PrimaryKeyJoinColumn
    private Zone zone;

    @OneToOne(fetch = FetchType.LAZY)
    //Join on column userId in Pictures table
    @PrimaryKeyJoinColumn
    private Picture pic;

    //Routes must get only if we need it
    @OneToMany(fetch = FetchType.LAZY, mappedBy = DatabaseResolver.TABLE_PARTICINATMAANGER, cascade = CascadeType.ALL)
    //Join on userId in Routes table
    private List<Route> routes;

    //GeoPo must get only if we need it
    @OneToMany(fetch = FetchType.LAZY, mappedBy = DatabaseResolver.TABLE_GEOMANAGER, cascade = CascadeType.ALL)
    //Join on GeoManger userId -> geoPointsId
    private List<GeoPoint> geoPoints;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@Join by topicStarteId
    private List<Task> tasksStarted;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@Join by participantManager userId - TaskId
    private List<Task> tasksParticipanted;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //Join on column userId in Comment.class
    private List<Comment> comments;

    private User() {
        this.id         = (long) UserType.UNKNOWN.getValue();
        this.state      = UserState.UNKNOWN;
        this.type       = UserType.UNKNOWN;
        this.name       = "";
        this.email      = "";
        this.phone      = "";
        this.password   = "";
        this.about      = "";
        this.isNotified = false;
        this.muteStart  = Timestamp.valueOf(LocalDateTime.MIN);
        this.muteEnd    = Timestamp.valueOf(LocalDateTime.MAX);
    }

    private User(Long id, UserType type) {
        super();
        this.id = id;
        this.type = type;
    }

    public User(UserType type, @NotEmpty String name,
                @NotEmpty String email, String phone,
                @NotEmpty String password, String about) {
        this.id         = Hasher.generateHashSimple(email, Hasher.HashType.EMAIL);
        this.state      = UserState.AWAIT_VERIFICATION;
        this.type       = type != null ? type : UserType.USER;
        this.name       = name;
        this.email      = email; //Hasher.generateHashCrypto(email, Hasher.HashType.EMAIL);
        this.phone      = phone;
        this.password   = Hasher.generateHashCrypto(password, Hasher.HashType.PASS);
        this.about      = about;
        this.isNotified = false;
    }

    public User(UserType type, @NotEmpty String name,
                @NotEmpty String email, String phone,
                @NotEmpty String password, String about, boolean isNotified,
                @NotNull LocalDateTime muteStart, @NotNull LocalDateTime muteEnd)
    {
        this(type, name, email, phone, password, about);
        this.isNotified = isNotified;
        this.muteStart  = Timestamp.valueOf(muteStart);
        this.muteEnd    = Timestamp.valueOf(muteEnd);
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

//    public Zone getZone() {
//        return zone;
//    }
//
//    public void setZone(Zone zone) {
//        this.zone = zone;
//    }

    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
