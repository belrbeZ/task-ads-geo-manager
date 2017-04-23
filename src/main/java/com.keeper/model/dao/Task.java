package com.keeper.model.dao;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.model.types.TaskState;
import com.keeper.model.types.TaskType;
import com.keeper.util.resolve.DatabaseResolver;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @Column(name = "originGeoPointId", nullable = false)            private Long originGeoPointId;
    @Column(name = "type")                                          private TaskType type;
    @Column(name = "state")                                         private TaskState state = TaskState.HIDEN;
    @Column(name = "theme")                                         private String theme;
    @Column(name = "descr")                                         private String descr;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "taskId")
    private Picture picture;

    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 10)
    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "originGeoPointId")
    private GeoPoint originGeoPoint;

//    @Fetch(FetchMode.SELECT)
//    @BatchSize(size = 10)
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
//    @JoinColumn(name = "taskId", referencedColumnName = "id")
//    private List<Comment> comments;

//    @Fetch(FetchMode.SELECT)
//    @BatchSize(size = 10)
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinTable(name = DatabaseResolver.TABLE_TAGMANAGER, schema = DatabaseResolver.SCHEMA,
//            joinColumns = @JoinColumn(name = "taskId", referencedColumnName="id"),
//            inverseJoinColumns= @JoinColumn(name = "tagId", referencedColumnName="id") )
//    private List<Tag> tags;

////    @Fetch(FetchMode.SELECT)
////    @BatchSize(size = 10)
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = DatabaseResolver.TABLE_PARTICINATMAANGER, schema = DatabaseResolver.SCHEMA,
//               joinColumns = {@JoinColumn(name = "taskId", referencedColumnName = "id")},
//               inverseJoinColumns= {@JoinColumn(name = "userId", referencedColumnName = "id")})
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

    public Task(Long topicStarterId, Long originGeoPointId, TaskType type, TaskState state, String theme, String descr, Picture picture) {
        this.topicStarterId = topicStarterId;
        this.originGeoPointId = originGeoPointId;
        this.type = type;
        this.state = state;
        this.theme = theme;
        this.descr = descr;
        this.picture = picture;
    }

    public Task(Long topicStarterId, Long originGeoPointId, TaskType type, TaskState state, String theme, String descr,
                Picture picture, List<Comment> comments, GeoPoint originGeoPoint,
                List<Tag> tags, List<User> participants) {
        this(topicStarterId, originGeoPointId, type, state, theme, descr, picture);

//        this.comments = comments;
//        this.tags = tags;
//        this.participants = participants;
//        this.originGeoPoint = originGeoPoint;
        /*this.topicStarter = topicStarter;*/
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public Long getTopicStarterId() {
        return topicStarterId;
    }

    public Long getOriginGeoPointId() {
        return originGeoPointId;
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

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

//    public List<Comment> getComments() {
//        return comments;
//    }
//
//    public List<Tag> getTags() {
//        return tags;
//    }
//
//    public List<User> getParticipants() {
//        return participants;
//    }

//    public void setComments(List<Comment> comments) {
//        this.comments = comments;
//    }

    public GeoPoint getOriginGeoPoint() {
        return originGeoPoint;
    }

    public void setOriginGeoPoint(GeoPoint originGeoPoint) {
        this.originGeoPoint = originGeoPoint;
    }

//    public void setTags(List<Tag> tags) {
//        this.tags = tags;
//    }
//
//    public void setParticipants(List<User> participants) {
//        this.participants = participants;
//    }

    //</editor-fold>

    /*---COMMENTS---*/
//    public int hasComment( Comment comment ) {
//        return comments.indexOf(comment);
//    }
//
//    public void addComment( Comment comment ) {
//        //avoid circular calls : assumes equals and hashcode implemented
//        if ( !comments.contains( comment ) ) {
//            comments.add( comment );
//        }
//    }
//
//    public void removeComment( Comment comment ) {
////        int index;
////        //avoid circular calls : assumes equals and hashcode implemented
////        if ( (index = geoPoints.indexOf( geoPoint )) != -1 ) {
////            geoPoints.get(index);
////            return geoPoints.remove( index );
////        }
////        return geoPoint.getEMPTY();
//        if ( comments.contains( comment )) {
//            comments.remove( comment );
//        } else {
//            throw new IllegalArgumentException("No such comment associated with this Task");//"No such geoPoint /*with id " + geoPoint.getId() + " */associated with User with id "/* + this.getId()*/);
//        }
//    }
    /*---END COMMENTS---*/
}
