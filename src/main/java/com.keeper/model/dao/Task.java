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

//    @OneToMany(orphanRemoval=true, fetch = FetchType.LAZY)
//    @Fetch(FetchMode.SELECT)
//        @BatchSize(size = 10)
////    Join by taskId in userId
//    @JoinColumn(name="userId", referencedColumnName="id")
//    private List<Picture> pictures;
//
//    @OneToOne(orphanRemoval=true, fetch = FetchType.LAZY)
//    @Fetch(FetchMode.SELECT)
//        @BatchSize(size = 10)
////    The PrimaryKeyJoinColumn annotation does say that the primary key of the entity is used as the foreign key value to the associated entity.
//    @JoinTable(
//            name = DatabaseResolver.TABLE_GEOMANAGER
//            , joinColumns = {
//            @JoinColumn(name = "taskId", referencedColumnName="id")
//    }
//            , inverseJoinColumns={
//            @JoinColumn(name = "geopointId", referencedColumnName="id")
//    }
//    )
//    private GeoPoint originGeoPoint;

//    @ManyToMany (mappedBy="task")
//    //Join by taskId and TagId in tagManager table
//
//    private List<Tag> tags;

//    @OneToMany(orphanRemoval=true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @Fetch(FetchMode.SELECT)
//        @BatchSize(size = 10)
//    //Join by userId in comment table
//    @JoinColumn(name = "task_id", referencedColumnName = "id")
//    private List<Comment> comments;
//
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    //@Join by topicStarteId in User table
//    @JoinColumn(name = "id", referencedColumnName = "topicStarterId")
//    private User topicStarter;
//
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @Fetch(FetchMode.SELECT)
//    @BatchSize(size = 10)
//    //@Join by participant manager usersId and taskId here
//    @JoinTable( name = DatabaseResolver.TABLE_PARTICINATMAANGER,
//                joinColumns = { @JoinColumn(name = "taskId") },
//                inverseJoinColumns={ @JoinColumn(name = "userId") } )
//    private List<User> participants;

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
    //</editor-fold>
}
