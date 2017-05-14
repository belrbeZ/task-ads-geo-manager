package com.keeper.service.core;

/*
 * Created by @GoodforGod on 09.05.2017.
 */

import com.keeper.model.dto.TaskDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Default Comment
 */
public interface ISubscription {

    Optional<List<Long>> getTaskSubscribers(Long taskId);

    Optional<Set<Long>> getUserSubscriptions(Long userId);

    /** TRANSACTIONAL */
    Optional<Long> viewTask(Long userId, Long taskId);

    /** TRANSACTIONAL */
    Optional<Long> modifyTask(Long taskId);

    /** TRANSACTIONAL */
    TaskDTO modifyTasksCounter(Long userId, TaskDTO tasks);

    /** TRANSACTIONAL */
    List<TaskDTO> modifyTasksCounter(Long userId, List<TaskDTO> tasks);

    /** TRANSACTIONAL */
    Optional<Long> subscribe(Long userId, Long taskId);

    /** TRANSACTIONAL */
    Optional<Long> unSubscribe(Long userId, Long taskId);
}
