package com.keeper.dto;

import com.keeper.entity.states.TaskState;
import com.keeper.entity.states.TaskType;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alexandr Vasiliev on 29.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */
public class TaskDto implements ModelDto<Long> {


    public static final TaskDto empty = new TaskDto();

    private Long id;

    private Long topicStarterId;

    private TaskType type;

    private TaskState state = TaskState.HIDEN;

    private String theme;

    private String descr;

    private PictureDto pic;

    private Set<String> tags                = new HashSet<>();

    private Set<Long>   participants         = new HashSet<>();

    private Set<Long>   activeParticipants   = new HashSet<>();

    private TaskDto() {}

    public TaskDto(Long topicStarterId, TaskType type, String theme, String descr) {
        this.topicStarterId = topicStarterId;
        this.type = type;
        this.theme = theme;
        this.descr = descr;
    }

    public TaskDto(Long topicStarterId, TaskType type, String theme, String descr, PictureDto pic) {
        this(topicStarterId, type, theme, descr);
        this.pic = pic;
    }

    public TaskDto(Long topicStarterId, TaskType type, String theme, String descr, Set<String> tags) {
        this(topicStarterId, type, theme, descr);
        this.tags = tags;
    }

    public TaskDto(Long topicStarterId, TaskType type, String theme, String descr, PictureDto pic, Set<String > tags) {
        this(topicStarterId, type, theme, descr, pic);
        this.tags = tags;
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

    public PictureDto getPic() {
        return pic;
    }

    public void setPic(PictureDto pic) {
        this.pic = pic;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }



    public Set<Long> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Long> participants) {
        this.participants = participants;
    }

    public Set<Long> getActiveParticipants() {
        return activeParticipants;
    }

    public void setActiveParticipants(Set<Long> activeParticipants) {
        this.activeParticipants = activeParticipants;
    }

    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskDto task = (TaskDto) o;

        return id != null ? id.equals(task.id) : task.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
