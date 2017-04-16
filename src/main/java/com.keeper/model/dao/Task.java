package com.keeper.model.dao;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.model.types.TaskState;
import com.keeper.model.types.TaskType;
import com.keeper.util.dao.DatabaseResolver;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Task model implementation
 */
@Entity
@Table(name = DatabaseResolver.TABLE_TASKS, schema = DatabaseResolver.SCHEMA)
public class Task {

    public static final Task EMPTY = new Task((long)TaskType.EMPTY.getValue(), TaskType.EMPTY);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)           private Long id;
    @Column(name = "createDate", nullable = false)                  private Timestamp createDate;
    @Column(name = "lastModifyDate")                                private Timestamp lastModifyDate;
    @Column(name = "topicStarterId", nullable = false)              private Long topicStarterId;
    @Column(name = "type")                                          private TaskType type;
    @Column(name = "state")                                         private TaskState state = TaskState.HIDEN;
    @Column(name = "theme")                                         private String theme;
    @Column(name = "descr")                                         private String descr;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = DatabaseResolver.TABLE_PICMANAGER)
    private String pic;

    @Embedded
    private List<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = DatabaseResolver.TABLE_PARTICINATMAANGER, cascade = CascadeType.ALL)
    private List<Long> participants;

    @Embedded
    private List<Tag> tags;

//    @Column(name = "followersId")                                  private List<Long> followersId;

//    @OneToOne(fetch = FetchType.LAZY)
////    The PrimaryKeyJoinColumn annotation does say that the primary key of the entity is used as the foreign key value to the associated entity.
//    @PrimaryKeyJoinColumn//(name = "geopoint_id")
//    private GeoCoordinate geoPoint;
//
//    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="task")
//    private List<Tag> tags;

//    @OneToOne
//    @JoinColumn(name = "pictureId")
//    private Picture picture;

//    @ManyToMany (mappedBy="task")
//@PrimaryKeyJoinColumns({@PrimaryKeyJoinColumn(),
//        @PrimaryKeyJoinColumn()})
//    List<User> participants

    private Task() {

    }

    private Task(Long id, TaskType type) {
        super();
        this.id = id;
        this.type = type;
    }

    public Task(Long topicStarterId, TaskType type, TaskState state, String theme, String descr) {
        this.topicStarterId = topicStarterId;
        this.type = type;
        this.state = state;
        this.theme = theme;
        this.descr = descr;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public Long getTopicStarterId() {
        return topicStarterId;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
    //</editor-fold>
}
