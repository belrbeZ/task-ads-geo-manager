package com.keeper.model.dto;

import com.keeper.model.types.TaskType;
import com.keeper.model.types.UserType;
import com.keeper.model.util.SimpleGeoPoint;
import com.keeper.util.validation.annotation.Geo;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

//    @JsonIgnore
    private SimpleGeoPoint geo;

    private Double longitude;
    private Double latitude;
    private Integer radius;

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

        this.latitude = 0.;
        this.longitude = 0.;
        this.radius = 0;
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

        this.latitude = taskDTO.getLatitude();
        this.longitude = taskDTO.getLongitude();
        this.radius = taskDTO.getRadius();
    }

    public TaskDTO(Long id, Long topicStarterId, TaskType type, String theme, String descr,
                   SimpleGeoPoint geo) {
        this.id     = id;
        this.topicStarterId = topicStarterId;
        this.type   = type;
        this.theme  = theme;
        this.descr  = descr;
        this.geo    = geo;

        this.latitude = geo.getLatitude();
        this.longitude = geo.getLongitude();
        this.radius = geo.getRadius();
    }

    public TaskDTO(Long id, Long topicStarterId, TaskType type, String theme, String descr,
                   @Geo String latitude,
                   @Geo String longitude,
                   @NotNull Integer radius) {
        this.id     = id;
        this.topicStarterId = topicStarterId;
        this.type   = type;
        this.theme  = theme;
        this.descr  = descr;

        this.latitude = Double.valueOf(latitude);
        this.longitude = Double.valueOf(longitude);
        this.radius = radius;
    }
    public TaskDTO(Long id, Long topicStarterId, TaskType type, String theme, String descr,
                   @Geo String latitude,
                   @Geo String longitude,
                   @NotNull String radius) {
        this.id     = id;
        this.topicStarterId = topicStarterId;
        this.type   = type;
        this.theme  = theme;
        this.descr  = descr;

        this.latitude = Double.valueOf(latitude);
        this.longitude = Double.valueOf(longitude);
        this.radius = Integer.parseInt(radius);
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

        this.latitude = geo.getLatitude();
        this.longitude = geo.getLongitude();
        this.radius = geo.getRadius();
    }

    public String getPrettyCreateDate() {
        return (createDate != null)
                ? createDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                : "";
    }

     public String getPrettyLastModifyDate() {
         return (lastModifyDate != null)
                 ? lastModifyDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                 : "";
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

//    @JsonDeserialize(using = StringSimpleDeserializer.class)
    public void setGeo(SimpleGeoPoint geo) {
        this.geo = geo;

        this.latitude = geo.getLatitude();
        this.longitude = geo.getLongitude();
        this.radius = geo.getRadius();
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




    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLongitude(@Geo String longtitude) {
        this.longitude = Double.valueOf(longtitude);
    }

    public void setLatitude(@Geo String latitude) {
        this.latitude = Double.valueOf(latitude);
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(@NotNull String radius) {
        this.radius = Integer.parseInt(radius);
    }

    public void setLongitude(Double longtitude) {
        this.longitude = longtitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setRadius(@NotNull Integer radius) {
        this.radius = radius;
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

//    private class StringSimpleDeserializer extends JsonDeserializer<SimpleGeoPoint> {
//        @Override
//        public SimpleGeoPoint deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
//            String valueAsString = "";
//            try {
//                valueAsString = jsonParser.getValueAsString();
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//            int integer = (int) Double.parseDouble(valueAsString);
//            return new SimpleGeoPoint("0.","0.",0);
//        }
//    }
}
