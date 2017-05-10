package com.keeper.model.dto;

import com.keeper.model.types.TaskType;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 10.05.2017
 */
public class TaskSubscribersDTO {

    public static final TaskSubscribersDTO EMPTY = new TaskSubscribersDTO();

    private Long taskId;
    private LocalDateTime lastModificationDate;
    private Set<Long> subscribers;

    private TaskSubscribersDTO() {
        this.taskId = TaskType.EMPTY.getValue();
        this.lastModificationDate = LocalDateTime.MIN;
        this.subscribers = Collections.emptySet();
    }

    public TaskSubscribersDTO(Long taskId, LocalDateTime lastModificationDate, Set<Long> subscribers) {
        this.taskId = taskId;
        this.lastModificationDate = lastModificationDate;
        this.subscribers = subscribers;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public LocalDateTime getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(LocalDateTime lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public Set<Long> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<Long> subscribers) {
        this.subscribers = subscribers;
    }
    //</editor-fold>
}
