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
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "taskId")
    private Picture picture;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @PrimaryKeyJoinColumn(name = "topicStarterId", referencedColumnName = "id")
//    private User topicStarter;

    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 10)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name = "taskId", referencedColumnName = "id")
    private List<Comment> comments;

//    @Fetch(FetchMode.SELECT)
//    @BatchSize(size = 10)
//    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
//    @JoinTable(name = DatabaseResolver.TABLE_GEOMANAGER,
//               joinColumns = @JoinColumn(name = "taskId", referencedColumnName="id"),
//               inverseJoinColumns= @JoinColumn(name = "geopointId", referencedColumnName="id") )
//    private GeoPoint originGeoPoint;

    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 10)
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = DatabaseResolver.TABLE_TAGMANAGER,
            joinColumns = @JoinColumn(name = "taskId", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name = "tagId", referencedColumnName="id") )
    private List<Tag> tags;

    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 10)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = DatabaseResolver.TABLE_PARTICINATMAANGER,
               joinColumns = @JoinColumn(name = "taskId", referencedColumnName = "id"),
               inverseJoinColumns= @JoinColumn(name = "userId", referencedColumnName = "id"))
    private List<User> participants;

    private Task() {
        this.id = 0L;
        this.createDate = Timestamp.valueOf(LocalDateTime.MIN);
        this.lastModifyDate = Timestamp.valueOf(LocalDateTime.MIN);
        this.topicStarterId = 0L;
        this.type = TaskType.EMPTY;
        this.state = TaskState.UNKNOWN;
        this.theme = "";
        this.descr = "";
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

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Timestamp lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public Picture getPicture() {
        return picture;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public List<User> getParticipants() {
        return participants;
    }

    //</editor-fold>
}
