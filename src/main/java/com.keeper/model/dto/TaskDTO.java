package com.keeper.model.dto;

import com.keeper.model.types.TaskType;
import com.keeper.model.types.UserType;
import com.keeper.model.util.SimpleGeoPoint;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Alexandr Vasiliev on 29.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */
public class TaskDTO implements Comparator<LocalDateTime> {

    public static final TaskDTO EMPTY = new TaskDTO();

    @NotNull private Long id;
    @NotNull private Long topicStarterId;

    private TaskType type;

    @NotEmpty private String theme;
    @NotEmpty private String descr;

    private SimpleGeoPoint geo;
    private Long modifyCount = null;
    private Boolean subscribed = null;

    private LocalDateTime createDate;
    private LocalDateTime lastModifyDate;

    private PictureDTO picture;
    private List<CommentDTO> comments;
    private List<Long> participants;
    private List<TagDTO> tags;

    public TaskDTO() {
        this.id = TaskType.EMPTY.getValue();
        this.createDate     = null;
        this.lastModifyDate = null;
        this.topicStarterId = UserType.EMPTY.getValue();
        this.type = TaskType.EMPTY;
        this.theme = "";
        this.descr = "";
        this.geo = SimpleGeoPoint.EMPTY;
    }

    public TaskDTO(TaskDTO taskDTO) {
        this.id = taskDTO.getId();
        this.createDate     = taskDTO.getCreateDate();
        this.lastModifyDate = taskDTO.getLastModifyDate();
        this.topicStarterId = taskDTO.getTopicStarterId();
        this.type = taskDTO.getType();
        this.theme = taskDTO.getTheme();
        this.descr = taskDTO.getDescr();
        this.geo = taskDTO.getGeo();
    }

    public TaskDTO(Long id, Long topicStarterId, TaskType type, String theme, String descr,
                   SimpleGeoPoint geo) {
        this.id     = id;
        this.topicStarterId = topicStarterId;
        this.type   = type;
        this.theme  = theme;
        this.descr  = descr;
        this.geo    = geo;
    }

    public TaskDTO(Long id, Long topicStarterId, TaskType type, String theme, String descr,
                   SimpleGeoPoint geo, PictureDTO picture,
                   Timestamp createDate, Timestamp lastModifyDate,
                   List<CommentDTO> comments, List<TagDTO> tags) {
        this(id, topicStarterId, type, theme, descr, geo);
        this.createDate     = (createDate != null) ? createDate.toLocalDateTime() : null;
        this.lastModifyDate = (lastModifyDate != null) ? lastModifyDate.toLocalDateTime() : null;
        this.picture        = picture;
        this.comments       = comments;
        this.participants   = participants;
        this.tags           = tags;
    }

    //<editor-fold desc="GetterAndSetter">

    public Boolean getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        this.subscribed = subscribed;
    }

    public Long getModifyCount() {
        return modifyCount;
    }

    public void setModifyCount(Long modifyCount) {
        if(modifyCount != null) {
            subscribed = true;

            if(modifyCount > 0)
                this.modifyCount = modifyCount;
        }
    }

    public SimpleGeoPoint getGeo() {
        return geo;
    }

    public void setGeo(SimpleGeoPoint geo) {
        this.geo = geo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTopicStarterId() {
        return topicStarterId;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(LocalDateTime lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public TaskType getType() {
        return type;
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

    public PictureDTO getPicture() {
        return picture;
    }

    public void setPicture(PictureDTO picture) {
        this.picture = picture;
    }

    public void setTopicStarterId(Long topicStarterId) {
        this.topicStarterId = topicStarterId;
    }

    public List<Long> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Long> participants) {
        this.participants = participants;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    public List<TagDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagDTO> tags) {
        this.tags = tags;
    }

    //</editor-fold>

    @Override
    public int compare(LocalDateTime o1, LocalDateTime o2) {
        return o1.compareTo(o2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskDTO taskDTO = (TaskDTO) o;

        return id.equals(taskDTO.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", topicStarterId=" + topicStarterId +
                ", type=" + type +
                ", theme='" + theme + '\'' +
                ", descr='" + descr + '\'' +
                ", geo=" + geo +
                ", createDate=" + createDate +
                ", lastModifyDate=" + lastModifyDate +
                ", picture=" + picture +
                ", comments=" + comments +
                ", participants=" + participants +
                ", tags=" + tags +
                '}';
    }
}
